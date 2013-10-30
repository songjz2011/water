package com.web.things.db.print;

import java.util.List;

import com.web.things.db.operate.TableMeta;

public interface DBPrint {

	void print(List<TableMeta> tableMetaList);
	
}
