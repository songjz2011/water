package com.tsingsoft.android.server.search;

import java.util.ArrayList;
import java.util.List;

import org.apache.http.NameValuePair;

import com.tsingsoft.android.entity.SystemDate;



/**
 * 系统时间
 * @author F.Liu
 *
 */
public class SystemDateSearch extends AbstractServerSearch<SystemDate>{

	/**
	 * 
	 */
	public ServerSearchCondition buildSearchCondition() {
		ServerSearchCondition serverSearchCondition = new ServerSearchCondition();
		List<NameValuePair> pairList = new ArrayList<NameValuePair>();
		serverSearchCondition.setPairList(pairList);
		return serverSearchCondition;
	}
	
}
