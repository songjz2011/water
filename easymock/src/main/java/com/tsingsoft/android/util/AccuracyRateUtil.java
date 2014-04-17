package com.tsingsoft.android.util;

import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/**
 * 准确率计算工具类
 * 
 * @ClassName: AccuracyRateUtil
 * @Description: 日准确率
 * @author Young.L
 * @date Aug 17, 2012 10:46:42 AM
 * 
 */
public class AccuracyRateUtil {

	/**
	 * 计算日准确率
	 * 
	 * @param hisMap
	 *            历史负荷数据
	 * @param fcMap
	 *            预测负荷数据
	 * @Description: 日准确率 = 1-Math.sqrt(日内有效时刻点准确率之和/日内有效准确率的时刻点的数量之和)
	 * @return 日准确率Map
	 */
	public static Map<String, Double> computeAccuracyRate(
			Map<String, TreeMap<String, Double>> hisMap, Map<String, TreeMap<String, Double>> fcMap) {
		Map<String, Double> result = new TreeMap<String, Double>();
		for (String ymd : fcMap.keySet()) {
			TreeMap<String, Double> his = hisMap.get(ymd);
			TreeMap<String, Double> fc = fcMap.get(ymd);
			if (null == his || null == fc) {
				continue;
			}
			double sum = 0;
			int count = 0;
			for (String key : fc.keySet()) {
				if (his.get(key) != null && his.get(key) != 0 && fc.get(key) != null) {
					/* 一个时刻点的准确率 */
					sum += Math.pow((fc.get(key) - his.get(key)) / his.get(key), 2);
					count++;
				}
			}
			double rate = 1 - Math.sqrt(sum / count);

			result.put(ymd, rate);
		}
		return result;
	}

	/**
	 * 计算偏差率，若有一个值为null，则结果为null，返回结果没有*100
	 * 
	 * @param hisLoad
	 *            ：历史负荷
	 * @param forecastLoad
	 *            ：预测负荷
	 * @return
	 */
	public static Double deviationRate(Double hisLoad, Double forecastLoad) {
		Double differ = NumberUtil.reduce(hisLoad, forecastLoad);
		Double rate = NumberUtil.divide(differ, hisLoad);
		if (rate != null) {
			rate = Math.abs(rate);
		}
		return rate;
	}

	/**
	 * 准确率，若两个数据集合的长度不一致，则返回null
	 * 
	 * @param hisList
	 *            ：历史负荷
	 * @param forecastList
	 *            ：预测负荷
	 * @return
	 */
	public static Double accuracyRate(List<Double> hisList, List<Double> forecastList) {
		if (hisList == null || hisList.isEmpty()) {
			return null;
		}
		if (forecastList == null || forecastList.isEmpty()) {
			return null;
		}
		if (forecastList.size() != hisList.size()) {
			return null;
		}
		// 考核点的偏差率的乘方 和
		Double sumOffset = 0d;
		Double count = 0d;
		for (int i = 0; i < hisList.size(); i++) {
			Double hisLoad = hisList.get(i);
			Double forecastLoad = forecastList.get(i);
			Double deviationRate = deviationRate(hisLoad, forecastLoad);
			if (deviationRate != null) {
				sumOffset += Math.pow(deviationRate, 2);
				count++;
			}
		}
		if (count == 0) {
			return null;
		}
		Double result = 1 - Math.sqrt(sumOffset / count);
		return result;
	}
}
