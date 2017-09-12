package com.sicdlib.util.stockUtil;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.TreeMap;

public class Connect_stock {

	static public TreeMap<String, TreeMap<String,String>> connect(String base,String start,String end){
		
		TreeMap<String, TreeMap<String,String>> hs = new TreeMap<String, TreeMap<String, String>>();
		String driver = "com.mysql.jdbc.Driver";
		//localhost指本机，也可以用本地ip地址代替，3306为MySQL数据库的默认端口号
		String url = "jdbc:mysql://localhost:3306/"+base;
		//填入数据库的用户名跟密码
		String username = "root";
		String password = "root";
		
		String sql = "select close,date,stock_name,first_category from "+base +" where date between "+"'"+start+"'"+" and "+"'"+end+"'" ;//编写要执行的sql语句，此处为从表中查询所有用户的信息
		System.out.println(sql);
		try
		{
		Class.forName(driver);//加载驱动程序，此处运用隐式注册驱动程序的方法
		}
		catch(ClassNotFoundException e)
		{
		e.printStackTrace();
		}
		try
		{
		Connection con = DriverManager.getConnection(url,username,password);//创建连接对象
		Statement st = con.createStatement();//创建sql执行对象
		ResultSet rs = st.executeQuery(sql);//执行sql语句并返回结果集	
		
		while(rs.next())//对结果集进行遍历输出
		{	
			String stock_name = rs.getString("stock_name")+" "+rs.getString("first_category");
			String date = rs.getString("date");
			String close = rs.getString("close");		
			if(hs.get(stock_name)==null){			
				TreeMap<String, String> hs_index = new TreeMap<String, String>();
				hs_index.put(date, close);
				hs.put(stock_name, hs_index);
			}
			else{
				TreeMap<String, String> hs_index = hs.get(stock_name);
				hs_index.put(date, close);
			}
//		System.out.println(""+base+rs.getString(2));//通过列的标号来获得数据
//		System.out.println("useradd: "+rs.getString("closep"));//通过列名来获得数据
//		System.out.println("userage: "+rs.getInt("userage"));
		}
	
	//	System.out.println(base+" "+data_base.get(4).size());
		//关闭相关的对象
		if(rs != null)
		{
		try
		{
		rs.close();
		}
		catch(SQLException e)
		{
		e.printStackTrace();
		}
		}
		if(st != null)
		{
		try
		{
		st.close();
		}
		catch(SQLException e)
		{
		e.printStackTrace();
		}
		}
		if(con !=null)
		{
		try
		{
		con.close();
		}
		catch(SQLException e)
		{
		e.printStackTrace();
		}
		}
		}
		catch(SQLException e)
		{
		e.printStackTrace();
		}
		return hs;
	}
	
static public TreeMap<String, TreeMap<String,String>> connect2(String base,String table, String start,String end){
		
		TreeMap<String, TreeMap<String,String>> hs = new TreeMap<String, TreeMap<String, String>>();
		String driver = "com.mysql.jdbc.Driver";
		//localhost指本机，也可以用本地ip地址代替，3306为MySQL数据库的默认端口号
		String url = "jdbc:mysql://localhost:3306/"+base;
		//填入数据库的用户名跟密码
		String username = "root";
		String password = "root";
		
		String sql = "select close,date,stock_name,first_category from "+table +" where date between "+"'"+start+"'"+" and "+"'"+end+"'" ;//编写要执行的sql语句，此处为从表中查询所有用户的信息
		System.out.println(sql);
		try
		{
		Class.forName(driver);//加载驱动程序，此处运用隐式注册驱动程序的方法
		}
		catch(ClassNotFoundException e)
		{
		e.printStackTrace();
		}
		try
		{
		Connection con = DriverManager.getConnection(url,username,password);//创建连接对象
		Statement st = con.createStatement();//创建sql执行对象
		ResultSet rs = st.executeQuery(sql);//执行sql语句并返回结果集	
		
		while(rs.next())//对结果集进行遍历输出
		{	
			String stock_name = rs.getString("stock_name");
			String date = rs.getString("date");
			String close = rs.getString("close");		
			if(hs.get(stock_name)==null){			
				TreeMap<String, String> hs_index = new TreeMap<String, String>();
				hs_index.put(date, close);
				hs.put(stock_name, hs_index);
			}
			else{
				TreeMap<String, String> hs_index = hs.get(stock_name);
				hs_index.put(date, close);
			}
//		System.out.println(""+base+rs.getString(2));//通过列的标号来获得数据
//		System.out.println("useradd: "+rs.getString("closep"));//通过列名来获得数据
//		System.out.println("userage: "+rs.getInt("userage"));
		}
	
	//	System.out.println(base+" "+data_base.get(4).size());
		//关闭相关的对象
		if(rs != null)
		{
		try
		{
		rs.close();
		}
		catch(SQLException e)
		{
		e.printStackTrace();
		}
		}
		if(st != null)
		{
		try
		{
		st.close();
		}
		catch(SQLException e)
		{
		e.printStackTrace();
		}
		}
		if(con !=null)
		{
		try
		{
		con.close();
		}
		catch(SQLException e)
		{
		e.printStackTrace();
		}
		}
		}
		catch(SQLException e)
		{
		e.printStackTrace();
		}
		return hs;
	}

}
