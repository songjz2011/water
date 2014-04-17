package com.tsingsoft.android.entity;

import java.util.List;

/**
 * 负荷上报
 * @author F.Liu
 *
 */
public class CorrectionSubmit {
	
	/**
	 * 修正后的预测曲线
	 */
	private List<Double> fcDatas;
	
	private String saveMsg;

	public List<Double> getFcDatas() {
		return fcDatas;
	}

	public void setFcDatas(List<Double> fcDatas) {
		this.fcDatas = fcDatas;
	}

	public String getSaveMsg() {
		return saveMsg;
	}

	public void setSaveMsg(String saveMsg) {
		this.saveMsg = saveMsg;
	}
	
}
