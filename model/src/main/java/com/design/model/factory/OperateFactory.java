package com.design.model.factory;

/**
 * <pre>
 * 构造计算对象的工厂
 * </pre>
 * 
 * @author songjz
 * @time 2013年12月3日
 */
public class OperateFactory {

	public static Operate createOperate(OperateEnum operate) {
		Operate op = null;
		switch (operate) {
		case ADD:
			op = new OperateAdd();
			break;
		case SUB:
			op = new OperateSub();
		default:
			break;
		}
		return op;
	}

}
