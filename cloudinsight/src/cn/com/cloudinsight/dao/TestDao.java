package cn.com.cloudinsight.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import cn.com.cloudinsight.model.TestItem;
import cn.com.cloudinsight.utils.DbUtils;

public class TestDao {
	 private DbUtils db=new DbUtils();
	 private ArrayList list=new ArrayList();
	  Connection con=null;
	  PreparedStatement psmt=null;
	  ResultSet rs=null;
	  public TestItem getItem(TestItem item) throws Exception{
		String sql="insert into test_item (userid,exter_ip,inter_ip,testitem,testmodel,testpassword,port,ostype,email) values (?,?,?,?,?,?,?,?,?)";
		con=db.getCon();
		System.out.println("itemid="+item.getTest_exter_ip());
       psmt=con.prepareStatement(sql);
       psmt.setInt(1, item.getUserid());
       psmt.setString(2, item.getTest_exter_ip());
       psmt.setString(3, item.getTest_inter_ip());
       psmt.setString(4, item.getTestitem());
       psmt.setString(5, item.getTestmodel());
       psmt.setString(6, item.getTestpassword());
       psmt.setInt(7, item.getPort());
       psmt.setString(8, item.getOstype());
       psmt.setString(9, item.getEmail());
       psmt.executeUpdate();
       con.close();
       sql="select max(itemid) as itemid from test_item where userid=? and exter_ip=? and inter_ip=? and testitem=? and testmodel=? and testpassword=? and port=? and ostype=? and email=?";
		con=db.getCon();
		psmt=con.prepareStatement(sql);
		 psmt.setInt(1, item.getUserid());
	       psmt.setString(2, item.getTest_exter_ip());
	       psmt.setString(3, item.getTest_inter_ip());
	       psmt.setString(4, item.getTestitem());
	       psmt.setString(5, item.getTestmodel());
	       psmt.setString(6, item.getTestpassword());
	       psmt.setInt(7, item.getPort());
	       psmt.setString(8, item.getOstype());
	       psmt.setString(9, item.getEmail());
	       rs=psmt.executeQuery();
	       TestItem ite=new TestItem();
	       if(rs.next()){
	    	  
	    	  ite.setItemid(rs.getInt("itemid"));
	    	  
	       }
       return ite;
		  
	  }
	  
}
