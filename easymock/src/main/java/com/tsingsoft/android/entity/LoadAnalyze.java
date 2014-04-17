package com.tsingsoft.android.entity;

import java.util.List;
import java.util.TreeMap;

/**
 * <pre>
 * 负荷分析实体
 * </pre>
 * 
 * @author songjz
 * @time 2013年12月18日
 */
public class LoadAnalyze {
	/** 当前时分（格式：02:43，2点43分） */
	private String curHourMinute;

	/** 当前日期（格式：2013.10.18） */
	private String curYmd;

	/** 当前日期的负荷特性 */
	private LoadCharacter curLoadCharacter;

	/** 负荷特性列表 */
	private List<LoadCharacter> ymdloadCharacterList;

	/** 负荷时刻点 */
	private List<String> pointTimeList;

	/** 历史负荷，key：日期，格式为yyyy年MM月dd日；value：负荷值集合，每个长度和 pointTimeList保持一致 */
	private TreeMap<String, List<Double>> hisLoadMap;

	/** 查询的负荷日期集合（格式yyyyMMdd） */
	private List<String> searchYmdList;

	public String getCurHourMinute() {
		return curHourMinute;
	}

	public void setCurHourMinute(String curHourMinute) {
		this.curHourMinute = curHourMinute;
	}

	public String getCurYmd() {
		return curYmd;
	}

	public void setCurYmd(String curYmd) {
		this.curYmd = curYmd;
	}

	public LoadCharacter getCurLoadCharacter() {
		return curLoadCharacter;
	}

	public void setCurLoadCharacter(LoadCharacter curLoadCharacter) {
		this.curLoadCharacter = curLoadCharacter;
	}

	public List<LoadCharacter> getYmdloadCharacterList() {
		return ymdloadCharacterList;
	}

	public void setYmdloadCharacterList(List<LoadCharacter> ymdloadCharacterList) {
		this.ymdloadCharacterList = ymdloadCharacterList;
	}

	public List<String> getPointTimeList() {
		return pointTimeList;
	}

	public void setPointTimeList(List<String> pointTimeList) {
		this.pointTimeList = pointTimeList;
	}

	public TreeMap<String, List<Double>> getHisLoadMap() {
		return hisLoadMap;
	}

	public void setHisLoadMap(TreeMap<String, List<Double>> hisLoadMap) {
		this.hisLoadMap = hisLoadMap;
	}

	public List<String> getSearchYmdList() {
		return searchYmdList;
	}

	public void setSearchYmdList(List<String> searchYmdList) {
		this.searchYmdList = searchYmdList;
	}
}
