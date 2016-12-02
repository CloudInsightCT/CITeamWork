package cn.com.cloudinsight.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import cn.com.cloudinsight.model.HttpTest;
import cn.com.cloudinsight.model.User;
import cn.com.cloudinsight.utils.DbUtils;
import cn.com.cloudinsight.utils.StringUtils;

public class UserDao {
	 private DbUtils db=new DbUtils();
	 private ArrayList list=new ArrayList();
	  Connection con=null;
	  PreparedStatement psmt=null;
	  ResultSet rs=null;
		public User login(User user) {
			
			String sql="select * from users where name=? and alias=?";
			User u=new User();
			try {
				con=db.getCon();
				psmt=con.prepareStatement(sql);
				psmt.setString(1, user.getUserName());
				psmt.setString(2, user.getPassWord());
				rs=psmt.executeQuery();
				if(rs.next()){
					
					u.setUserName(rs.getString("name"));
					u.setSurName(rs.getString("surname"));
					u.setAlias(rs.getString("alias"));
				}
			} catch (Exception e) {
				e.printStackTrace();
				
			}
			return u;
		}
		
		
			
		
		
}
