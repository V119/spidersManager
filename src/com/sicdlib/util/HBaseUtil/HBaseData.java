package com.sicdlib.util.HBaseUtil;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.hbase.HTableDescriptor;
import org.apache.hadoop.hbase.KeyValue;
import org.apache.hadoop.hbase.client.*;
import org.apache.hadoop.hbase.client.coprocessor.AggregationClient;
import org.apache.hadoop.hbase.client.coprocessor.LongColumnInterpreter;
import org.apache.hadoop.hbase.filter.Filter;
import org.apache.hadoop.hbase.filter.FirstKeyOnlyFilter;
import org.apache.hadoop.hbase.filter.PageFilter;
import org.apache.hadoop.hbase.util.Bytes;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class HBaseData {

    private static Configuration conf = Config.getConf();
    private Admin admin = ConnectionFactory.createConnection(conf).getAdmin();
    private HTable htable = null;
    //开始的行
    private static byte[] startRow = null;
    private byte[] stopRow = null;
    static {
        conf = Config.getConf();
    }
    //得到开始的行
    public byte[] getStartRow(){
        return startRow;
    }

    public static void setConf(Configuration conf) {
        HBaseData.conf = conf;
    }

    public Admin getAdmin() {
        return admin;
    }

    public void setAdmin(Admin admin) {
        this.admin = admin;
    }

    public void setHtable(HTable htable) {
        this.htable = htable;
    }

    public static void setStartRow(byte[] startRow) {
        HBaseData.startRow = startRow;
    }

    public byte[] getStopRow() {
        return stopRow;
    }

    public void setStopRow(byte[] stopRow) {
        this.stopRow = stopRow;
    }

    //得到配置参数
    public Configuration getConf(){
        return conf;
    }
    //无参构造函数
    public HBaseData(String htable_name) throws IOException {
        htable = new HTable(conf, htable_name);
    }
    //获得HTable
    public HTable getHtable(){
        return htable;
    }

    //得到HTable表中所有数据
    public ResultScanner getAllData() throws Exception {
        Scan scan = new Scan();
//        //每页展示条数--20条
//        Filter filter = new PageFilter(20);
//        scan.setFilter(filter);
        ResultScanner results = htable.getScanner(scan);

//        int i = 0;
//        //输出结果
//        for (Result result : results) {
//            for (KeyValue rowKV : result.raw()) {
//                i++;
//                String qualifer = new String(rowKV.getQualifier());
//                String value = new String(rowKV.getValue());
//                System.out.print(i+":"+qualifer+":"+value+"\t");
//            }
//            System.out.println();
//        }
        return results;
    }

    /**
     * 得到第1页数据
     * @param page,提供 pageSize 页面大小
     * @return
     * @throws IOException
     */
    public List getFirstPage(HBPage page) throws IOException{
        List list = new ArrayList<>();
        Filter filter = new PageFilter(page.getPageSize() + 1);
        Scan scan = new Scan();
        scan.setFilter(filter);
        //存放多行数据
        ResultScanner rs = htable.getScanner(scan);
        int count = 0;
        //取得一行数据（类似于Mysql中的一条记录）
        for (Result r : rs){
            count ++;
            if(count == page.getPageSize() + 1){
                startRow = r.getRow();
//                stopRow = r.getRow();
                break;
            }

            list.add(r);
        }
        return list;
    }

    /**
     * 得到下一页的数据
     * @param page 提供pageSize，PageStartRowKey
     * @return
     * @throws IOException
     */
    public List getNext(HBPage page) throws IOException{
        System.out.println("getNext下一页！"+page.getPageStartRowKey());
        Filter filter = new PageFilter(page.getPageSize() + 1);
        Scan scan = new Scan();
        scan.setFilter(filter);
        scan.setStartRow(page.getPageStartRowKey());
        ResultScanner result = htable.getScanner(scan);
        List list = new ArrayList<>();
        int count = 0;
        for (Result r : result){
            count++;
            if (count == page.getPageSize() + 1){
                startRow = r.getRow();
                break;
            }
            list.add(r);
        }

       for (int i = 0;i < list.size(); i++){
            Result r = (Result) list.get(i);
            for (KeyValue keyValue : r.list()){
                String qualifier = new String(keyValue.getQualifier(), "utf-8");
                String value = new String(keyValue.getValue(), "utf-8");
            }
       }

        return list;
    }

    /**
     * 获得前一页数据
     * @param page 提供 开始位置，大小
     * @return
     * @throws IOException
     */
    public List getPrePage(HBPage page) throws IOException{
        System.out.println("getNext前一页！" + page.getNextPage());
        Filter filter = new PageFilter(page.getPageSize() + 1);
        //nextpage为0时，表示上一动作是上一页
        if(page.getPrePage() == 0){
            filter = new PageFilter(page.getPageSize() + 1);
        }
        //nextpage为1时，表示上一动作是下一页
        if(page.getPrePage() == 1){
            filter = new PageFilter(page.getPageSize() * 2 + 1);
        }
        Scan scan = new Scan();
        //倒序查询数据
        scan.setReversed(true);
        scan.setFilter(filter);
        scan.setStartRow(page.getPageStartRowKey());
        ResultScanner result = htable.getScanner(scan);
        List list = new ArrayList<>();
        int count = 0;
        for (Result r : result){
            count ++;
            //nextpage为0时，表示上一动作是上一页
            if (page.getNextPage() == 0){
                if (count == page.getPageSize() + 1){
                    startRow = r.getRow();
                    break;
                }
                list.add(r);
            }
            //nextpage为1时，表示上一动作是下一页
            if (page.getNextPage() == 1){
                if (count == page.getPageSize()*2 + 1){
                    startRow = r.getRow();
                }
                if (count == page.getPageSize()*2 + 2){
                    break;
                }
                //去掉第一个结果（Result）
                else if(count >= page.getPageSize() + 1){
                    list.add(r);
                    System.out.println("去掉第一个结果（Result）");
                }
            }
            if (count == page.getPageSize() + 1){
                startRow = r.getRow();
            }
            if (count == page.getPageSize() + 2){
                break;
            }
            //去掉第一个结果（Result）
            else if(count > 1){
                list.add(r);
            }
        }
        //倒序输出
        Collections.reverse(list);

        return list;
    }


    /**
     *得到HTable表中最后数据
     * @param pageSize  最后一页大小
     * @return
     * @throws Exception
     */
    public List getlastData(int pageSize) throws Exception {
        Scan scan = new Scan();
        scan.setReversed(true);
        //每页展示条数--pageSize条
        Filter filter = new PageFilter(pageSize + 1);
        scan.setFilter(filter);
        ResultScanner result = htable.getScanner(scan);
        List list = new ArrayList<>();
        int count = 0;
        for (Result r : result){
            count++;
            if (count == pageSize + 1){
                startRow = r.getRow();
                scan.setStartRow(startRow);
                break;
            }else{
                list.add(r);
            }
            startRow = r.getRow();

        }
        return list;
    }

    /**
     * 获得表的总行数
     * @return
     */
    public long getRowCount() {
        long rowCount = 0;
        try {
            Scan scan = new Scan();
            scan.setFilter(new FirstKeyOnlyFilter());
            ResultScanner resultScanner = htable.getScanner(scan);
            for (Result result : resultScanner) {
                rowCount += result.size();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return rowCount;
    }

    /**
     * 获得表的键名
     * @return
     * @throws Exception
     */
    public List getKeys(String htable_name) throws Exception{
        List field = new ArrayList<String>();
        try {
            HBaseData hBaseData = new HBaseData(htable_name);
            int pageNo = 1;
            HBPage page = new HBPage();
            page.setNextPage(1);
            page.setPageSize(2);
            //1条数据
            List list = hBaseData.getFirstPage(page);
            List<String[]> values_list = new ArrayList<String[]>();
            //获得字段名、源数据
            for (int i = 0; i < 1 && i < list.size(); i++){
                Result result = (Result) list.get(i);
                for (KeyValue kv : result.list()){
                    if (i<1){
                        field.add(new String(kv.getQualifier(), "utf-8"));
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return field;
    }

    /**
     * 获得列族名称(类MySQL中的表名)
     *     包含了表的名字极其对应表的列族
     */
    public static void getHTableDescriptor(String table){
        HTableDescriptor htd = new HTableDescriptor(table);
        String table_name = new String(htd.getName());
        System.out.println(table_name);
    }

    /**
     * 维护着关于列族的信息，例如版本号，压缩设置等。
     * 它通常在创建表或者为表添加列族的时候使用。
     * 列族被创建后不能直接修改，只能通过删除然后重新创建的方式。
     * 列族被删除的时候，列族里面的数据也会同时被删除。
     * @param tablename
     */
    public static void getHColumnDescriptor(String tablename){
        HTableDescriptor htd = new HTableDescriptor(tablename);
        String name = new String(htd.getName());
        System.out.println(name);
    }

    public static void main(String[] args) {
        try {
            HBaseData inf = new HBaseData("bbs_china_author");
//            inf.getAllData("bbs_china_author");
            HBPage page = new HBPage();
            page.setPageSize(10);
            //第一页，10条数据
            List list = inf.getFirstPage(page);
            //获得下一页
            page.setPageStartRowKey(inf.getStartRow());
//            page.setPageSize(10);
            inf.getNext(page);

//            page.setPageSize(10);
//            page.setPageStartRowKey(inf.getStartRow());
//            inf.getNext(page);

//            page.setPageStartRowKey(inf.getStartRow());
//            page.setPageSize(20);
//            inf.getNext(page);
            for (int i = 0;i < list.size(); i++){
                Result result = (Result) list.get(i);
                for (KeyValue keyValue : result.list()){
                    String qualifier = new String(keyValue.getQualifier(), "utf-8");
                    String value = new String(keyValue.getValue(), "utf-8");
                    System.out.println("list中 列："+qualifier+":"+value);
                }
            }
//            page.setNextPage(10);
//            page.setPageStartRowKey(inf.getStartRow());
            //下一页
            List listNext = inf.getNext(page);
            Long rowcount = inf.getRowCount();
            System.out.println("总数："+rowcount+":"+rowcount%200);
            /*List<String> list1 = inf.getKeys("bbs_china_author");
            for (String str : list1){
                System.out.println(str);
            }*/
            System.exit(0);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }


}
