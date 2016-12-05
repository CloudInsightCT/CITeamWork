package ict.monitor.datamining;
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.HashMap;

public class Apriori_transcation_compression {
	private String fileName;
	private String spacecharacter;

	private double minSuportNum;
	private double minSupportFix;
	private double minConfidenceFix;
	private int allNum;

	@SuppressWarnings("rawtypes")
	HashMap f1map; // 频繁一项集
	ArrayList<AprioriNode> resultSet; // 挖掘出来的结果集
	ArrayList<RuleNode> ruleSet; // 由结果集产生的关联规则

	private boolean useful;
	@SuppressWarnings("rawtypes")
	private HashMap deleteSet;

	@SuppressWarnings("rawtypes")
	public Apriori_transcation_compression() {
		this.setFileName("H:/data/dataset.txt");
		//this.setFileName("关联挖掘数据/1000/1000-out1.csv");
		// this.setFileName("关联挖掘数据/5000/5000-out1.csv");
		// this.setFileName("关联挖掘数据/20000/20000-out1.csv");
		// this.setFileName("关联挖掘数据/75000/75000-out1.csv");
		this.setSpacecharacter(",");
		this.setMinSupportFix(0.01);
		this.setMinConfidenceFix(0.1);
		this.setAllNum(0);
		resultSet = new ArrayList<AprioriNode>();
		ruleSet = new ArrayList<RuleNode>();

		this.setUseful(false);
		deleteSet = new HashMap();
	}

	public static void main(String args[]) {
		// for (int i = 0; i < 31; i++)
		new Apriori_transcation_compression().dataMining();
	}

	/**
	 * Apriori算法入口
	 * 
	 * @date 2015-5-25 11:53:59
	 */
	public void dataMining() {
		long startTime = System.currentTimeMillis();
		f1map = getItemInFile(); // 获取文件中元素的种类集个数
		ArrayList<AprioriNode> l1 = findL1CandidateItemsets(f1map); // 获取频繁一项集
		removeBadItem(l1); // 移除不满足最小支持度计数的项
		aprioriGen(l1); // 由lx-1获取lx的候选集合，递归调用函数挖掘出所有结果
		getRule();
		long endTime = System.currentTimeMillis(); // 获取结束时间
		// System.out.println(endTime - startTime);
		//System.out.println("程序运行时间： " + (endTime - startTime) + "ms");
		writeFx();
		writeRule();
	}

	/**
	 * 获取文件中元素的种类集个数
	 * 
	 * @date 2015-5-25 16:57:04
	 * @param list
	 * @return
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	private HashMap getItemInFile() {
		HashMap map = new HashMap();
		try {
			FileReader fr = new FileReader(this.getFileName());
			BufferedReader br = new BufferedReader(fr);
			try {
				String line;
				while ((line = br.readLine()) != null) {
					String[] str = line.split(spacecharacter);
					for (int i = 0; i < str.length; i++) {
						if (map.get(str[i].trim()) == null)
							map.put(str[i].trim(), 1);
						else {
							int value = Integer.parseInt(map.get(str[i].trim())
									.toString());
							map.put(str[i].trim(), value + 1);
						}
					}
					this.setAllNum(getAllNum() + 1);
				}
				this.setMinSuportNum(this.getAllNum() * this.getMinSupportFix());
			} catch (Exception e1) {
				return null;
			}
			br.close();
			fr.close();
		} catch (Exception e2) {
			System.out.println("Read transaction records failed."
					+ e2.getMessage());
			return null;
		}
		return map;
	}

	/**
	 * 获取频繁一项集，直接将上一步统计结果封装成需要的数据集--频繁一项集
	 * 
	 * @date 2015-5-25 16:58:28
	 * @param map
	 * @return
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	private ArrayList<AprioriNode> findL1CandidateItemsets(HashMap map) {
		ArrayList<AprioriNode> fx = new ArrayList<AprioriNode>();
		String[] names = (String[]) map.keySet().toArray(new String[0]);
		for (int i = 0; i < names.length; i++) {
			AprioriNode an = new AprioriNode();
			if (an.getList() == null) {
				an.setList(new ArrayList<String>());
			}
			an.getList().add(names[i]);
			an.setCount(Integer.parseInt(map.get(names[i]).toString()));
			fx.add(an);
		}
		for (int i = 0; i < fx.size(); i++) {
			for (int j = i + 1; j < fx.size(); j++) {
				if (fx.get(i).getCount() < fx.get(j).getCount()) {
					AprioriNode temp = fx.get(i);
					fx.set(i, fx.get(j));
					fx.set(j, temp);
				}
			}
		}
		return fx;
	}

	/**
	 * 移除不满足最小支持度计数的项
	 * 
	 * @date 2015-5-25 17:01:31
	 * @param lx
	 */
	private void removeBadItem(ArrayList<AprioriNode> lx) {
		for (int i = 0; i < lx.size();) {
			if (lx.get(i).getCount() < this.getMinSuportNum()) {
				lx.remove(i);
			} else {
				i++;
			}
		}
	}

