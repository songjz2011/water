/*
 * ConnectRequest.java
 * Copyright: Copyright TsingSoft (c) 2013
 * Company: 北京清软创新科技有限公司
 */
package com.tsingsoft.android.server.connect;

import android.content.Context;

import com.tsingsoft.android.server.exception.SearchException;
import com.tsingsoft.android.server.search.ServerSearch;

/**
 * <pre>
 * 连接服务器端的请求接口
 * </pre>
 * 
 * @author songjz
 * @time 2013-12-9
 */
public interface ConnectRequest {

	<T> T search(ServerSearch<T> search, Context context) throws SearchException;

}
