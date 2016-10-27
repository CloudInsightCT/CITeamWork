package cn.com.cloudinsight.controller;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;


import net.sf.json.JSONObject;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import cn.com.cloudinsight.dao.HostDao;
import cn.com.cloudinsight.model.Host;
import cn.com.cloudinsight.model.PageBean;
import cn.com.cloudinsight.model.User;
import cn.com.cloudinsight.utils.PageUtil;
import cn.com.cloudinsight.utils.StringUtil;
import cn.com.cloudinsight.utils.StringUtils;

@Controller
public class HostController {
   
	private HostDao hostDao=new HostDao();
	/**
	 * 
	 * @param page
	 * @param s_host
	 * @param request
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/admin/gethost.do")
	public ModelAndView getHost(@RequestParam(value="page",required=false)String page,Host s_host,HttpServletRequest request) throws Exception{
		ModelAndView mv=new ModelAndView();
		HttpSession session=request.getSession();
	    User user=(User) session.getAttribute("currentUser");
		if(StringUtil.isEmpty(page)){
			page="1";
			session.setAttribute("s_host", s_host);
		}else{
			s_host=(Host) session.getAttribute("s_host");
		}
		
		PageBean pageBean=new PageBean(Integer.parseInt(page), 8);
		 List<String> list=hostDao.getHost_list(pageBean,s_host,user);
			int total=hostDao.count(s_host,user);
			String pageCode=PageUtil.getPagation(request.getContextPath()+"/admin/gethost.do", total, Integer.parseInt(page), 8);
			
		//	mv.addObject("imagePage","admin/image.jsp");
			mv.addObject("modeName", "可达性监控");
			mv.addObject("mainPage", "admin/host.jsp");
			mv.addObject("pageCode", pageCode);
			mv.setViewName("main");
		    mv.addObject("list",list);
		
		return mv;
		
	}
	
	
	/**
	 * 获取监控项
	 * @param page
	 * @param hostid
	 * @param request
	 * @return
	 * @throws Exception 
	 */
	@RequestMapping("/admin/getItems.do")
	public ModelAndView getItem(@RequestParam(value="page",required=false) String page,@RequestParam(value="hostid",required=false)String hostid,HttpServletRequest request) throws Exception{
		ModelAndView mv=new ModelAndView();
		HttpSession session=request.getSession();
		if(StringUtil.isNotEmpty(hostid)){
			session.setAttribute("hostid", hostid);
		}else{
			hostid=(String) session.getAttribute("hostid");
		}
		
		if(StringUtil.isEmpty(page)){
			page="1";
		}
		PageBean pageBean=new PageBean(Integer.parseInt(page), 8);
		List<String> list=hostDao.getItems(pageBean,hostid);
		int total=hostDao.getItemsNum(hostid);
		String pageCode=PageUtil.getPagation(request.getContextPath()+"/admin/getItems.do", total, Integer.parseInt(page), 8);
		mv.addObject("modeName", "监控项");
		mv.addObject("mainPage", "admin/items.jsp");
		mv.addObject("pageCode", pageCode);
		mv.setViewName("main");
	    mv.addObject("list",list);
		return mv;
		
	}
	@RequestMapping("/getNow_data.do")
	@ResponseBody
	public Object getItemData(@RequestParam(value="itemid") int itemid,@RequestParam(value="time") String time,@RequestParam(value="id") String id){
		
		List<String> list=new ArrayList<String>();
	    list=hostDao.getNow_data(itemid, time, id);
		return list;
		
	}
	