	/**
	 * 由l1依次得到l2,l3....lx-1,lx 其中lx-1首先获取lx候选集，然后扫描数据库获取个数再与minsuport对比最终获得lx
	 * 
	 * @date 2015-5-25 171:19:11
	 * @param lx_1
	 * @param l1
	 * @param data
	 */
	private void aprioriGen(ArrayList<AprioriNode> lx_1) {
		ArrayList<AprioriNode> lx = getCandidateItems(lx_1);
		getCandidateItemsCount(lx);
		removeBadItem(lx);
		for (int i = 0; i < lx.size(); i++) {// 将结果存入dataMining集合
			resultSet.add(lx.get(i));
		}
		if (lx.size() > 0) {// 递归调用aprioriGen算法
			aprioriGen(lx);
		}
	}

	/**
	 * 获取候选的集合
	 * 
	 * @date 2015-5-25 20:59:29
	 * @param lx_1
	 * @return
	 */
	private ArrayList<AprioriNode> getCandidateItems(ArrayList<AprioriNode> lx_1) {
		ArrayList<AprioriNode> lx = new ArrayList<AprioriNode>();
		if (lx_1 != null) {
			for (int i = 0; i < lx_1.size(); i++) {
				for (int j = i + 1; j < lx_1.size(); j++) {
					AprioriNode ap = getItem(lx_1.get(i), lx_1.get(j), lx_1);
					if (ap != null)
						lx.add(ap);
				}
			}
		}
		return lx;
	}

	/**
	 * 由两个lx-1集获取lx
	 * 
	 * @date 2015-5-25 21:07:29
	 * @param ap1
	 * @param ap2
	 * @param lx_1
	 * @return
	 */
	private AprioriNode getItem(AprioriNode ap1, AprioriNode ap2,
			ArrayList<AprioriNode> lx_1) {
		if (ap1.getList().size() == ap2.getList().size()) {
			// 首先由两个lx-1项构造lx
			AprioriNode ap = new AprioriNode();
			ArrayList<String> list = new ArrayList<String>();
			for (int i = 0; i < ap1.getList().size() - 1; i++) {
				if (ap1.getList().get(i).equals(ap2.getList().get(i))) {
					list.add(ap1.getList().get(i));
				} else
					return null;
			}
			list.add(ap1.getList().get(ap1.getList().size() - 1));
			list.add(ap2.getList().get(ap2.getList().size() - 1));
			ap.setList(list);
			ap.setCount(0);
			// 验证得到的项lx的其他子集是否都是频繁的
			for (int i = 0; i < ap.getList().size() - 2; i++) {
				ArrayList<String> tempList = new ArrayList<String>();
				for (int j = 0; j < ap.getList().size(); j++) {
					if (i != j)
						tempList.add(ap.getList().get(j));
				}
				// 验证是否频繁，只需要查看是否在lx-1项集中
				if (!existInLx_1(lx_1, tempList)) {
					return null;
				}
			}
			return ap;
		}
		return null;
	}

