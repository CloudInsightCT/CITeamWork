package cn.com.cloudinsight.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import net.sf.json.JSONObject;

import cn.com.cloudinsight.utils.DbUtils;
import cn.com.cloudinsight.utils.StringUtils;

public class ViewDao {
   
	 private DbUtils db=new DbUtils();
	 private ArrayList list=new ArrayList();
	  Connection con=null;
	  PreparedStatement psmt=null;
	  ResultSet rs=null;
	  
	 public List<String> list_hostGroup(){
		 String sql="select hosts.hostid,host from hosts ,(select proxy_hostid from hosts where proxy_hostid!='') as result where hosts.hostid=result.proxy_hostid";
		try {
			con=db.getCon();
			psmt=con.prepareStatement(sql);
			rs=psmt.executeQuery();
			list.clear();
			while(rs.next()){
				HashMap<String, Object> map=new HashMap<String, Object>();
				map.put("id", rs.getInt("hostid"));
				map.put("host", rs.getString("host"));
				list.add(map);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 
		 
		 return list;
		 
	 }
	 
	 
	 public List<String> list_host(int proxy_hostid){
		 String sql="select name,hostid from hosts where hosts.proxy_hostid=?";
		 try {
			con=db.getCon();
			psmt=con.prepareStatement(sql);
			psmt.setInt(1, proxy_hostid);
			rs=psmt.executeQuery();
			list.clear();
			while(rs.next()){
				HashMap<String, Object> map=new HashMap<String, Object>();
				map.put("name", rs.getString("name"));
				map.put("hostid", rs.getInt("hostid"));
				list.add(map);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 
		return list;
		 
	 }
	 
	 
	 public List<String> getview_Data(JSONObject host) {
			String  sql="select value ,FROM_UNIXTIME(clock,'%H:%i') as time ,items.key_ from history ,items where items.itemid=history.itemid and items.key_ like '%load[percpu,avg5]%' and items.hostid=? and FROM_UNIXTIME(clock)>'2016-05-17'";
					try {
						con=db.getCon();
						psmt=con.prepareStatement(sql);
						
						psmt.setInt(1, Integer.parseInt(host.get("id").toString()) );
						//psmt.setString(2, host.get("time").toString());
					//	psmt.setString(3, StringUtils.getDate(host.get("time").toString()));
						rs=psmt.executeQuery();
						list.clear();
						while(rs.next()){
							HashMap<String, Object> map =new HashMap<String, Object>();
							map.put("time", rs.getString("time"));
							map.put("value", rs.getFloat("value"));
							map.put("key", rs.getString("key_"));
							list.add(map);
						}
					//	System.out.println("dsadsa"+list.size());
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					System.out.println("list="+list.size());
					return list;
		}
}
