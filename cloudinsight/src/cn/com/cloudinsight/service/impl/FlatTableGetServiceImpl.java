package cn.com.cloudinsight.service.impl;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import cn.com.cloudinsight.dao.FlatTableMapper;
import cn.com.cloudinsight.model.FlatTableExample;
import cn.com.cloudinsight.service.FlatTableGetService;

@Service("flatTableGetService")
public class FlatTableGetServiceImpl implements FlatTableGetService{

	@Resource(name="flatTableMapper")
	private FlatTableMapper flatTableMapper;

	@Override
	//
	public Map<String, List<BigDecimal>> getFlatTableData(String[] providers, String key, String time) {
		Map<String, List<BigDecimal>> result = new HashMap<String, List<BigDecimal>>();
		int year = Integer.valueOf(time.substring(0, 4));
		int month = Integer.valueOf(time.substring(5, 7))-1;
		if(key.equals("coremark")){
			combineResult(providers,year,month,Arrays.asList("coremark"),result);
		}else if(key.equals("scimark")){
			combineResult(providers,year,month,Arrays.asList("scimark_1_composite","scimark_2_composite","scimark_3_composite","scimark_4_composite"),result);
		}else if(key.equals("hpcc")){
			combineResult(providers,year,month,Arrays.asList("hpcc_random100","hpcc_copy","hpcc_scale","hpcc_add","hpcc_triad"),result);
		}else if(key.equals("ping")){
			combineResult(providers,year,month,Arrays.asList("ping_min","ping_max","ping_average","ping_std"),result);
		}else if(key.equals("netperf")){
			combineResult(providers,year,month,Arrays.asList("netperf_tcp_rr_internal","netperf_tcp_crr_internal","netperf_tcp_stream_internal","netperf_udp_rr_internal"),result);			
		}else if(key.equals("fio")){
			combineResult(providers,year,month,Arrays.asList("fio_sequential_write_iops","fio_sequential_read_iops","fio_random_write_iops","fio_random_read_iops"),result);			
		}else if(key.equals("unixbench")){
			combineResult(providers,year,month,Arrays.asList("unixbench_index"),result);			
		}else if(key.equals("oltp")){
			combineResult(providers,year,month,Arrays.asList("sysbench_oltp"),result);			
		}else if(key.equals("nosql")){
			combineResult(providers,year,month,Arrays.asList("ycsb_throughput_a","ycsb_throughput_b"),result);			
		}
		
		return result;
	}
	
	private void combineResult(String[] providers, int year, int month, List<String> cols, Map<String, List<BigDecimal>> result){
		Calendar pre = Calendar.getInstance();
		pre.set(year, month, 1);
		Calendar last = Calendar.getInstance();
		last.set(year, month+1, 1);
		for(String provider : providers){
			FlatTableExample fte = new FlatTableExample();
			fte.setOrderByClause("time asc");
			fte.createCriteria()
			.andNameEqualTo(provider);
			//.andTimeBetween(new Date(pre.getTimeInMillis()), new Date(last.getTimeInMillis()));
			result.put(provider, 
					flatTableMapper.getSpecificItemsByColumn(cols,fte));
		}
	}

}
