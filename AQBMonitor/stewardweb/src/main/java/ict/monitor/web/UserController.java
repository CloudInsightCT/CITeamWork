package ict.monitor.web;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import ict.monitor.bean.Agent;
import ict.monitor.bean.User;
import ict.monitor.dao.AgentDao;
import ict.monitor.dao.UserDao;

@Controller
public class UserController {
	@Autowired
	private UserDao userDao;
	@Autowired
	private AgentDao agentDao;

	@RequestMapping(value = "/user.do")
	@ResponseBody
	public User getUser(HttpServletRequest request, User user) {
		return user;
	}
	
	@RequestMapping(value = "/index.do")
	public String indexPage(HttpServletRequest request, Model model) {
		User userInfo = (User) request.getSession().getAttribute("userInfo");
		if(userInfo==null){
			return "redirect:login.do";
		}
		ArrayList<Agent> list = agentDao.findAgentIDsByUserID(userInfo.getId());
		model.addAttribute("agents", list);
		return "index";
	}
	
	@RequestMapping(value = "/signUp.do")
	public String signUp(Model model, String username, String password, String password2, String email) {
		if (username == null) {
			model.addAttribute("msg", "none");
			return "register";
		} else {
			if (StringUtils.isEmpty(username)) {
				model.addAttribute("msg", "用户名不能为空！");
				return "register";
			}
			if (StringUtils.isEmpty(password)) {
				model.addAttribute("msg", "密码不能为空！");
				return "register";
			}
			if (StringUtils.isEmpty(email)) {
				model.addAttribute("msg", "邮箱不能为空！");
				return "register";
			}
			if (StringUtils.length(username) < 3 || StringUtils.length(username) > 15) {
				model.addAttribute("msg", "用户名长度在3~15之间！");
				return "register";
			}
			if (StringUtils.length(password) < 6 || StringUtils.length(password) > 15) {
				model.addAttribute("msg", "密码长度在6~15之间！");
				return "register";
			}
			if (!StringUtils.equals(password, password2)) {
				model.addAttribute("msg", "两次输入密码不一致！");
				return "register";
			}
			if (StringUtils.length(email) < 5 || StringUtils.length(email) > 64) {
				model.addAttribute("msg", "邮箱长度在5~64之间！");
				return "register";
			}
			else {
				User ifuser = userDao.findUserByUserName(username);
				if (ifuser != null) {
					model.addAttribute("msg", "该用户名已存在！");
					return "register";
				}
				User ifuser2 = userDao.findUserByUserEmail(email);
				if (ifuser2 != null) {
					model.addAttribute("msg", "该邮箱已注册！");
					return "register";
				}
				else {
					User user = new User(username, password, email);
					userDao.insert(user);
					return "redirect:login.do";
				}
				
				
			}
		}
		
	}
	
	@RequestMapping(value = "/signUpApp.do")
	public String signUpApp(HttpServletRequest request, Model model) {
		User userInfo = (User) request.getSession().getAttribute("userInfo");
		if(userInfo==null){
			return "redirect:login.do";
		}
		UUID uuid = UUID.randomUUID();
		String uuidstr = uuid.toString();
		uuidstr = uuidstr.substring(0, 18);
		String uuidstr_short = uuidstr.substring(0, 8);
		model.addAttribute("uuidstr", uuidstr);
		model.addAttribute("uuidstr_short", uuidstr_short);
		return "signUpApp";
	}
	
	@RequestMapping(value = "/signUpHost.do")
	public String signUpHost(HttpServletRequest request, Model model) {
		User userInfo = (User) request.getSession().getAttribute("userInfo");
		if(userInfo==null){
			return "redirect:login.do";
		}
		UUID uuid = UUID.randomUUID();
		String uuidstr = uuid.toString();
		uuidstr = uuidstr.substring(0, 18);
		model.addAttribute("uuidstr", uuidstr);
		return "signUpHost";
	}
	
	@RequestMapping(value = "/signUpAgentID.do")
	@ResponseBody
	public String signUpAgentID(HttpServletRequest request, String agentid, int type) {
		HttpSession session = request.getSession(true);
		User user = (User) session.getAttribute("userInfo");
		if(user == null) {
			return "请先登录！";
		}
		try {
			agentDao.insert(new Agent(user.getId(), agentid, type));
		} catch(Exception e) {
			return "失败！";
		}
		return "success";
	}
	
}
