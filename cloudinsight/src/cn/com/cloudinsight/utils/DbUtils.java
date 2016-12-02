package cn.com.cloudinsight.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbUtils {
   
	public Connection getCon() throws Exception{
		Class.forName(PropertiUtils.getValue("jdbcName"));
		Connection con=DriverManager.getConnection(PropertiUtils.getValue("dbUrl"), PropertiUtils.getValue("dbUserName"), PropertiUtils.getValue("dbPassword"));
		return con;
		
		
	}
    public void closeCon(Connection con)throws Exception{
		if(con!=null){
			con.close();
		}
	}
	public static void main(String args[]){
		DbUtils db=new DbUtils();
		try {
			db.getCon();
			System.out.println("连接成功");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("连接失败");
		}
		
	}
}