	@RequestMapping("/getItem_data.do")
	@ResponseBody
	public Object getMoreItem_info(@RequestParam(value="itemid") int itemid,@RequestParam(value="time") String time,@RequestParam(value="id") String id,@RequestParam(value="preTime") String preTime){
		List<String> list=new ArrayList<String>();
		list=hostDao.getMoreInfo(itemid,preTime, time, id);
		return list;
		
	}
	
	
	@RequestMapping("/getHost_data.do")
	@ResponseBody
	public Object getHostData(@RequestBody String ItemData) throws JsonGenerationException, JsonMappingException, IOException{
	//	System.out.println(ItemData);
		JSONObject jb=JSONObject.fromObject(ItemData);
		List<String> list=new ArrayList<String>();
	    list=hostDao.getHostData(jb);
	    ObjectMapper mapper=new ObjectMapper();
	    String json=mapper.writeValueAsString(list);
	 //   System.out.println(json);
		return json;
		
	}
	
	@SuppressWarnings("unchecked")
	@RequestMapping("/getLocalData.do")
	@ResponseBody
	public Object getLocalData(@RequestBody String itemData) throws JsonGenerationException, JsonMappingException, IOException{
	
		JSONObject ItemData=JSONObject.fromObject(itemData);
		List<String> list=new ArrayList<String>();
	    list=hostDao.getLocalData(ItemData);
	    ObjectMapper mapper=new ObjectMapper();
    	String json=mapper.writeValueAsString(list);
    	
		return json;
		
	}
	
	@RequestMapping(value="/getPing.do")
	public ModelAndView getPing(@RequestParam(value="ip") String ip) throws Exception{
		List<String> list=StringUtils.ping(ip);
		ModelAndView mv=new ModelAndView();
		mv.addObject("list", list);
		mv.setViewName("Result_ping");
		return mv;
	}
	
	
	    @RequestMapping(value="/getitems.do")
	    @ResponseBody
		public Object getItem(@RequestBody String item) throws JsonGenerationException, JsonMappingException, IOException{
	    //	System.out.println(item);
	    	JSONObject items=JSONObject.fromObject(item);
	    	System.out.println(items.get("hostid"));
	    	
	     	List list=hostDao.getItem(items);
	    	ObjectMapper mapper=new ObjectMapper();
	    	String json=mapper.writeValueAsString(list);
	    	//ystem.out.println(json);
			return json;
	    		
		}	
	
	    
	    
	    @RequestMapping(value="/getData.do")
	    @ResponseBody
	    public Object getData(@RequestBody String host) throws IOException {
			  System.out.println(host);
				JSONObject ItemData=JSONObject.fromObject(host);
				List<String> list=new ArrayList<String>();
			    list=hostDao.getlocal_Data(ItemData);
			    ObjectMapper mapper=new ObjectMapper();
				String json=mapper.writeValueAsString(list);
		//		System.out.println(json);
				return json;
	    }
	    
	    
	    
	    /**
	     * 运维代码strart
	     * @throws Exception 
	     * 
	     */
	    
	    @RequestMapping("/operator/gethost.do")
	    public ModelAndView list_host(@RequestParam(value="page",required=false)String page,Host s_host,HttpServletRequest request) throws Exception{
	    	ModelAndView mv=new ModelAndView();
	    	HttpSession session=request.getSession();
	    	User user=(User) session.getAttribute("currentUser");
	    	if(StringUtil.isEmpty(page)){
	    		page="1";
	    		session.setAttribute("s_host", s_host);
	    	}else{
	    		s_host=(Host) session.getAttribute("s_host");
	    	}
	    	PageBean pageBean=new PageBean(Integer.parseInt(page), 8);
	    	List<String> list=hostDao.getHost_list(pageBean,s_host,user);
			int total=hostDao.count(s_host,user);
			String pageCode=PageUtil.getPagation(request.getContextPath()+"/admin/gethost.do", total, Integer.parseInt(page), 8);
			mv.addObject("i" +
					"magePage","operator/image.jsp");
			mv.addObject("modeName", "可达性监控");
			mv.addObject("mainPage", "operator/host.jsp");
			mv.addObject("pageCode", pageCode);
			mv.setViewName("main");
		    mv.addObject("list",list);
		
		return mv;

	    }
}
