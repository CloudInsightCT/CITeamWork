package cn.com.cloudinsight.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import cn.com.cloudinsight.dao.AlarmDao;
import cn.com.cloudinsight.dao.HostDao;
import cn.com.cloudinsight.model.Host;
import cn.com.cloudinsight.model.PageBean;
import cn.com.cloudinsight.model.Trigger;
import cn.com.cloudinsight.model.User;
import cn.com.cloudinsight.utils.PageUtil;
import cn.com.cloudinsight.utils.StringUtil;
@Controller
public class AlarmController {
    private AlarmDao alarmDao=new AlarmDao();
    
    /**
     * 
     * @param page
     * @param s_host
     * @param request
     * @return
     * @throws Exception
     */
	@RequestMapping("/admin/getAlarm.do")
	public ModelAndView getAlarm(@RequestParam(value="page",required=false)String page,Host s_host,HttpServletRequest request) throws Exception{
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
		 int total=alarmDao.count(s_host,user);
		 String pageCode=PageUtil.getPagation(request.getContextPath()+"/admin/getAlarm.do", total, Integer.parseInt(page), 8);
		 List<String> list=alarmDao.getAlarm_list(pageBean,s_host,user);
		    mv.addObject("list",list);
			mv.setViewName("main");
			mv.addObject("imagePage", "admin/image.jsp");
			mv.addObject("modeName", "告警信息");
			mv.addObject("mainPage", "admin/alarm.jsp");
			mv.addObject("pageCode", pageCode);
		
		return mv;
		
	}
	
	/**
	 * 
	 * @param hostid 
	 * @param page
	 * @param s_tri
	 * @param request
	 * @return
	 * @throws Exception
	 */

	@RequestMapping(value="/admin/getTrig.do")
	public ModelAndView getTriggers_list(@RequestParam(value="hostid",required=false) String hostid,@RequestParam(value="page",required=false)String page,Trigger s_tri,HttpServletRequest request) throws Exception{
		ModelAndView mv=new ModelAndView();
		HttpSession session=request.getSession();
		if(StringUtil.isNotEmpty(hostid)){
			session.setAttribute("hostid", hostid);
		}else{
			hostid=(String) session.getAttribute("hostid");	
		}
		if(StringUtil.isEmpty(page)){
			page="1";
			session.setAttribute("s_tri", s_tri);
		}else{
			s_tri=(Trigger) session.getAttribute("s_tri");	
		}
	
		PageBean pageBean=new PageBean(Integer.parseInt(page), 8);
		int total=alarmDao.count(hostid, s_tri);
		
		List<String> list=alarmDao.getSingleTri_list(pageBean,hostid,s_tri);
		String pageCode=PageUtil.getPagation(request.getContextPath()+"/admin/getTrig.do", total, Integer.parseInt(page), 8);
		mv.addObject("list", list);
		mv.addObject("pageCode", pageCode);
			mv.setViewName("main");
			mv.addObject("imagePage", "admin/image.jsp");
			mv.addObject("modeName", "告警信息");
			mv.addObject("mainPage", "admin/alarm_info.jsp");	
		  return mv;	
	}
	
	
	
	
	/**
	 * 运维 
	 * operator_alarm
	 */
	
	@RequestMapping("/operator/getAlarm.do")
	public ModelAndView list_alarm(@RequestParam(value="page",required=false)String page,Host s_host,HttpServletRequest request) throws Exception{
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
		 int total=alarmDao.count(s_host,user);
		 String pageCode=PageUtil.getPagation(request.getContextPath()+"/operator/getAlarm.do", total, Integer.parseInt(page), 8);
		 List<String> list=alarmDao.getAlarm_list(pageBean,s_host,user);
		    mv.addObject("list",list);
			mv.setViewName("main");
			mv.addObject("imagePage", "operator/image.jsp");
			mv.addObject("modeName", "告警信息");
			mv.addObject("mainPage", "operator/alarm.jsp");
			mv.addObject("pageCode", pageCode);
		
		return mv;
		
	}
	
	
	@RequestMapping(value="/operator/getTrig.do")
	public ModelAndView list_Triggers(@RequestParam(value="hostid",required=false) String hostid,@RequestParam(value="page",required=false)String page,Trigger s_tri,HttpServletRequest request) throws Exception{
		ModelAndView mv=new ModelAndView();
		HttpSession session=request.getSession();
		if(StringUtil.isNotEmpty(hostid)){
			session.setAttribute("hostid", hostid);
		}else{
			hostid=(String) session.getAttribute("hostid");	
		}
		if(StringUtil.isEmpty(page)){
			page="1";
			session.setAttribute("s_tri", s_tri);
		}else{
			s_tri=(Trigger) session.getAttribute("s_tri");	
		}
	
		PageBean pageBean=new PageBean(Integer.parseInt(page), 8);
		int total=alarmDao.count(hostid, s_tri);
		
		List<String> list=alarmDao.getSingleTri_list(pageBean,hostid,s_tri);
		String pageCode=PageUtil.getPagation(request.getContextPath()+"/admin/getTrig.do", total, Integer.parseInt(page), 8);
		mv.addObject("list", list);
		mv.addObject("pageCode", pageCode);
			mv.setViewName("main");
			mv.addObject("imagePage", "operator/image.jsp");
			mv.addObject("modeName", "告警信息");
			mv.addObject("mainPage", "operator/alarm_info.jsp");	
		  return mv;	
	}
	
	
	public ModelAndView getUserTri(@RequestParam(value="page",required=false)String page,Host s_host,HttpServletRequest request) throws Exception{
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
		 int total=alarmDao.count(s_host,user);
		 String pageCode=PageUtil.getPagation(request.getContextPath()+"/operator/getAlarm.do", total, Integer.parseInt(page), 8);
		 List<String> list=alarmDao.getAlarm_list(pageBean,s_host,user);
		    mv.addObject("list",list);
			mv.setViewName("main");
			mv.addObject("imagePage", "user/image.jsp");
			mv.addObject("modeName", "告警信息");
			mv.addObject("mainPage", "user/alarm.jsp");
			mv.addObject("pageCode", pageCode);
		
		return mv;
		
	}
}
