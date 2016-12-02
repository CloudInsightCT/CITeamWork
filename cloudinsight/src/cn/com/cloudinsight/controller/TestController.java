package cn.com.cloudinsight.controller;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import net.sf.json.JSONObject;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;



import cn.com.cloudinsight.dao.TestDao;
import cn.com.cloudinsight.model.TestItem;
import cn.com.cloudinsight.utils.SSHTransfer;

@Controller
public class TestController {
    private TestDao testDao=new TestDao();
	
    
    @RequestMapping("/admin/check")
    public ModelAndView check(){
    	ModelAndView mv=new ModelAndView();
    	mv.setViewName("main");
    	mv.addObject("mainPage", "admin/check.jsp");
		return mv;
    	
    }
    
	@RequestMapping(value="/iperf.do")
	@ResponseBody
	public Object iperfTest(@RequestBody String data,HttpServletRequest request) throws Exception{

		System.out.println(data);
    	JSONObject jb=JSONObject.fromObject(data);
    	String exter_ip_list=(String) jb.get("exter_ip");
    	String inter_ip_list=(String) jb.get("inter_ip");
    	String password_list=(String) jb.get("password");
    	String model=(String) jb.get("model");
    	Integer port=Integer.valueOf((String) jb.get("port"));
    	String email=(String) jb.get("email");
    	String ostype=(String) jb.get("ostype");
    	TestItem item=new TestItem();
    	item.setTest_exter_ip(exter_ip_list);
    	item.setTest_inter_ip(inter_ip_list);
    	item.setTestpassword(password_list);
    	item.setTestmodel(model);
    	item.setTestitem("iperf");
    	item.setUserid(1);//测试用
    	item.setPort(port);
    	item.setEmail(email);
    	item.setOstype(ostype);
    	//System.out.println(item.getPort());
    	TestItem resultItem=testDao.getItem(item);
    	Integer resultItemId=resultItem.getItemid();
    	//System.out.println("resultItemId="+resultItemId);
    	String[] exter_ip=exter_ip_list.split(" ");
    	String[] inter_ip=inter_ip_list.split(" ");
    	String[] password=password_list.split(" ");
    	System.out.println("pwd0="+password[0]+";pwd1="+password[1]);
    	SSHTransfer ssh0=new SSHTransfer(exter_ip[0], "root", password[0], port);
    	boolean b=ssh0.sshCon();
    	SSHTransfer ssh1=new SSHTransfer(exter_ip[1], "root", password[1], port);
    	boolean b1=ssh1.sshCon();
    	HashMap<Object,String> rs=new HashMap<Object,String>();
    	Process proc;
 //   	python iperftest.py ip1 ip2 ipmodel port itemid usermail
    	if((b&&b1)){
       String cmd="python /root/iperftest.py "+exter_ip[0]+" "+exter_ip[1]+" "+inter_ip[0]+" "+inter_ip[1]+" "+model+" "+port.toString()+" "+resultItemId.toString()+" "+email+" "+ostype;
    
       String result = "";
  //  	System.out.println(cmd);
		try {
			proc = Runtime.getRuntime().exec(cmd);
			proc.waitFor();
			BufferedInputStream in = new BufferedInputStream(proc.getInputStream());
			BufferedReader br = new BufferedReader(new InputStreamReader(in));
			String lineStr;
			while ((lineStr = br.readLine()) != null) {
				result = result+lineStr+"\n";
			}
			br.close();
			in.close();;
		} catch (IOException | InterruptedException e) {
			//TODO Auto-generated catch block
			e.printStackTrace();
		} 
		
		String[] rslist=result.split("\n");
		if (rslist.length!=1){
			//for (int i=0;i<rslist.length;i++){
			//	System.out.println(rslist[i]);
			//}
			rs.put("result", "success");
			rs.put("send0", exter_ip[0]);
			rs.put("to0", exter_ip[1]);
			rs.put("value0", rslist[0]);
			rs.put("send1", exter_ip[1]);
			rs.put("to1", exter_ip[0]);
			rs.put("value1", rslist[1]);
			rs.put("unit", rslist[2]); 
		}else{
			rs.put("result", "fail");
		}
		ObjectMapper mapper=new ObjectMapper();
		String rsjson=mapper.writeValueAsString(rs);
		System.out.println(rsjson);
		return rsjson;
    	}else{
    		rs.put("result", "sshfail");
    		ObjectMapper mapper=new ObjectMapper();
    		String rsjson=mapper.writeValueAsString(rs);
    		System.out.println(rsjson);
    		return rsjson;
    	}
//		HashMap<Object, String> map=new HashMap<Object,String>();
//		map.put("message", "正在测试中，结果将返回到您的邮箱中");
//    	ObjectMapper mapper =new ObjectMapper();
//    	String json=mapper.writeValueAsString(map);
//    	return json;
	}
	
