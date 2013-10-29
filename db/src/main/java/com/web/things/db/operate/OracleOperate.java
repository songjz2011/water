package com.web.things.db.operate;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;
import java.util.List;

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
public class OracleOperate extends AbstractDBOpreate {

	public List<TableMeta> getAllTableMeta() {
		List<TableMeta> tableList = new LinkedList<TableMeta>();
		DBService service = DBFactory.getDBService();
		Connection conn = null;
		Statement st = null;
		ResultSet rs = null;
		try {
			String sql = "SELECT * FROM USER_TAB_COMMENTS";
			conn = service.getConnection();
			st = conn.createStatement();
			rs = st.executeQuery(sql);
			while (rs.next()) {
				TableMeta meta = buildTableMeta(rs);
				String tableName = meta.getName();
				meta.setColumnList(getTableColumnList(conn, tableName, service));
				tableList.add(meta);
			}
		} catch (Exception e) {
			LoggerUtil.error(getClass(), e);
		} finally {
			service.close(rs, st, conn);
		}
		return tableList;
	}

	/**
	 * 构造TableMeta
	 * 
	 * @param rs
	 * @return
	 * @throws Exception
	 */
	private TableMeta buildTableMeta(ResultSet rs) throws Exception {
		TableMeta tableMeta = new TableMeta();
		tableMeta.setName(rs.getString("TABLE_NAME"));
		tableMeta.setRemark(rs.getString("COMMENTS"));
		tableMeta.setType(rs.getString("TABLE_TYPE"));
		return tableMeta;
	}

	/**
	 * 获取表中列的说明
	 * 
	 * @param service
	 * @param meta
	 * @param tableName
	 * @param user
	 * @return
	 */
	private List<TableColumnMeta> getTableColumnList(Connection conn, String tableName,
			DBService service) {
		List<TableColumnMeta> columnList = new LinkedList<TableColumnMeta>();
		Statement st = null;
		ResultSet rs = null;
		String sql = "SELECT * FROM USER_TAB_COLUMNS WHERE TABLE_NAME='" + tableName + "' ";
		try {
			st = conn.createStatement();
			rs = st.executeQuery(sql);
			while (rs.next()) {
				TableColumnMeta column = new TableColumnMeta();
				column.setName(rs.getString("COLUMN_NAME"));
				column.setType(rs.getString("DATA_TYPE"));
				column.setSize(rs.getString("DATA_LENGTH"));
				column.setNullFlag(rs.getString("NULLABLE"));
				column.setTableName(tableName);
				columnList.add(column);
			}
			setTableColumnMetaRemark(conn, columnList, service);
		} catch (Exception e) {
			LoggerUtil.error(getClass(), e);
		} finally {
			service.close(rs);
			service.close(st);
		}
		return columnList;
	}

	/**
	 * 设置表中列的注释
	 * 
	 * @param conn
	 * @param column
	 * @param service
	 */
	private void setTableColumnMetaRemark(Connection conn, List<TableColumnMeta> columnList,
			DBService service) {
		if (columnList == null || columnList.isEmpty()) {
			return;
		}
		String tableName = columnList.get(0).getTableName();
		Statement st = null;
		ResultSet rs = null;
		String sql = "SELECT * FROM USER_COL_COMMENTS WHERE TABLE_NAME='" + tableName + "' ";
		try {
			st = conn.createStatement();
			rs = st.executeQuery(sql);
			while (rs.next()) {
				setTableColumnMetaRemark(rs, columnList);
			}
		} catch (Exception e) {
			LoggerUtil.error(getClass(), e);
		} finally {
			service.close(rs);
			service.close(st);
		}
	}

	/**
	 * 从结果集中获取列的注释，设置到列对象中
	 * 
	 * @param rs
	 * @param columnList
	 * @throws SQLException
	 */
	private void setTableColumnMetaRemark(ResultSet rs, List<TableColumnMeta> columnList)
			throws SQLException {
		String name = rs.getString("COLUMN_NAME");
		String remark = rs.getString("COMMENTS");
		for (TableColumnMeta meta : columnList) {
			if (name.equalsIgnoreCase(meta.getName())) {
				meta.setRemark(remark);
				break;
			}
		}
	}
	
	public static void main(String[] args) {
		new OracleOperate().getTableMeta("LF_CTRL_NET");
	}
}
