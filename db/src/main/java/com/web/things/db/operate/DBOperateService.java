package com.web.things.db.operate;

import java.util.List;

public interface DBOperateService {

	/**
	 * 获取配置的数据用户中，所有的表说明
	 * 
	 * @return
	 */
	List<TableMeta> getAllTableMeta();

	/**
	 * 获取单个表的说明
	 * 
	 * @param tableName
	 * @return
	 */
	TableMeta getTableMeta(String tableName);

	/**
	 * 获取多个表的说明
	 * 
	 * @param tableNames
	 * @return
	 */
	List<TableMeta> getTableMetaList(String... tableNames);

	/**
	 * 获取多个表的说明
	 * 
	 * @param tableNameList
	 * @return
	 */
	List<TableMeta> getTableMetaList(List<String> tableNameList);

}
