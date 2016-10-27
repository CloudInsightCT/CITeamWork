package cn.com.cloudinsight.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.swing.plaf.basic.BasicScrollPaneUI.HSBChangeListener;

import net.sf.json.JSONObject;

import cn.com.cloudinsight.model.Host;
import cn.com.cloudinsight.model.PageBean;
import cn.com.cloudinsight.model.User;
import cn.com.cloudinsight.utils.DbUtils;
import cn.com.cloudinsight.utils.StringUtil;
import cn.com.cloudinsight.utils.StringUtils;

public class HostDao {
    
	 private DbUtils db=new DbUtils();
	 private ArrayList list=new ArrayList();
	  Connection con=null;
	  PreparedStatement psmt=null;
	  ResultSet rs=null;
	  public ArrayList gethost_group(String username,String surname) throws Exception{
		  String sql="select  distinct name,count( name) as num  from(select  distinct items.hostid,items.delay,items.itemid,hosts.host,interface.ip from items,hosts,interface where hosts.hostid=items.hostid and interface.hostid=hosts.hostid and items.key_='icmpping') as result, groups,hosts_groups where groups.groupid=hosts_groups.groupid and result.hostid=hosts_groups.hostid group by name";
		  
			try {
				con=db.getCon();
				psmt=con.prepareStatement(sql);
				list.clear();
				rs=psmt.executeQuery();
				while(rs.next()){
					HashMap<String,Object> map=new HashMap<String,Object>();
					map.put("name", rs.getString("name"));
					map.put("num", rs.getInt("num"));
					
					
					list.add(map);
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		return list;
		  
	  }
	  public List getHost_list(PageBean pageBean,Host s_host,User user){
		  System.out.println("host="+s_host.getHost());
			//String  sql="select distinct items.hostid,items.delay,hosts.host ,data.name,items.status,interface.ip from items,interface, (select * from hosts where hosts.proxy_hostid!='')as data,hosts where data .proxy_hostid=hosts.hostid and data.hostid=items.hostid and items.hostid=interface.hostid ";
		   StringBuffer sb=new StringBuffer("select distinct hosts.hostid,hosts.name,items.delay,interface.ip,hosts.status from hosts,users,users_groups,rights,hosts_groups,items,interface where hosts.hostid=hosts_groups.hostid and hosts_groups.groupid=rights.id and rights.groupid=users_groups.usrgrpid and users_groups.userid=users.userid and hosts.hostid=items.hostid and interface.hostid=hosts.hostid and items.templateid !='' and users.alias='"+user.getAlias()+"' ");
			if(s_host!=null){
				if(StringUtil.isNotEmpty(s_host.getHost())){
					sb.append(" and hosts.name like '%"+s_host.getHost()+"%'");
				}
			}
			if(pageBean!=null){
				sb.append(" limit "+pageBean.getStart()+","+pageBean.getPageSize());
			}
		   try {
				con=db.getCon();
				psmt=con.prepareStatement(sb.toString());
				rs=psmt.executeQuery();
				list.clear();
				while(rs.next()){
					HashMap<String, Object> map=new HashMap<String, Object>();
					map.put("hostid", rs.getInt("hostid"));
					//map.put("proxy", rs.getString("host"));
					map.put("name", rs.getString("name"));
					map.put("ip", rs.getString("ip"));
					map.put("delay", rs.getInt("delay"));
					map.put("status", rs.getInt("status"));
				//	map.put("itemid", rs.getInt("itemid"));
					list.add(map);
				}
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			return list;
			
		}
	  
	  public int count(Host s_host,User user) throws Exception{
		  int total=0;
		  StringBuffer sb=new StringBuffer("select count(distinct hosts.hostid) as count from hosts,users,users_groups,rights,hosts_groups,items,interface where hosts.hostid=hosts_groups.hostid and hosts_groups.groupid=rights.id and rights.groupid=users_groups.usrgrpid and users_groups.userid=users.userid and hosts.hostid=items.hostid and interface.hostid=hosts.hostid and items.templateid !='' and users.alias='"+user.getAlias()+"' ");
			if(s_host!=null){
				if(StringUtil.isNotEmpty(s_host.getHost())){
					sb.append(" and hosts.name like '%"+s_host.getHost()+"%'");
				}
			}
			con=db.getCon();
			psmt=con.prepareStatement(sb.toString());
			rs=psmt.executeQuery();
			if(rs.next()){
				 total=Integer.parseInt(rs.getString("count"));
			}
			//System.out.println("total="+total);
			
		return total;
		  
	  }
		
		public ArrayList getItem(JSONObject item){
			String sql="select distinct key_ from items,history where hostid=? and items.itemid=history.itemid";
			try {
				con=db.getCon();
				psmt=con.prepareStatement(sql);
				psmt.setString(1,item.get("hostid").toString());
				rs=psmt.executeQuery();
				list.clear();
				while(rs.next()){
					HashMap<String, Object> map=new HashMap<String, Object>();
					map.put("key", rs.getString("key_"));
					list.add(map);
				}
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return list;
			
		}
		public ArrayList getHostData(JSONObject jb){
			StringBuffer sb=new StringBuffer("select FROM_UNIXTIME(clock) as time,value ,key_ from items ,history where items.itemid=history.itemid and items.hostid='"+Integer.parseInt(jb.get("hostid").toString())+"' and from_unixtime(clock)>'"+jb.get("preTime").toString()+"' and from_unixtime(clock)<'"+jb.get("time").toString()+"'");
			if(jb.get("key").toString()!=null){
				sb.append(" and key_ like '"+jb.get("key").toString()+"'");
			}
			
		    String  sql="select FROM_UNIXTIME(clock) as time,value ,key_ from items ,history where items.itemid=history.itemid and items.hostid=? and from_unixtime(clock)>? and from_unixtime(clock)<? and key_=?";
		
			try {
				con=db.getCon();
				psmt=con.prepareStatement(sb.toString());
			
				//psmt.setInt(1, Integer.parseInt(jb.get("hostid").toString()));
			//	psmt.setString(2, jb.get("preTime").toString());
			//	psmt.setString(3, jb.get("time").toString());
			//	psmt.setString(4, jb.get("key").toString());
				rs=psmt.executeQuery();
				list.clear();
				while(rs.next()){	
					HashMap<String, Object> map =new HashMap<String, Object>();
					map.put("time", rs.getString("time"));
					map.put("value", rs.getFloat("value"));
					map.put("key", rs.getString("key_"));
					list.add(map);
				}
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			return list;
			
		}
		
		
		public ArrayList getLocalData(JSONObject Itemdata){
			String sql=null;
			
		//	if(id.equals("loss")){
				//System.out.println("sql+=");
				// sql="select  from_unixtime(clock) as time ,value from history,items where items.itemid=history.itemid and items.key_='icmppingloss' and items.hostid=? and from_unixtime(clock)>? and from_unixtime(clock)<? ";
		//	}
		//	if(id.equals("response")){
				 sql="select  from_unixtime(clock) as time ,value from history,items where items.itemid=history.itemid and items.key_=? and items.hostid=? and from_unixtime(clock)>? and from_unixtime(clock)<? ";
		//	}
			try {
				con=db.getCon();
				psmt=con.prepareStatement(sql);
				psmt.setString(1, Itemdata.get("key").toString());
				psmt.setInt(2, Integer.parseInt(Itemdata.get("hostid").toString()) );
				psmt.setString(3, Itemdata.get("time").toString());
				psmt.setString(4, StringUtils.getDate(Itemdata.get("time").toString()));
				rs=psmt.executeQuery();
			//	System.out.println("wode 123");
				list.clear();
				while(rs.next()){
					HashMap<String, Object> map =new HashMap<String, Object>();
					map.put("time", rs.getString("time"));
					map.put("value", rs.getFloat("value"));
					list.add(map);
				}
			//	System.out.println("dsadsa"+list.size());
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			return list;
			
			
		}
		
		
		public ArrayList getTrigger(int hostid){
			String sql="select items.itemid,triggers.expression,triggers.description,functions.function,functions.parameter," +
					"triggers.triggerid ,items.key_,items.name,triggers.status,hosts.host from functions, triggers,items,hosts " +
					"where functions.itemid=items.itemid and functions.triggerid=triggers.triggerid and hosts.hostid=items.hostid and items.hostid=?";
			list.clear();
			try {
				con=db.getCon();
				psmt=con.prepareStatement(sql);
				psmt.setInt(1, hostid);
				rs=psmt.executeQuery();
				while(rs.next()){
					HashMap<String, Object> map=new HashMap<String, Object>();
					map.put("itemid", rs.getInt("itemid"));
					map.put("description", rs.getString("description"));
					map.put("function", rs.getString("function"));
					map.put("parameter", rs.getString("parameter"));
					map.put("triggerid", rs.getInt("triggerid"));
					map.put("key_", rs.getString("key_"));
					map.put("name", rs.getString("name"));
					map.put("status", rs.getInt("status"));
					map.put("host", rs.getString("host"));
					list.add(map);
				}
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return list;
			
		}
		
		public List<String> getAmHost_list(String name) {
			String sql="select  distinct items.hostid,items.delay,items.itemid,hosts.host,interface.ip from(select hosts_groups.hostid from hosts_groups,groups where groups.groupid=hosts_groups.groupid and groups.name=?)as result, items,hosts,interface where hosts.hostid=items.hostid and interface.hostid=hosts.hostid and items.key_='icmpping' and result.hostid=interface.hostid limit 6";
			
			 try {
					con=db.getCon();
					psmt=con.prepareStatement(sql);
					psmt.setString(1, name);
					rs=psmt.executeQuery();
					list.clear();
					while(rs.next()){
						HashMap<String, Object> map=new HashMap<String, Object>();
						map.put("hostid", rs.getInt("hostid"));
						map.put("host", rs.getString("host"));
						map.put("ip", rs.getString("ip"));
						map.put("delay", rs.getInt("delay"));
						map.put("itemid", rs.getInt("itemid"));
						list.add(map);
					}
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				return list;
		}
		public List<String> getlocal_Data(JSONObject host) {
			String  sql="select FROM_UNIXTIME(clock) as time,value ,key_ from items ,history where items.itemid=history.itemid and items.hostid=? and from_unixtime(clock)>? and from_unixtime(clock)<? ";
					try {
						con=db.getCon();
						psmt=con.prepareStatement(sql);
						
						psmt.setInt(1, Integer.parseInt(host.get("hostid").toString()) );
						psmt.setString(2, host.get("time").toString());
						psmt.setString(3, StringUtils.getDate(host.get("time").toString()));
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
					
					return list;
		}
	
		public List<String> getItems(PageBean pageBean,String hostid) {
			// TODO Auto-generated method stub
			StringBuffer sb=new StringBuffer("select itemid,name ,delay,history,status from items where hostid='"+hostid+"'");
			
			if(pageBean!=null){
				sb.append(" limit "+pageBean.getStart()+","+pageBean.getPageSize());
			}
			try {
				con=db.getCon();
				psmt=con.prepareStatement(sb.toString());
				rs=psmt.executeQuery();
				list.clear();
				while(rs.next()){
					HashMap<String, Object> map =new HashMap<String, Object>();
					map.put("itemid", rs.getInt("itemid"));
					map.put("name", rs.getString("name"));
					map.put("delay", rs.getInt("delay"));
					map.put("history", rs.getInt("history"));
					map.put("status", rs.getInt("status"));
					list.add(map);
				}
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return list;
		}
		public int getItemsNum(String hostid) throws Exception {
			int total=0;
			String sql="select count(name) as count from items where hostid='"+hostid+"'";
			con=db.getCon();
			psmt=con.prepareStatement(sql);
			rs=psmt.executeQuery();
			if(rs.next()){
				total=rs.getInt("count");
			}
			return total;
		}
		public List<String> getMoreInfo(int itemid, String preTime,
				String time, String id) {
			
			list.clear();
	
			String	 sql="select  from_unixtime(clock) as time ,value,name,units from history,items where items.itemid=history.itemid and items.itemid=? and from_unixtime(clock)>? and from_unixtime(clock)<? ";

			try {
				con=db.getCon();
				psmt=con.prepareStatement(sql);
				psmt.setInt(1,itemid);
				psmt.setString(2, preTime);
				psmt.setString(3, time);
				rs=psmt.executeQuery();
				while(rs.next()){
					HashMap<String, Object> map =new HashMap<String, Object>();
					map.put("time", rs.getString("time"));
					map.put("value", rs.getFloat("value"));
					map.put("name", rs.getString("name"));
					map.put("units", rs.getString("units"));
					list.add(map);
				}
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			return list;
		}
		public List<String> getNow_data(int itemid, String time, String id) {
		
			
			
			String  sql="select  from_unixtime(clock) as time ,value,name,units from history,items where items.itemid=history.itemid  and items.itemid=? and from_unixtime(clock)>? and from_unixtime(clock)<? ";
		
			try {
				con=db.getCon();
				psmt=con.prepareStatement(sql);
				psmt.setInt(1, itemid);
				psmt.setString(2, time);
				psmt.setString(3, StringUtils.getDate(time));
				rs=psmt.executeQuery();
			
				list.clear();
				while(rs.next()){
					HashMap<String, Object> map =new HashMap<String, Object>();
					map.put("time", rs.getString("time"));
					map.put("value", rs.getFloat("value"));
					map.put("name", rs.getString("name"));
					map.put("units", rs.getString("units"));
					list.add(map);
				}
			
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			return list;	
		}
		
	
		
}
