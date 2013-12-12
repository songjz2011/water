package com.design.model.factory.method;

import com.design.model.factory.Operate;
import com.design.model.factory.OperateAdd;

public class AddOperateFactory implements IOperateFactory {

	public Operate createOperate() {
		return new OperateAdd();
	}

}
