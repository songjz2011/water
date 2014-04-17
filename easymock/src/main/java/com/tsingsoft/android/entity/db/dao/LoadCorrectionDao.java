package com.tsingsoft.android.entity.db.dao;


import java.util.List;

import android.content.Context;

import com.tsingsoft.android.entity.LoadCorrection;

/**
 * 负荷修正层持久层
 * @author F.Liu
 *
 */
public class LoadCorrectionDao {

	public LoadCorrectionDao(Context context) {
	}
	
	/**
	 * 负荷预测表入库
	 * 这份数据入库用户负荷修正时进行还原
	 * @param loadCorrection
	 */
	public void insertCorrection(LoadCorrection loadCorrection){
		 
	}
	
	/**
	 * 负荷修正保存时入库
	 * 先删除，再插入
	 * @param loadCorrection
	 */
	public void insertCorrectionUpdate(LoadCorrection loadCorrection){
	}
	
	
	/**
	 * 负荷修正还原
	 * 直接copy ST_FC_96LC数据到
	 */
	public List<Double> restoreCorrectionUpdate(String netId,String caliberId,String ymd){
		return null;
		
	}
	
	/**
	 * 获取上报曲线
	 * @param netId
	 * @param caliberId
	 * @param ymd
	 * @return
	 */
	public List<Double> getFcSubmit(String netId,String caliberId,String ymd){
		return null;
	}
	
}