	@RequestMapping("/coremark.do")
	@ResponseBody 
	public Object coremarkTest(@RequestBody String testdata,HttpServletRequest request) throws Exception{
		HttpSession session=request.getSession();
//		Object userId=session.getAttribute("userid");
//		System.out.println(userId.toString());
		System.out.println(testdata);
    	JSONObject jb=JSONObject.fromObject(testdata);
    	System.out.println(jb);
//    	System.out.println(jb.get("ip"));
//    	System.out.println(jb.get("password"));
//    	System.out.println(jb.get("model"));
//    	System.out.println(jb.get("port"));
    	String ip=(String) jb.get("ip");
    	String password=(String) jb.get("password");
    	Integer port=Integer.valueOf((String) jb.get("port"));
    	String email=(String) jb.get("email");
    	String ostype=(String) jb.get("ostype");
    	TestItem item=new TestItem();
    	item.setTest_exter_ip(ip);
    	item.setTestpassword(password);
    	item.setTestitem("coremark");
    	item.setUserid(1);//测试用
    	item.setPort(port);
    	item.setEmail(email);
    	item.setOstype(ostype);
    	System.out.println(item.getPort());
    	TestItem resultItem=testDao.getItem(item);
    	Integer resultItemId=resultItem.getItemid();
    	System.out.println("resultItemId="+resultItemId);
    	SSHTransfer ssh0=new SSHTransfer(ip, "root", password, port);
    	HashMap<Object,String> r=new HashMap<Object,String>();
    	if (ssh0.sshCon()){
    	Process proc;
    	String cmd="python /root/coremarktest.py "+ip+" "+port.toString()+" "+resultItemId.toString()+" "+email+" "+ostype;
    	String result = "";
    	System.out.println(cmd);
		try {
			proc = Runtime.getRuntime().exec(cmd);
			proc.waitFor();
			BufferedInputStream in = new BufferedInputStream(proc.getInputStream());
			BufferedReader br = new BufferedReader(new InputStreamReader(in));
			String lineStr;
			while ((lineStr = br.readLine()) != null) {
				result = result+lineStr+"\n";
			}
			br.close();
			in.close();;
		} catch (IOException | InterruptedException e) {
			//TODO Auto-generated catch block
			e.printStackTrace();
		} 
		
		String[] rslist=result.split("\n");
		if (rslist.length!=1){
			r.put("result", "success");
			r.put("value", rslist[1]);
		}else{
			r.put("result", "failed");
		}
		ObjectMapper mapper=new ObjectMapper();
		String rsjson=mapper.writeValueAsString(r);
		System.out.println(rsjson);
		return rsjson;
//		HashMap<Object, String> map=new HashMap<Object,String>();
//		map.put("message", "正在测试中，结果将返回到您的邮箱中");
//    	ObjectMapper mapper =new ObjectMapper();
//    	String json=mapper.writeValueAsString(map);
//    	return json;
	}else{
		r.put("result", "sshfailed");
		ObjectMapper mapper=new ObjectMapper();
		String rsjson=mapper.writeValueAsString(r);
		System.out.println(rsjson);
		return rsjson;
	}
	}
}
