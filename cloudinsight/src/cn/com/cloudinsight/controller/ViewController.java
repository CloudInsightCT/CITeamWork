package cn.com.cloudinsight.controller;

import java.io.IOException;
import java.util.List;

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

import cn.com.cloudinsight.dao.ViewDao;

@Controller
public class ViewController {
    private ViewDao viewDao=new ViewDao();
	
	@RequestMapping("/admin/view")
	public ModelAndView view(){
		ModelAndView mv=new ModelAndView();
		mv.setViewName("main");
		mv.addObject("modeName", "报表");
		mv.addObject("mainPage", "admin/view.jsp");
		mv.addObject("imagePage", "admin/image.jsp");
		return mv;
		
	}
	
	@RequestMapping("/gethost_group")
	@ResponseBody
	public Object getGroup() throws JsonGenerationException, JsonMappingException, IOException{
		List<String> list=viewDao.list_hostGroup();
		 ObjectMapper mapper=new ObjectMapper();
		 String json=mapper.writeValueAsString(list);
		// System.out.println(json);
		return json;
		
	}
	
	@RequestMapping("/gethost_list")
	@ResponseBody
	public Object getList(@RequestBody String Object) throws JsonGenerationException, JsonMappingException, IOException{
	//	System.out.println("vdavfafafavfas");
		JSONObject jb=JSONObject.fromObject(Object);
	//	System.out.println(jb.get("id"));
		List<String> list=viewDao.list_host(Integer.parseInt(jb.getString("id")));
		ObjectMapper mapper =new ObjectMapper();
		String json=mapper.writeValueAsString(list);
		return json;
		
	}
	@RequestMapping("/getload")
	@ResponseBody
	public Object getload(@RequestBody String load) throws JsonGenerationException, JsonMappingException, IOException{
		JSONObject jb=JSONObject.fromObject(load);
		List<String> list=viewDao.getview_Data(jb);
		System.out.println(jb.get("id"));
		ObjectMapper mapper=new ObjectMapper();
		String json=mapper.writeValueAsString(list);
		
		return json;
		
	}
}
