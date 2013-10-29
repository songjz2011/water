package com.web.things.db.operate;

import java.util.LinkedList;
import java.util.List;

public abstract class AbstractDBOpreate implements DBOperateService {

	public TableMeta getTableMeta(String tableName) {
		List<TableMeta> metaList = getTableMetaList(tableName);
		if (metaList == null || metaList.isEmpty()) {
			return null;
		}
		return metaList.get(0);
	}

	public List<TableMeta> getTableMetaList(String... tableNames) {
		List<String> tableNameList = new LinkedList<String>();
		if (tableNames != null) {
			for (String name : tableNames) {
				tableNameList.add(name);
			}
		}
		return getTableMetaList(tableNameList);
	}

	public List<TableMeta> getTableMetaList(List<String> tableNameList) {
		List<TableMeta> result = new LinkedList<TableMeta>();
		if (tableNameList == null || tableNameList.isEmpty()) {
			return result;
		}
		List<TableMeta> tableMetaList = getAllTableMeta();
		for (TableMeta meta : tableMetaList) {
			String metaName = meta.getName();
			for (String name : tableNameList) {
				if (metaName.equalsIgnoreCase(name)) {
					result.add(meta);
				}
			}
		}
		return result;
	}
}
