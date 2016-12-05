package ict.monitor.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ServiceController {
	@RequestMapping(value = "/topo.do")
	public String toPo(){
		return "topo";
	}
	
	@RequestMapping(value = "/performance.do")
	public String performance(){
		return "performance";
	}
	
	@RequestMapping(value = "/appLoad.do")
	public String appLoad(){
		return "app_load";
	}
	
	@RequestMapping(value = "/hostLoad.do")
	public String hostLoad(){
		return "host_load";
	}
	
	@RequestMapping(value = "/slowCall.do")
	public String slowCall(){
		return "slow_call";
	}
	
	@RequestMapping(value = "/wrongCall.do")
	public String wrongCall(){
		return "wrong_call";
	}
}
