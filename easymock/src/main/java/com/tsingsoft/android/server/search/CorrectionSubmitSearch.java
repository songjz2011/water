package com.tsingsoft.android.server.search;

import java.util.ArrayList;
import java.util.List;

import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;

import com.tsingsoft.android.server.ServerSearchConstant;

/**
 * 负荷上报bean
 * 
 * @author F.Liu
 * 
 */
public class CorrectionSubmitSearch extends AbstractServerSearch<String> {
	private String netId;
	private String caliberId;
	private String ymd;
	private String fcNO;
	private List<Double> loads; 

	public String getNetId() {
		return netId;
	}

	public void setNetId(String netId) {
		this.netId = netId;
	}

	public String getCaliberId() {
		return caliberId;
	}

	public void setCaliberId(String caliberId) {
		this.caliberId = caliberId;
	}

	public String getYmd() {
		return ymd;
	}

	public void setYmd(String ymd) {
		this.ymd = ymd;
	}

	public String getFcNO() {
		return fcNO;
	}

	public void setFcNO(String fcNO) {
		this.fcNO = fcNO;
	}

	public List<Double> getLoads() {
		return loads;
	}

	public void setLoads(List<Double> loads) {
		this.loads = loads;
	}
	
	public ServerSearchCondition buildSearchCondition() {
		ServerSearchCondition serverSearchCondition = new ServerSearchCondition();
		List<NameValuePair> pairList = new ArrayList<NameValuePair>();
		pairList.add(new BasicNameValuePair("netId", trim(getNetId(),
				ServerSearchConstant.defaultNetID)));
		pairList.add(new BasicNameValuePair("caliberId", trim(getCaliberId(),
				ServerSearchConstant.defaultCaliberID)));
		pairList.add(new BasicNameValuePair("fcNO", trim(getFcNO())));
		pairList.add(new BasicNameValuePair("ymd", trim(getYmd())));
		pairList.add(new BasicNameValuePair("loads", buildLoads(getLoads())));
		serverSearchCondition.setPairList(pairList);
		return serverSearchCondition;
	}
	
	private String buildLoads(List<Double> loads){
		StringBuilder sb = new StringBuilder();
		if(null != loads && !loads.isEmpty()){
			for(Double d : loads){
				sb.append(",").append(d);
			}
		}
		return sb.toString().substring(1);
	}

	
	
	
}
