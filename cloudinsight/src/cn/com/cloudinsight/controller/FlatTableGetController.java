package cn.com.cloudinsight.controller;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import cn.com.cloudinsight.service.FlatTableGetService;


/**
 * 
 * Copyright 2015 CTBRI
 * All right reserved.
 * <p>
 *	Get the FlatTable data for echarts.
 * </p>
 * 
 * @author Qun He
 * @version 1.0.0
 * @Create 2015年10月20日 下午5:28:21
 */
@Controller
public class FlatTableGetController {

	@Resource(name="flatTableGetService")
	FlatTableGetService flatTableGetService;
	
	/**
	 * 
	 * <p>
	 * Get the data by conditions.
	 * </p>
	 * @param key the 
	 * @param providers the cloud service providers
	 * @param time the month range
	 * @return the map json , provider name represents the key and the value is a list
	 * @throws Throwable
	 */
	@RequestMapping("/getDatas.do")
	@ResponseBody
	public Map<String,List<BigDecimal>> getFlatTableData(@RequestParam(value="key") String key,
			@RequestParam(value="providers") String providers,
			@RequestParam(value="time") String time) throws Throwable{
		System.out.println(providers);
		System.out.println("time======"+time);
		return flatTableGetService.getFlatTableData(providers.split(","),key,time);
	}
}