	/**
	 * 判断tempList中的元素是否在lx-1中都存在
	 * 
	 * @date 2015-5-27 09:14:12
	 * @param lx_1
	 * @param tempList
	 * @return
	 */
	private boolean existInLx_1(ArrayList<AprioriNode> lx_1,
			ArrayList<String> tempList) {
		for (int i = 0; i < lx_1.size(); i++) {
			ArrayList<String> lx_1Item = lx_1.get(i).getList();
			int j = 0;
			for (j = 0; j < tempList.size(); j++) {
				int k = 0;
				for (k = 0; k < lx_1Item.size(); k++) {
					if (tempList.get(j).equals(lx_1Item.get(k)))
						break;
				}
				if (k == lx_1Item.size()) {// 如果有一个不存在，则直接跳出
					break;
				}
			}
			if (j == tempList.size()) {// j达到tempList.size()，说明都存在
				return true;
			}
		}
		return false;
	}

	/**
	 * 获取候选集合各个元素的个数
	 * 
	 * @date 2015-5-25 10:48:21
	 * @param lx
	 * @param data
	 */
	@SuppressWarnings("unchecked")
	private void getCandidateItemsCount(ArrayList<AprioriNode> lx) {
		try {
			FileReader fr = new FileReader(this.getFileName());
			BufferedReader br = new BufferedReader(fr);
			try {
				String line;
				int k = 0;
				while (true) {
					if (deleteSet.get(++k) != null) {
						br.skip(Integer.parseInt(deleteSet.get(k).toString()));
						continue;
					}
					if ((line = br.readLine()) == null)
						break;
					changeOneItemCount(lx, line.split(spacecharacter));
					if (!this.getUseful()) {
						deleteSet.put(k, line.length() + 2);
					} else
						this.setUseful(false);
				}
			} catch (Exception e1) {
				return;
			}
			br.close();
			fr.close();
		} catch (Exception e2) {
			return;
		}
	}

	/**
	 * 判断该条事务是否包含频繁项集，若包含，则该项集计数+1
	 * 
	 * @param lx
	 * @param oneRecord
	 */
	private void changeOneItemCount(ArrayList<AprioriNode> lx,
			String[] oneRecord) {
		for (int i = 0; i < lx.size(); i++) {
			changeCount(lx.get(i), oneRecord);
		}
	}

	/**
	 * 获取候选集合中一个元素的个数
	 * 
	 * @date 2015-5-25 10:48:21
	 * @param lx
	 * @param data
	 */
	private void changeCount(AprioriNode ap, String[] oneRecord) {
		for (int j = 0; j < ap.getList().size(); j++) {
			if (!itemIsExist(ap.getList().get(j), oneRecord)) {
				break;
			}
			if (j == ap.getList().size() - 1) {
				ap.setCount(ap.getCount() + 1);
				this.setUseful(true);
			}
		}
	}

	/**
	 * 判断字符串item 是否在一条记录中
	 * 
	 * @date 2015-5-25 10:47:04
	 * @param item
	 * @param oneRecord
	 * @return
	 */
	private boolean itemIsExist(String item, String[] oneRecord) {
		for (int i = 0; i < oneRecord.length; i++) {
			if (item.equals(oneRecord[i]))
				return true;
		}
		return false;
	}

	/**
	 * 根据已经找到的频繁项集进行挖掘规则
	 */
	private void getRule() {
		for (int i = 0; i < resultSet.size(); i++) {
			AprioriNode ap = resultSet.get(i);
			for (int j = 1; j < ap.getList().size(); j++) {
				ArrayList<String> out = new ArrayList<String>();
				get(ap, ap.getList().size(), j, out, j);
			}
		}
	}

	/**
	 * 递归调用获取一个频繁项集的组合数，找出所有规则的前缀
	 * 
	 * @param ap
	 * @param nLen
	 * @param m
	 * @param out
	 * @param outLen
	 */
	private void get(AprioriNode ap, int nLen, int m, ArrayList<String> out,
			int outLen) {
		if (m == 0) {
			RuleNode rn = new RuleNode();
			for (int i = out.size() - 1; i >= 0; i--) {// 获取规则前缀
				rn.getPre().add(out.get(i));
			}
			for (int i = 0; i < ap.getList().size(); i++) {// 获取规则后缀
				if (!out.contains(ap.getList().get(i)))
					rn.getRes().add(ap.getList().get(i));
			}
			rn.setSupport((double) ap.getCount() / this.getAllNum());// 设置该条规则支持度
			rn.setConfidence((double) ap.getCount() / getCountForPre(out));
			if (rn.getConfidence() >= this.getMinConfidenceFix())
				ruleSet.add(rn);
			return;
		}
		for (int i = nLen; i >= m; i--) {// 从后往前依次选定一个
			out.add(ap.getList().get(i - 1));
			get(ap, i - 1, m - 1, out, outLen); // 从前i-1个里面选取m-1个进行递归
			out.remove(out.size() - 1);
		}
	}

