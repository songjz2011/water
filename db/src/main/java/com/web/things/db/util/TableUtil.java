package com.web.things.db.util;

import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

import com.web.things.db.operate.TableColumnMeta;

public class TableUtil {

	public static void orderByName(List<TableColumnMeta> columnMetaList) {
		List<TableColumnMeta> timePointColumn = filterTimePointColumnList(columnMetaList);
		if (timePointColumn.isEmpty()) {
			return;
		}
		List<TableColumnMeta> otherColumn = filterNotTimePointColumnList(columnMetaList);
		// 只对时刻点的列排序
		Collections.sort(timePointColumn, buildTableColumnMetaNameComparator());
		columnMetaList.clear();

		columnMetaList.addAll(otherColumn);
		columnMetaList.addAll(timePointColumn);
	}

	/**
	 * 过滤出不是 时刻点的列
	 * 
	 * @param columnMetaList
	 * @return
	 */
	private static List<TableColumnMeta> filterNotTimePointColumnList(
			List<TableColumnMeta> columnMetaList) {
		return filterColumnListForTimePoint(columnMetaList, false);
	}

	/**
	 * 过滤出是 时刻点的列
	 * 
	 * @param columnMetaList
	 * @return
	 */
	private static List<TableColumnMeta> filterTimePointColumnList(
			List<TableColumnMeta> columnMetaList) {
		return filterColumnListForTimePoint(columnMetaList, true);
	}

	/**
	 * 过滤是否 是时刻点的列
	 * 
	 * @param columnMetaList
	 * @param isTimePoint
	 *            ：是否 是时刻点
	 * @return
	 */
	private static List<TableColumnMeta> filterColumnListForTimePoint(
			List<TableColumnMeta> columnMetaList, boolean isTimePoint) {
		List<TableColumnMeta> result = new LinkedList<TableColumnMeta>();
		for (TableColumnMeta column : columnMetaList) {
			// 如果是时刻点
			if (isTimePoint && isTimePoint(column.getName())) {
				result.add(column);
				continue;
			}
			// 如果不是时刻点
			if (!isTimePoint && !isTimePoint(column.getName())) {
				result.add(column);
				continue;
			}
		}
		return result;
	}

	/**
	 * 根据列名，判断是否是时刻点
	 * 
	 * @param name
	 * @return
	 */
	private static boolean isTimePoint(String name) {
		boolean result = false;
		String timePoint = name.substring(1);
		try {
			Integer timePointInt = Integer.valueOf(timePoint);
			if (timePointInt <= 2400 && timePointInt >= 0) {
				result = true;
			}
		} catch (Exception e) {
		}
		return result;
	}

	/**
	 * 
	 * @return
	 */
	private static Comparator<TableColumnMeta> buildTableColumnMetaNameComparator() {
		Comparator<TableColumnMeta> result = new Comparator<TableColumnMeta>() {
			public int compare(TableColumnMeta o1, TableColumnMeta o2) {
				return o1.getName().compareToIgnoreCase(o2.getName());
			}
		};
		return result;
	}

}
