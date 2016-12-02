package cn.com.cloudinsight.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;

import cn.com.cloudinsight.model.Host;
import cn.com.cloudinsight.model.PageBean;
import cn.com.cloudinsight.model.Trigger;
import cn.com.cloudinsight.model.User;
import cn.com.cloudinsight.utils.DbUtils;
import cn.com.cloudinsight.utils.StringUtil;
import cn.com.cloudinsight.utils.StringUtils;

public class AlarmDao {
     
	
	 private DbUtils db=new DbUtils();
	 private ArrayList list=new ArrayList();
	  Connection con=null;
	  PreparedStatement psmt=null;
	  ResultSet rs=null;
	  
	  public ArrayList<String> getAlarm_list(PageBean pageBean,Host s_host,User user){
		  StringBuffer sb=new StringBuffer("select from_unixtime(lastchange) as time,description,priority,result.name from(select distinct hosts.hostid,hosts.name , itemid from hosts,users,users_groups,rights,hosts_groups,items where hosts.hostid=hosts_groups.hostid and hosts_groups.groupid=rights.id and rights.groupid=users_groups.usrgrpid and users_groups.userid=users.userid    and hosts.hostid=items.hostid and users.alias='"+user.getAlias()+"')as result ,functions,triggers where triggers.triggerid=functions.triggerid and result.itemid=functions.itemid ");
			if(s_host!=null){
				if(StringUtil.isNotEmpty(s_host.getName())){
					sb.append(" and result.name like '%"+s_host.getName()+"%'");
				}
			}
		//	sb.append(")as result ,functions,triggers where triggers.triggerid=functions.triggerid and result.itemid=functions.itemid  and from_unixtime(lastchange)>'2015-01-01' order by from_unixtime(lastchange) desc");
		
			if(pageBean!=null){
				sb.append(" limit "+pageBean.getStart()+","+pageBean.getPageSize());
			}
	
		//		sql="select from_unixtime(lastchange) as time,description,priority,name,host  from(select  items.itemid,hosts.name,hosts.host,hosts.hostid from items,hosts,interface where hosts.hostid=items.hostid and interface.hostid=hosts.hostid ) as result ,functions,triggers where triggers.triggerid=functions.triggerid and result.itemid=functions.itemid and from_unixtime(lastchange)<? order by from_unixtime(lastchange) desc limit 10";
			try {
				con=db.getCon();
				psmt=con.prepareStatement(sb.toString());
				//psmt.setString(1, StringUtils.getTime(new Date()));
				rs=psmt.executeQuery();
				list.clear();
				while(rs.next()){
					HashMap<String, Object> map=new HashMap<String, Object>();
					map.put("host", rs.getString("name"));
					map.put("description", StringUtils.getAlam_des(rs.getString("description"), rs.getString("name")));
					map.put("priority", rs.getInt("priority"));
					map.put("time", rs.getString("time"));
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
		  StringBuffer sb=new StringBuffer("select count(result.name) as count from(select distinct hosts.hostid,hosts.name , itemid from hosts,users,users_groups,rights,hosts_groups,items where hosts.hostid=hosts_groups.hostid and hosts_groups.groupid=rights.id and rights.groupid=users_groups.usrgrpid and users_groups.userid=users.userid    and hosts.hostid=items.hostid and users.alias='"+user.getAlias()+"')as result ,functions,triggers where triggers.triggerid=functions.triggerid and result.itemid=functions.itemid ");
			if(s_host!=null){
				if(StringUtil.isNotEmpty(s_host.getName())){
					sb.append(" and result.name like '%"+s_host.getName()+"%'");
				}
			}
		//	sb.append(")as result ,functions,triggers where triggers.triggerid=functions.triggerid and result.itemid=functions.itemid and from_unixtime(lastchange)>'2015-01-01' ");
			con=db.getCon();
			psmt=con.prepareStatement(sb.toString());
		//	psmt.setString(1, StringUtils.getTime(new Date()));
		
			rs=psmt.executeQuery();
		   if(rs.next()){
			   total=Integer.parseInt(rs.getString("count"));
		   }
		   System.out.println(total);
		return total;
		  
	  }
	  
	  
	  public ArrayList<String> getSingleTri_list(PageBean pageBean,String hostid,Trigger s_tri){
		  StringBuffer sb=new StringBuffer("select hosts.name as hostname,from_unixtime(lastchange) as time,triggers.description,priority,hosts.host from hosts,items,triggers,functions where triggers.triggerid=functions.triggerid and functions.itemid=items.itemid and items.hostid=hosts.hostid and hosts.hostid='"+hostid+"'");
		  if(s_tri!=null){
			  if(StringUtil.isNotEmpty(s_tri.getFormertime())&&StringUtil.isNotEmpty(s_tri.getLastchange().toString())){
				  sb.append(" and from_unixtime(lastchange)>'"+s_tri.getFormertime()+"' and from_unixtime(lastchange)<'"+s_tri.getLastchange()+"'");
			  }
		  }
		  if(pageBean!=null){
			  sb.append(" limit "+pageBean.getStart()+","+pageBean.getPageSize());

		  }
		  
		 // String sql="select hosts.name as hostname,from_unixtime(lastchange) as time,triggers.description,priority,hosts.host from hosts,items,triggers,functions where triggers.triggerid=functions.triggerid and functions.itemid=items.itemid and items.hostid=hosts.hostid and hosts.hostid=?";
		  try {
			con=db.getCon();
			psmt=con.prepareStatement(sb.toString());
			rs=psmt.executeQuery();
			list.clear();
			while(rs.next()){
				HashMap<String, Object> map=new HashMap<String, Object>();
				map.put("host", rs.getString("hostname"));
				map.put("description", StringUtils.getAlam_des(rs.getString("description"), rs.getString("hostname")));
				map.put("time", rs.getString("time"));
				map.put("priority", rs.getInt("priority"));
				list.add(map);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		  return list;
		  
	  }
	  
	  
	  public int count(String hostid,Trigger s_tri) throws Exception{
		  int total=0;
		  StringBuffer sb=new StringBuffer("select count(from_unixtime(lastchange)) as count from hosts,items,triggers,functions where triggers.triggerid=functions.triggerid and functions.itemid=items.itemid and items.hostid=hosts.hostid and hosts.hostid='"+hostid+"'");
		  if(s_tri!=null){
			  if(StringUtil.isNotEmpty(s_tri.getFormertime())&&StringUtil.isNotEmpty(s_tri.getLastchange().toString())){
				  sb.append(" and from_unixtime(lastchange)>'"+s_tri.getFormertime()+"' and from_unixtime(lastchange)<'"+s_tri.getLastchange()+"'");
			  }
		  }
		  con=db.getCon();
			psmt=con.prepareStatement(sb.toString());
			rs=psmt.executeQuery();
			if(rs.next()){
				
				total=Integer.parseInt(rs.getString("count"));
			}
		return total;
		  
	  }
}
