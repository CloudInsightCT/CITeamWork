package cn.com.cloudinsight.service;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

public interface FlatTableGetService {
	
	Map<String,List<BigDecimal>> getFlatTableData(String[] providers, String key, String time);

}
