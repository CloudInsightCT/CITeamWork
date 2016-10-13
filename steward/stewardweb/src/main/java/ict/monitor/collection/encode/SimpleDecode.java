package ict.monitor.collection.encode;

import ict.monitor.collection.entity.AgentInfoEntity;
import ict.monitor.collection.entity.BaseEntity;
import ict.monitor.collection.entity.DevInfoEntity;
import ict.monitor.collection.entity.MetricEntity;
import ict.monitor.common.Constant;

public class SimpleDecode implements Decode {
	public BaseEntity decode(Object data) {
		String str = (String) data;
		String[] split = str.split("#");
		if (split[0].equals(Constant.METRIC)) {
			return new MetricEntity(split[1], split[2], split[3],Double.parseDouble(split[4]), Long.parseLong(split[5]));
		} else if (split[0].equals(Constant.AGENT_INFO)) {
			return new AgentInfoEntity(split[1], split[2], split[3], split[4], split[5], split[6], split[7]);
		} else if (split[0].equals(Constant.INFO)) {
			StringBuilder sb = new StringBuilder();
			for (int i = 3; i < split.length; i++) {
				sb.append(split[i]);
				sb.append("#");
			}
			return new DevInfoEntity(split[1], split[2], sb.toString().substring(0, sb.toString().length()-1));
		}
		return null;
	}
}
