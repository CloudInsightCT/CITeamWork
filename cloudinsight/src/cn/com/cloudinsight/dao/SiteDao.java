package cn.com.cloudinsight.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import cn.com.cloudinsight.model.Host;
import cn.com.cloudinsight.model.PageBean;
import cn.com.cloudinsight.model.User;
import cn.com.cloudinsight.utils.DbUtils;
import cn.com.cloudinsight.utils.StringUtil;
import cn.com.cloudinsight.utils.StringUtils;

public class SiteDao {
	 private DbUtils db=new DbUtils();
	 private ArrayList list=new ArrayList();
	  Connection con=null;
	  PreparedStatement psmt=null;
	  ResultSet rs=null;
	 
	  public ArrayList getSite(PageBean pageBean,Host s_host,User user){
		  StringBuffer sb=new StringBuffer("select hosts.name,hosts.status,hosts.hostid,httpstep.name as site ,httpstep.url ,httptest.delay from hosts,users,users_groups,rights,hosts_groups,httptest,httpstep where hosts.hostid=hosts_groups.hostid and hosts_groups.groupid=rights.id and rights.groupid=users_groups.usrgrpid and users_groups.userid=users.userid and hosts.hostid=httptest.hostid and httptest.httptestid=httpstep.httptestid and users.alias='"+user.getAlias()+"' GROUP BY url");
		  if(s_host!=null){
			  if(StringUtil.isNotEmpty(s_host.getHost())){
				  sb.append(" and hosts.name like '%"+s_host.getHost()+"%'");
			  }
		  }
		  if(pageBean!=null){
			  sb.append(" limit "+pageBean.getStart()+","+pageBean.getPageSize());
		  }
		    	   
		//		 sql="select DISTINCT hosts.name,httptest.delay,httptest.hostid,interface.dns from httptest,hosts,interface,users where httptest.hostid=hosts.hostid and interface.hostid=hosts.hostid";
				 try {
					con=db.getCon();
					psmt=con.prepareStatement(sb.toString());
					rs=psmt.executeQuery();
					list.clear();
					while(rs.next()){
						HashMap<String,Object> map=new HashMap<String,Object>();
						if(rs.getString("name").indexOf("-")!=-1){
							map.put("name", rs.getString("name").substring(rs.getString("name").indexOf("-")+1));
						}else{
							map.put("name",rs.getString("name").substring(rs.getString("name").indexOf(":")+1));
						}
						
						map.put("site", rs.getString("site"));
						map.put("delay", rs.getInt("delay"));
						map.put("url", rs.getString("url"));
						//map.put("host", rs.getString("host"));
						map.put("hostid", rs.getInt("hostid"));
						
						list.add(map);
					}
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				return list;
				
			} 
	  
	  public List<List<List<String>>> getMaps(User user) {
			List<List<List<String>>> arrlist=new ArrayList<List<List<String>>>();
			List<List<String>> arr=new ArrayList<List<String>>();
			//list.clear();
			String result="";
			String add="";
	          String name="";
	          String   addname="";
			String sql="select hosts.name  from hosts,users,users_groups,rights,hosts_groups,httptest,httpstep where hosts.hostid=hosts_groups.hostid and hosts_groups.groupid=rights.id and rights.groupid=users_groups.usrgrpid and users_groups.userid=users.userid and hosts.hostid=httptest.hostid and httptest.httptestid=httpstep.httptestid and users.alias='"+user.getAlias()+"'";
			// TODO Auto-generated method stub
			try {
				con=db.getCon();
                psmt=con.prepareStatement(sql);
				
				rs=psmt.executeQuery();
				while(rs.next()){
					  List lists=new ArrayList(); 
					 HashMap<String, Object> map=new HashMap<String, Object>();
		              HashMap<String, Object> map1=new HashMap<String, Object>();
		              HashMap<String, Object> map2=new HashMap<String, Object>();
					result=rs.getString("name");
					if(result.indexOf("-")!=-1){
						 add="";
		            	  name="";   
						 add= result.substring(0, result.indexOf("-"));
		            	 name=result.substring(result.indexOf("-")+1);
					}
					 if(result.indexOf(":")!=-1){
			               addname=result.substring(result.indexOf(":")+1);
			            	  if(addname.equals(name)){    	
			                	  map.put("name", result.substring(0, result.indexOf(":"))); 	
			                	  lists.add(map);
			                	 map1.put("name", add);
			                	 lists.add(map1);
			                	 map2.put("name", addname);
			                	 lists.add(map2);
			                	 arr.add(lists);
			                	  
			                  } 
			            	
			            }
					 if(!addname.equals(name)&& addname!=""){
			              
			            	  arrlist.add(arr);
			               //	 arr.clear();
			            	  arr=new ArrayList<List<String>>();
			                }
			               
					 
					 
				}
				  arrlist.add(arr);
		       //   System.out.println(arrlist);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return arrlist;
		}
	  public  List<List<String>> listMap(String name){
		  List<List<String>> arr=new ArrayList<List<String>>();
		  
		  String sql="select hostid, name from hosts where name like '%"+name+"%' order by hostid ASC";
			try {
				con=db.getCon();
				psmt=con.prepareStatement(sql);
				
				rs=psmt.executeQuery();
			//	System.out.println(name+"123");
				String add="";   
				
			  //  System.out.println(add+"add");
			  //  System.out.println(name+"123456");
				while(rs.next()){
					ArrayList lists=new ArrayList();
				    
					HashMap<String, Object> map=new HashMap<String,Object>();
					HashMap<String, Object> map1=new HashMap<String,Object>();
				
					if(rs.getString("name").indexOf("-")!=-1){
						add=rs.getString("name").substring(0, rs.getString("name").indexOf("-"));
						System.out.println(add);
					//	map.put("name", rs.getString("name").substring(0, rs.getString("name").indexOf(":")));
					//	lists.add(map);

					}
					if(rs.getString("name").indexOf(":")!=-1){
						map.put("name", StringUtils.getFormer(rs.getString("name")));
						lists.add(map);
						map1.put("name", add);		
						lists.add(map1);
						arr.add(lists);
					}
					//	System.out.println(rs.getString("name"));			
							
				  
				}
			
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		return arr;
		  
	  }
	  
	 
	  
	  
	  
	  public int count(Host s_host,User user) throws Exception{
		  int total=0;
		  StringBuffer sb=new StringBuffer("select count(hosts.hostid) as count from hosts,users,users_groups,rights,hosts_groups,httptest,httpstep where hosts.hostid=hosts_groups.hostid and hosts_groups.groupid=rights.id and rights.groupid=users_groups.usrgrpid and users_groups.userid=users.userid and hosts.hostid=httptest.hostid and httptest.httptestid=httpstep.httptestid and users.alias='"+user.getAlias()+"'");
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
		return total;
	  }
	  
	  public ArrayList getSite_group(String username,String surname) throws Exception{
		  String sql="select  distinct name,count( name) as num  from(select httptest.hostid,hosts.host from httptest,hosts,interface where httptest.hostid=hosts.hostid and interface.hostid=hosts.hostid )as result, groups,hosts_groups where groups.groupid=hosts_groups.groupid and result.hostid=hosts_groups.hostid group by name";
		  
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
	  
	public ArrayList<String> getNow_site(String add,String time,String item,String name) throws ParseException{
		String sql=null;
		ArrayList lists=new ArrayList();
		ArrayList<ArrayList<String>> arr=new ArrayList<ArrayList<String>>();
		if(item.equals("speed")){
			
			 sql="select  from_unixtime(clock) as time ,value/1024 as value from history,items,hosts where items.itemid=history.itemid and items.units='Bps' and items.hostid=hosts.hostid and hosts.name like '"+add+":"+name+"' and from_unixtime(clock)>'"+time+"' and from_unixtime(clock)<'"+StringUtils.getDate(time)+"' ";
		}
		if(item.equals("response")){
			 sql="select  from_unixtime(clock) as time ,value from history,items,hosts where items.itemid=history.itemid and items.units='s' and items.hostid=hosts.hostid and hosts.name like '"+add+":"+name+"' and from_unixtime(clock)>'"+time+"' and from_unixtime(clock)<'"+StringUtils.getDate(time)+"' ";
		}
		try {
			con=db.getCon();
			psmt=con.prepareStatement(sql);
		//	psmt.setInt(1, hostid);
		//	psmt.setString(2, time);
		//	psmt.setString(3, StringUtils.getDate(time));
			rs=psmt.executeQuery();
		
			list.clear();
			while(rs.next()){
				HashMap<String, Object> map =new HashMap<String, Object>();
			//	HashMap<String, Object> map1 =new HashMap<String, Object>();
				map.put("time", rs.getString("time"));
				map.put("value", rs.getFloat("value"));
				list.add(map);
				//list.add(rs.getString("time"));
			//	lists.add(rs.getString("value"));
			}
			//arr.add(list);
		//	arr.add(lists);
		
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return list;	
	}
	
	public ArrayList getMoreInfo(String add,String preTime,String time,String name,String id){
		String sql="";
		list.clear();
		if(id.equals("speed")){
			 sql="select  from_unixtime(clock) as time ,value/1024 as value from history,items,hosts where items.itemid=history.itemid and items.units='Bps' and items.hostid=hosts.hostid and hosts.name like '"+add+":"+name+"' and from_unixtime(clock)>'"+preTime+"' and from_unixtime(clock)<'"+time+"' ";
		}
		if(id.equals("response")){
			 sql="select  from_unixtime(clock) as time ,value from history,items,hosts where items.itemid=history.itemid and items.units='s' and items.hostid=hosts.hostid and hosts.name like '"+add+":"+name+"' and from_unixtime(clock)>'"+preTime+"' and from_unixtime(clock)<'"+time+"' ";

		}
		try {
			con=db.getCon();
			psmt=con.prepareStatement(sql);
			//psmt.setInt(1, hostid);
			//psmt.setString(2, preTime);
		//	psmt.setString(3, time);
			rs=psmt.executeQuery();
			while(rs.next()){
				HashMap<String, Object> map =new HashMap<String, Object>();
				map.put("time", rs.getString("time"));
				map.put("value", rs.getFloat("value"));
				list.add(map);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return list;
		
	}

	public List<String> getAdSite_list(String name) {
		String sql="select httptest.name,httptest.delay,httptest.hostid,hosts.host,interface.dns from(select hosts_groups.hostid from hosts_groups,groups where groups.groupid=hosts_groups.groupid and groups.name=?)as result, httptest,hosts,interface where httptest.hostid=hosts.hostid and interface.hostid=hosts.hostid and result.hostid=interface.hostid ";
		try {
			con=db.getCon();
			psmt=con.prepareStatement(sql);
			psmt.setString(1, name);
			rs=psmt.executeQuery();
			list.clear();
			while(rs.next()){
				HashMap<String,Object> map=new HashMap<String,Object>();
				map.put("name", rs.getString("name"));
				map.put("site", rs.getString("dns"));
				map.put("delay", rs.getInt("delay"));
				map.put("host", rs.getString("host"));
				map.put("hostid", rs.getInt("hostid"));
				
				list.add(map);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}


	
}
