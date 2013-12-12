package com.design.model.factory.method;

import com.design.model.factory.Operate;
import com.design.model.factory.OperateSub;

public class SubOperateFactory implements IOperateFactory {

	public Operate createOperate() {
		return new OperateSub();
	}

}
