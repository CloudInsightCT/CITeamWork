package cn.com.cloudinsight.controller;

import java.io.File;
import java.io.IOException;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.io.FileUtils;
import org.springframework.context.annotation.Scope;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;



@Controller
@Component
@Scope("prototype")
public class UtilController {
    @RequestMapping("/getAbout")
	public ModelAndView get(){
    	ModelAndView mv=new ModelAndView();
    	mv.setViewName("index");
    	//mv.addObject("imagePage", "/about/image.jsp");
    	mv.addObject("mainPage", "about/about.jsp");
		return mv;
		
	}
    
    @RequestMapping("/getCon")
   	public ModelAndView Contact(){
       	ModelAndView mv=new ModelAndView();
       	mv.setViewName("index");
    //   	mv.addObject("imagePage", "/about/con_image.jsp");
       	mv.addObject("mainPage", "about/contact.jsp");
   		return mv;
   		
   	}
    
    @RequestMapping("/provider")
    public ModelAndView provider(){
     	ModelAndView mv=new ModelAndView();
       	mv.setViewName("index");
    //   	mv.addObject("imagePage", "/about/con_image.jsp");
       	mv.addObject("mainPage", "about/provider.jsp");
   		return mv;
    	
    }
    @RequestMapping("/enterprise")
    public ModelAndView enterprise(){
    	ModelAndView mv=new ModelAndView();
    	mv.setViewName("index");
    	mv.addObject("mainPage", "about/enterprise.jsp");
		return mv;
    	
    }
    @RequestMapping("/admin/data")
   public ModelAndView Data(){
    	ModelAndView mv=new ModelAndView();
    	mv.setViewName("main");
    	mv.addObject("mainPage", "admin/service.jsp");
		return mv;
   }
    @SuppressWarnings("deprecation")
	@RequestMapping(value="getAgent.do")
    public ResponseEntity<byte[]> downloadAgent(HttpServletRequest request) throws IOException{
    	String path=request.getRealPath("/")+"download/zabbix.tar.gz";  
        File file=new File(path);  
        HttpHeaders headers = new HttpHeaders();    
        String fileName=new String("zabbix.tar.gz".getBytes("UTF-8"),"iso-8859-1");//为了解决中文名称乱码问题  
        headers.setContentDispositionFormData("attachment", fileName);   
        headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);   
        return new ResponseEntity<byte[]>(FileUtils.readFileToByteArray(file),    
                                          headers, HttpStatus.CREATED);  	
    }
    @RequestMapping(value="getFile.do")
    public ResponseEntity<byte[]> downloadFile(HttpServletRequest request) throws IOException{
    	String path=request.getRealPath("/")+"download/agent安装文档.docx";  
        File file=new File(path);  
        HttpHeaders headers = new HttpHeaders();    
        String fileName=new String("agent安装文档.docx".getBytes("UTF-8"),"iso-8859-1");//为了解决中文名称乱码问题  
        headers.setContentDispositionFormData("attachment", fileName);   
        headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);   
        return new ResponseEntity<byte[]>(FileUtils.readFileToByteArray(file),    
                                          headers, HttpStatus.CREATED);  	
    }
}
