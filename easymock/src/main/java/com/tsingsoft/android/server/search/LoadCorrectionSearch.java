package com.tsingsoft.android.server.search;

import java.util.ArrayList;
import java.util.List;

import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;

import com.tsingsoft.android.entity.LoadCorrection;
import com.tsingsoft.android.server.ServerSearchConstant;

/**
 * 负荷修查询接口
 * 
 * @author F.Liu
 * 
 */
public class LoadCorrectionSearch extends AbstractServerSearch<LoadCorrection> {

	/**
	 * 修改模块查询类型
	 */
	public static String AMEND_SEARCH_TYPE="0";
	/**
	 * 上报模块查询类型
	 */
	public static String REPORT_SEARCH_TYPE="1";
	/**
	 * 预测地区 (默认当前用户所在的netID)
	 */
	private String netId;

	/**
	 * 预测日期 (默认明天)
	 */
	private String forecastDate=null;

	/**
	 * 负荷修正入口类型 0：负荷修正 2：修正上报
	 */
	private String type = AMEND_SEARCH_TYPE;

	/**
	 * 参考日期 (默认3天前)
	 */
	private String referenceDate =null;
	
	
	public ServerSearchCondition buildSearchCondition() {
		ServerSearchCondition serverSearchCondition = new ServerSearchCondition();
		List<NameValuePair> pairList = new ArrayList<NameValuePair>();
		pairList.add(new BasicNameValuePair("queryNetID", trim(getNetId(),
				ServerSearchConstant.defaultNetID)));
		pairList.add(new BasicNameValuePair("caliberId", trim(getCaliberId(),
				ServerSearchConstant.defaultCaliberID)));
		pairList.add(new BasicNameValuePair("forecastDate",
				getForecastDate()));
		pairList.add(new BasicNameValuePair("referenceDate",
				trim(getReferenceDate())));
		pairList.add(new BasicNameValuePair("type", trim(getType())));

		pairList.add(new BasicNameValuePair("referenceDateStr",
				getDefaultReferDateStr()));
		serverSearchCondition.setPairList(pairList);
		return serverSearchCondition;
	}

	public String getNetId() {
		return netId;
	}

	public void setNetId(String netId) {
		this.netId = netId;
	}

	public String getForecastDate() {
		return forecastDate;
	}

	public void setForecastDate(String forecastDate) {
		this.forecastDate = forecastDate;
	}

	public String getReferenceDate() {
		return referenceDate;
	}

	public void setReferenceDate(String referenceDate) {
		this.referenceDate = referenceDate;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	/**
	 * 如果有则查询，没有则查询昨天，前天的数据
	 * 
	 * @return
	 */
	private String getDefaultReferDateStr() {
		List<String> ymds = getYmdList();
		String str = "";
		if (ymds != null && !ymds.isEmpty()) {
			for (String ymd : ymds) {
				if (ymd != null) {
					str += "," + ymd;
				}

			}
			return str.substring(1);
		}else{
			return null;
		}
	}

}