	/**
	 * 获取规则中前缀的数目
	 * 
	 * @param out
	 * @return
	 */
	private int getCountForPre(ArrayList<String> out) {
		if (out.size() == 1) {
			return Integer.parseInt(f1map.get(out.get(0)).toString());
		}
		for (int i = 0; i < resultSet.size(); i++) {
			ArrayList<String> resultItem = resultSet.get(i).getList();
			if (resultItem.size() != out.size())
				continue;
			int j = 0;
			for (j = 0; j < out.size(); j++) {
				if (!resultItem.contains(out.get(j))) {
					break;
				}
			}
			if (j == out.size()) {
				return resultSet.get(i).getCount();
			}
		}
		return -1;
	}

	/**
	 * 输出得到的结果集
	 * 
	 * @date 2015-5-25 11:44:54
	 * @param dataMining
	 */
	private void writeFx() {
		//System.out.println("频繁一项集:------数目：" + f1map.size());
		// String[] names = (String[]) f1map.keySet().toArray(new String[0]);
		// for (int i = 0; i < names.length; i++) {
		// System.out.print(names[i] + ":" + f1map.get(names[i]) + ";");
		// }
		// System.out.println();
		//System.out.println("resultSet:" + resultSet.size());
		int k = 2, n = 0;
		for (int i = 0; i < resultSet.size(); i++) {
			AprioriNode ap = resultSet.get(i);
			ArrayList<String> list = ap.getList();
//			if (list.size() != k) {
//				System.out.println("频繁" + (k++) + "项集：------数目：" + (i - n));
//				n = i;
//			}
//个数统计
//			for (int j = 0; j < list.size(); j++) {
//				if (j == 0)
//					System.out.print("[" + list.get(j));
//				else
//					System.out.print("," + list.get(j));
//				if (j == list.size() - 1)
//					System.out.println("]:" + ap.getCount() + ";");
//			}
		}
//		if (n != 0) {
//			System.out.println("频繁" + k + "项集：------数目："
//					+ (resultSet.size() - n));
//		}
	}

	/**
	 * 输出得到的规则
	 */
	private void writeRule() {
		//System.out.println("ruleSet:" + ruleSet.size());
		for (int j = 0; j < ruleSet.size(); j++) {
			RuleNode rn = ruleSet.get(j);
			for (int i = 0; i < rn.getPre().size(); i++)
				System.out.print(rn.getPre().get(i) + " ");
			System.out.print("--> ");
			for (int i = 0; i < rn.getRes().size(); i++)
				System.out.print(rn.getRes().get(i) + " ");
			java.text.DecimalFormat df = new java.text.DecimalFormat("#.###");
			System.out.print("支持度:" + df.format(rn.getSupport()) + " 置信度:"
					+ df.format(rn.getConfidence()));
			System.out.println();
		}

	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public String getSpacecharacter() {
		return spacecharacter;
	}

	public void setSpacecharacter(String spacecharacter) {
		this.spacecharacter = spacecharacter;
	}

	public double getMinSuportNum() {
		return minSuportNum;
	}

	public void setMinSuportNum(double minSuportNum) {
		this.minSuportNum = minSuportNum;
	}

	public double getMinSupportFix() {
		return minSupportFix;
	}

	public void setMinSupportFix(double minSupportFix) {
		this.minSupportFix = minSupportFix;
	}

	public double getMinConfidenceFix() {
		return minConfidenceFix;
	}

	public void setMinConfidenceFix(double minConfidenceFix) {
		this.minConfidenceFix = minConfidenceFix;
	}

	public int getAllNum() {
		return allNum;
	}

	public void setAllNum(int allNum) {
		this.allNum = allNum;
	}

	public boolean getUseful() {
		return useful;
	}

	public void setUseful(boolean useful) {
		this.useful = useful;
	}

}
