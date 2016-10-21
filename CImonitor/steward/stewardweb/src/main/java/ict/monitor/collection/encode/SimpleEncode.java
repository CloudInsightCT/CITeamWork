package ict.monitor.collection.encode;

public class SimpleEncode implements Encode {

	public String encode(Object ...datas) {
		StringBuilder sb = new StringBuilder();
		for (Object strobj : datas) {
			if(strobj instanceof Object[]){
				Object[] o = (Object[]) strobj;
				for (Object object : o) {
					sb.append(object);
					sb.append("#");					
				}
			}else{
				sb.append(strobj);
				sb.append("#");
			}
		}
		sb.append("\n");
		return sb.toString().substring(0, sb.toString().length()-2);
	}

}
