package cn.com.cloudinsight.controller;

import java.io.UnsupportedEncodingException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import ch.ethz.ssh2.Session;
import cn.com.cloudinsight.dao.HostDao;
import cn.com.cloudinsight.dao.SiteDao;
import cn.com.cloudinsight.model.Host;
import cn.com.cloudinsight.model.PageBean;
import cn.com.cloudinsight.model.User;
import cn.com.cloudinsight.utils.PageUtil;
import cn.com.cloudinsight.utils.StringUtil;

@Controller
public class SiteController {
    private SiteDao siteDao=new SiteDao();
	
    
  //  @RequestMapping("/admin/getSite.do")
	public ModelAndView get_MonitorSite(@RequestParam(value="page",required=false)String page,Host s_host,HttpServletRequest request) throws Exception{
    	
		ModelAndView mv=new ModelAndView();
		HttpSession session=request.getSession();
		User user =(User) session.getAttribute("currentUser");
		if(StringUtil.isEmpty(page)){
			page="1";
			session.setAttribute("s_host", s_host);
		}else{
			s_host=(Host) session.getAttribute("s_host");
		}
		PageBean pageBean=new PageBean(Integer.parseInt(page), 8);
		List<String> list=siteDao.getSite(pageBean,s_host,user);
		int total=siteDao.count(s_host,user);
		String pageCode=PageUtil.getPagation(request.getContextPath()+"/admin/getSite.do", total, Integer.parseInt(page), 8);
		  mv.addObject("pageCode", pageCode);
		  mv.setViewName("main");
		  mv.addObject("modeName", "网站监控");
		  mv.addObject("imagePage", "/admin/image.jsp");
		  mv.addObject("mainPage", "/admin/site.jsp");
		  mv.addObject("list",list);
		
		return mv;	
	}
    /**
     * 获得分布式的城市
     * @param name
     * @return
     * @throws JsonProcessingException 
     */
    @RequestMapping(value="/getMap.do")
    @ResponseBody
    public Object getMap(@RequestParam(value="name")String name) throws JsonProcessingException{
    	//System.out.println(name);
    	 List<List<String>> list=new ArrayList<List<String>>();
    	list=siteDao.listMap(name);
    	//System.out.println(list);
    	ObjectMapper mapper =new ObjectMapper();
    	String json=mapper.writeValueAsString(list);
    	//System.out.println(json);
		return json;
    	
    }
    
	@RequestMapping("/getNow_site.do")
	@ResponseBody
	public Object getHostData(@RequestParam(value="add") String add,@RequestParam(value="time") String time,@RequestParam(value="item") String item,@RequestParam(value="name") String name,HttpServletRequest request) throws ParseException, JsonProcessingException{
		//System.out.println("add="+add+"time"+time+"item"+item+"name"+name);
		HttpSession session=request.getSession();
		session.setAttribute("add", add);
		session.setAttribute("name", name);
		List<String> list=new ArrayList<String>();
	//	ArrayList<ArrayList<String>> list=new ArrayList<ArrayList<String>>();
	    list=siteDao.getNow_site(add, time, item,name);
	    ObjectMapper mapper =new ObjectMapper();
    	String json=mapper.writeValueAsString(list);
    	//System.out.println(json);
		return json;
		
	}
	@RequestMapping(value="/siteMore.do",produces="text/plain;charset=UTF-8")
	public String siteMore(@RequestParam(value="add") String add,@RequestParam(value="name") String name,HttpServletRequest request) throws UnsupportedEncodingException{
		//request.setCharacterEncoding("UTF-8");
		String addr=java.net.URLDecoder.decode(add, "UTF-8");
		String Name=java.net.URLDecoder.decode(name, "UTF-8");
		System.out.println(addr);
	//	System.out.println(add);
		HttpSession session=request.getSession();
		session.setAttribute("add", addr);
		session.setAttribute("name", Name);
		return "redirect:site_more.jsp";
		
	}

	@RequestMapping("/getSite_data.do")
	@ResponseBody
	public Object getMoreSite_info(@RequestParam(value="add") String add,@RequestParam(value="preTime") String pretime,@RequestParam(value="time") String time,@RequestParam(value="id") String id,@RequestParam(value="name") String name) throws JsonProcessingException{
		List<String> list=new ArrayList<String>();
		list=siteDao.getMoreInfo(add,pretime, time,name, id);
		 ObjectMapper mapper =new ObjectMapper();
	    	String json=mapper.writeValueAsString(list);
			return json;
		
	}
	
	
	@RequestMapping(value="/user/getSite.do")
	public ModelAndView getUserSite(@RequestParam(value="page",required=false)String page,Host s_host,HttpServletRequest request) throws Exception{
		
		ModelAndView mv=new ModelAndView();
		HttpSession session=request.getSession();
		User user =(User) session.getAttribute("currentUser");
		if(StringUtil.isEmpty(page)){
			page="1";
			session.setAttribute("s_host", s_host);
		}else{
			s_host=(Host) session.getAttribute("s_host");
		}
		PageBean pageBean=new PageBean(Integer.parseInt(page), 8);
		List<String> list=siteDao.getSite(pageBean,s_host,user);
		int total=siteDao.count(s_host,user);
		String pageCode=PageUtil.getPagation(request.getContextPath()+"/admin/getSite.do", total, Integer.parseInt(page), 8);
		  mv.addObject("pageCode", pageCode);
		  mv.setViewName("main");
		  mv.addObject("modeName", "网站监控");
		  mv.addObject("imagePage", "/user/image.jsp");
		  mv.addObject("mainPage", "/user/site.jsp");
		  mv.addObject("list",list);
		
		return mv;	
		
	}
	
	@RequestMapping(value="/admin/getSite.do")
	public String getData(HttpServletRequest request) throws JsonProcessingException{
		HttpSession session=request.getSession();
		User user=(User) session.getAttribute("currentUser");
		System.out.println("........................"+user.getAlias());
		List<List<List<String>>> list=siteDao.getMaps(user);
		ObjectMapper mapper=new ObjectMapper();
		String json=mapper.writeValueAsString(list);
		session.setAttribute("list", json);
		return "redirect:../monitor.jsp";
		
	}
 }
