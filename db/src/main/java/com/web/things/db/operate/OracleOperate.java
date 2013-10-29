package com.web.things.db.operate;

import java.sql.Connection;
import java.sql.ResultSet;

import com.web.things.db.DBFactory;
import com.web.things.db.DBService;
import com.web.things.util.LoggerUtil;

/**
 * <pre>
 * oralce数据库操作
 * </pre>
 * 
 * @author songjz
 * @time 2013年10月29日
 */
public class OracleOperate {

	public void getTableMeta(String tableName) {
		DBService service = DBFactory.getDBService();
		Connection conn = null;
		ResultSet rs = null;
		try {
			String sql = "SELECT * FROM USER_TAB_COMMENTS";

		} catch (Exception e) {
			LoggerUtil.error(getClass(), e);
		} finally {
			service.close(rs, null, conn);
		}
	}

}
