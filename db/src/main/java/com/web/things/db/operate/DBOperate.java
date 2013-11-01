package com.web.things.db.operate;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.ResultSet;
import java.util.LinkedList;
import java.util.List;

import com.web.things.db.DBFactory;
import com.web.things.db.DBService;
import com.web.things.util.LoggerUtil;

/**
 * <pre>
 * 数据库操作
 * 此类中的方法，使用oracle时，REMARKS取不出数据，oracle中的表备注是comments
 * </pre>
 * 
 * @author songjz
 * @time 2013年11月2日
 */
public class DBOperate extends AbstractDBOpreate {
	/**
	 * <pre>
	 * 说明备注：
	 * DatabaseMetaData.getTables
	 * 参数:catalog:目录名称，一般都为空.
	 * 参数：schema:数据库名，对于oracle来说就用户名
	 * 参数：tablename:表名称
	 * 参数：type :表的类型(TABLE | VIEW)
	 * 注意：在使用过程中，参数名称必须使用大写的。否则得到什么东西
	 * 
	 * <pre>
	 */

	public List<TableMeta> getAllTableMeta() {
		List<TableMeta> tableList = new LinkedList<TableMeta>();
		DBService service = DBFactory.getDBService();
		Connection conn = null;
		ResultSet rs = null;
		try {
			conn = service.getConnection();
			DatabaseMetaData meta = conn.getMetaData();
			String user = meta.getUserName();
			rs = meta.getTables(conn.getCatalog(), user, "%", new String[] { "TABLE" });
			while (rs.next()) {
				TableMeta tableMeta = buildTableMeta(rs);
				String tableName = tableMeta.getName();
				tableMeta.setColumnList(getTableColumnList(service, meta, tableName, user));
				tableList.add(tableMeta);
			}
		} catch (Exception e) {
			LoggerUtil.error(getClass(), e);
		} finally {
			service.close(rs, null, conn);
		}
		return tableList;
	}

	public TableMeta getTableMeta(String tableName) {
		DBService service = DBFactory.getDBService();
		TableMeta tableMeta = null;
		Connection conn = null;
		ResultSet rs = null;
		try {
			conn = service.getConnection();
			DatabaseMetaData meta = conn.getMetaData();
			String user = meta.getUserName();
			rs = meta.getTables(conn.getCatalog(), user, tableName, new String[] { "TABLE" });
			if (rs.next()) {
				tableMeta = buildTableMeta(rs);
				tableMeta.setColumnList(getTableColumnList(service, meta, tableName, user));
			}
		} catch (Exception e) {
			LoggerUtil.error(getClass(), e);
		} finally {
			service.close(rs, null, conn);
		}
		return tableMeta;
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
		tableMeta.setRemark(rs.getString("REMARKS"));
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
	private List<TableColumnMeta> getTableColumnList(DBService service, DatabaseMetaData meta,
			String tableName, String user) {
		List<TableColumnMeta> columnList = new LinkedList<TableColumnMeta>();
		ResultSet rs = null;
		try {
			rs = meta.getColumns(null, user, tableName, "%");
			while (rs.next()) {
				TableColumnMeta column = new TableColumnMeta();
				column.setName(rs.getString("COLUMN_NAME"));
				column.setRemark(rs.getString("REMARKS"));
				column.setType(rs.getString("TYPE_NAME"));
				column.setSize(rs.getString("COLUMN_SIZE"));
				column.setNullFlag(rs.getString("IS_NULLABLE"));
				column.setTableName(tableName);
				columnList.add(column);
			}
		} catch (Exception e) {
			LoggerUtil.error(getClass(), e);
		} finally {
			service.close(rs);
		}
		return columnList;
	}

	public static void main(String[] args) {
		new DBOperate().getAllTableMeta();
	}
}
