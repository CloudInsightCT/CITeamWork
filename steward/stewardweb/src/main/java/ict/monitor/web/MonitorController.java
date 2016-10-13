package ict.monitor.web;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.net.URLEncoder;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import ict.monitor.bean.Agent;
import ict.monitor.bean.PinpointTarget;
import ict.monitor.bean.User;
import ict.monitor.collection.entity.DevInfoEntity;
import ict.monitor.context.WebContext;
import ict.monitor.dao.AgentDao;
import ict.monitor.dao.DevInfoDao;
import ict.monitor.dao.MetricDao;

@Controller
public class MonitorController {
	private static Logger logger = LogManager.getLogger(MonitorController.class.getName());
	@Autowired
	private AgentDao agentDao;
	@Autowired
	private DevInfoDao devInfoDao;

	@RequestMapping(value = "/monitorMachineList.do")
	public String monitorMachineList(HttpServletRequest request, Model model, String agentID) {
		User userInfo = (User) request.getSession().getAttribute("userInfo");
		ArrayList<Agent> list = agentDao.findAgentByUserIDAndAgentID(userInfo.getId(), agentID);
		List<DevInfoEntity> devs = devInfoDao.findDevInfo(agentID);
		model.addAttribute("agents", list);
		model.addAttribute("devs", devs);
		return "monitorMachineList";
	}
	
	
	@RequestMapping(value = "/findDevInfo.do")
	@ResponseBody
	public DevInfoEntity findDevInfo(String agentID, String devID) {
		DevInfoEntity findDevInfoByAgentIDAndDevID = devInfoDao.findDevInfoByAgentIDAndDevID(agentID,devID);
		return findDevInfoByAgentIDAndDevID;
	}
	
	// 跳转到websocket界面
	@RequestMapping(value = "/pushData.do")
	public String pushDate(HttpServletRequest request, String agentID, Model model) {
		model.addAttribute("agentID", agentID);
		return "websocket";
	}

	@RequestMapping(value = "/transactionErrorMetadata.do")
	@ResponseBody
	public String transactionErrorMetadata(String agentID, long from, long to, int limit) {
		String url = WebContext.PINPOINT + "/transactionErrorMetadata.pinpoint?application=" + agentID + "&from=" + from + "&to=" + to + "&limit=" + limit;
		return getJsonFromPinpoint(url);
	}

	@RequestMapping(value = "/transactionSlowMetadata.do")
	@ResponseBody
	public String transactionSlowMetadata(String agentID, long from, long to, int limit, int threshold) {
		String url = WebContext.PINPOINT + "/transactionSlowMetadata.pinpoint?application=" + agentID + "&from=" + from + "&to=" + to + "&limit=" + limit + "&threshold=" + threshold;
		return getJsonFromPinpoint(url);
	}
	
	@RequestMapping(value = "/getServerMapData.do")
	@ResponseBody
	public String serverMapData(String agentID, long from, long to, String serviceTypeName) {
		String url = WebContext.PINPOINT + "/getServerMapData.pinpoint?applicationName=" + agentID + "&from=" + from + "&to=" + to +  "&serviceTypeName=" + serviceTypeName;
		return getJsonFromPinpoint(url);
	}
	
	
	@RequestMapping(value = "/serviceTypeName.do")
	@ResponseBody
	public String serviceTypeName(HttpServletRequest request,String agentID) {
		User userInfo = (User) request.getSession().getAttribute("userInfo");
		ArrayList<Agent> userAgentList = agentDao.findAgentIDsByUserID(userInfo.getId());
		if (userAgentList == null || userAgentList.size() == 0) {
			return "";
		}
		String json = getJsonFromPinpoint(WebContext.PINPOINT + "/applications.pinpoint");
		ObjectMapper mapper = new ObjectMapper();
		List<PinpointTarget> agentList = new ArrayList<>();
		try {
			agentList = mapper.readValue(json, new TypeReference<List<PinpointTarget>>() {});
		} catch (IOException e) {
			e.printStackTrace();
		}
		for (PinpointTarget pinpointTarget : agentList) {
			if(pinpointTarget.getApplicationName().equals(agentID)){
				return pinpointTarget.getServiceType();
			}
		}
		return "";
	}
	/**
	 * 得到监控的agentID
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "/applications.do")
	@ResponseBody
	public Set<String> applications(HttpServletRequest request) {
		User userInfo = (User) request.getSession().getAttribute("userInfo");
		ArrayList<Agent> userAgentList = agentDao.findAgentIDsByUserID(userInfo.getId());
		if (userAgentList == null || userAgentList.size() == 0) {
			return new HashSet<>();
		}
		String json = getJsonFromPinpoint(WebContext.PINPOINT + "/applications.pinpoint");
		ObjectMapper mapper = new ObjectMapper();
		List<PinpointTarget> agentList = new ArrayList<>();
		try {
			agentList = mapper.readValue(json, new TypeReference<List<PinpointTarget>>() {});
		} catch (IOException e) {
			e.printStackTrace();
		}
		Set<String> allAgents = new HashSet<>();
		Set<String> allUserAgents = new HashSet<>();
		for (PinpointTarget pinpointTarget : agentList) {
			allAgents.add(pinpointTarget.getApplicationName());
		}
		for (Agent agent : userAgentList) {
			allUserAgents.add(agent.getAgentID());
		}
		allAgents.retainAll(allUserAgents);
		return allAgents;
	}
	/**
	 * 获取时间段内所有散点信息
	 * @param application
	 * @param from
	 * @param to
	 * @param limit
	 * @return
	 */
	@RequestMapping(value = "/getScatterData.do")
	@ResponseBody
	public String scatterData(String agentID, long from, long to, int limit) {
		String url = WebContext.PINPOINT + "/getScatterData.pinpoint?application=" + agentID + "&from=" + from + "&to=" + to + "&limit=" + limit+"&v=2";
		return getJsonFromPinpoint(url);
	}
	/**
	 * 获取调用堆栈信息
	 * @param traceId
	 * @param focusTimestamp
	 * @return
	 */
	@RequestMapping(value = "/transactionInfo.do")
	@ResponseBody
	public String transactionInfo(String traceId, long focusTimestamp) {
//		String url = WebContext.PINPOINT + "/transactionInfo.pinpoint?traceId=" + traceId + "&focusTimestamp=" + focusTimestamp;
		try{
			String url = WebContext.PINPOINT + "/transactionInfo.pinpoint?traceId=" + URLEncoder.encode(traceId, "UTF-8") + "&focusTimestamp=" + focusTimestamp;
			return getJsonFromPinpoint(url);
		} catch (Exception e) {
			logger.warn("不合法参数" + traceId);
		}
		return "";
	}
	
	private String getJsonFromPinpoint(String url) {
		try {
			HttpClient httpclient = new DefaultHttpClient();
			HttpGet httpget = new HttpGet(url);
			HttpResponse response = httpclient.execute(httpget);
			HttpEntity entity = response.getEntity();
			if (entity != null) {
				return EntityUtils.toString(entity);
			}
		} catch (Exception e) {
			e.printStackTrace();
			logger.warn("读取pinpoint数据异常：" + url);
		}
		return "";
	}

}
