package com.sicdlib.dao.imple;




import com.alibaba.fastjson.JSON;
import com.eharmony.pho.query.criterion.Restrictions;
import com.eharmony.pho.query.criterion.expression.RangeExpression;
import org.apache.avro.generic.GenericData;
import org.json.JSONObject;
import com.eharmony.pho.api.DataStoreApi;
import com.eharmony.pho.query.builder.QueryBuilder;
import com.google.common.collect.Lists;
import com.google.gson.Gson;
import com.sicdlib.dao.IBaseDAO;
import com.sicdlib.dao.ICalendarDao;
import com.sicdlib.dto.TbTableEntity;
import com.sicdlib.util.HBaseUtil.HBaseData;
import net.sf.json.JSONArray;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;
import java.lang.*;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import com.sicdlib.util.EntityUtil.EntityInfo;

import static com.eharmony.pho.query.criterion.Restrictions.between;

@Repository("calendarDao")
public class CalendarDao implements ICalendarDao {
    @Autowired
    private IBaseDAO baseDAO;
    private TbTableEntity tbtableentity;

    @Autowired
    @Qualifier("entityInfo")
    EntityInfo entityInfo;

    @Autowired
    DataStoreApi dataStoreApi;
//    //原来查mysql获取表名对应的实体类名,然后反射成实体类,得到其实例
//    public Object getEntity(String tablename){
//        //去掉传进来的字符串中的单引号
//        String newTableEntity=tablename.replaceAll("\'","");
//        System.out.println(newTableEntity);
//        String sql ="SELECT entityName FROM tb_table WHERE table_name = '"+ newTableEntity +"'";
//        List result = baseDAO.getSqlList(sql);
//        String entityname=(String)result.get(0);
//        //反射获得类的对象
//        Object tbTableEntity = null;
//        try {
//            Class<?> TBTableEntityType =Class.forName("com.sicdlib.dto.entity."+entityname);
//            tbTableEntity = TBTableEntityType.newInstance();
//
//        } catch (ClassNotFoundException e) {
//            e.printStackTrace();
//        } catch (IllegalAccessException e) {
//            e.printStackTrace();
//        } catch (InstantiationException e) {
//            e.printStackTrace();
//        }
//        return tbTableEntity;
//    }
    //num是查询的行数
    public List queryResult(String tablename,int num){
        try{
        String name = entityInfo.getEntityInfo(tablename.replaceAll("\'",""));
        Class<?> TBTableEntityType =Class.forName("com.sicdlib.dto.phoenixEntity."+name);
        List headJson=Lists.newArrayList(dataStoreApi.findAll(QueryBuilder
                .builderFor(TBTableEntityType)
                .setMaxResults(num)
                .select().build()));
        return headJson;
    } catch (Exception e) {
        e.printStackTrace();
        return null;
    }
    }
    //没用这个函数
    public List getThead(String tablename){
        //直接用getEntity(tablename);
        try {
            //原来直接查hbase数据库的代码
            //            HBaseData hBaseData = new HBaseData(tablename.replaceAll("\'",""));
            //            List<String> fields = hBaseData.getKeys(tablename.replaceAll("\'",""));
            //            System.out.println(fields);
            //            return fields;

            List headJson=queryResult(tablename,20);
            Gson gson = new Gson();
            String strHead = gson.toJson(headJson);
            strHead = strHead.replace("[","");
            strHead = strHead.replace("]","");

            //
//            StringBuilder sb = new StringBuilder();
            List headResult=new ArrayList();
            org.json.JSONObject jsonObject = new org.json.JSONObject(strHead);
            Iterator iteratorHead = jsonObject.keys();
            while(iteratorHead.hasNext()){
                String key = (String) iteratorHead.next();
                headResult.add(key);
//                sb.append("="+jsonObject.getString(key));
            }
//            return headResult;
            return null;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }

    }
    public List getTbody(String tablename){
//        String entityname = getEntity(tablename);

            List bodyJson=queryResult(tablename,100);
            List bodyResult = new ArrayList(100);
            //获得表头
            List headResult=new ArrayList();
            try{
                org.json.JSONObject jsonHead = new org.json.JSONObject(bodyJson.get(2));

            Iterator iteratorHead = jsonHead.keys();
            while(iteratorHead.hasNext()){
                String key = (String) iteratorHead.next();
                headResult.add(key);
    //                sb.append("="+jsonObject.getString(key));
            }
            }catch (Exception e){
                e.printStackTrace();
        }
            //获得表的内容，也就是json的值
            for(int i=0;i<bodyJson.size();i++) {
                //list转json类型字符串
//                Gson gson = new Gson();
//                String strBody = gson.toJson(bodyJson.get(i));
//                strBody = strBody.replace("[", "");
//                strBody = strBody.replace("]", "");

                //
//            StringBuilder sb = new StringBuilder();

                org.json.JSONObject jsonObject = new org.json.JSONObject(bodyJson.get(i));
                Iterator iterator = jsonObject.keys();
                while (iterator.hasNext()) {
                    String key = (String) iterator.next();
                    //result.add(key);
                    bodyResult.add(jsonObject.getString(key));
                }
            }
            List result =new ArrayList();
            result.add(headResult);
            result.add("+");
            result.add(bodyResult);
            return result;

    }
}
