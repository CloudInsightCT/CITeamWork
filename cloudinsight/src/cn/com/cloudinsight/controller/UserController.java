package cn.com.cloudinsight.controller;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;



import cn.com.cloudinsight.dao.UserDao;
import cn.com.cloudinsight.model.User;
import cn.com.cloudinsight.utils.StringUtils;

@SuppressWarnings("unused")
@Controller
public class UserController {
    
	
	private UserDao userDao=new UserDao();
	@RequestMapping("/login.do")
	public String login(User user ,HttpServletRequest request){
		
	
		User u=userDao.login(user);
	
		if(u.getUserName()==null){
			request.setAttribute("user", user);
			request.setAttribute("errorMsg", "用户名或密码错误");
			return "login";
		}else{
			HttpSession session=request.getSession();
			session.setAttribute("currentUser", u);
			return "main";
		}
		
			
	}
	
	
}
