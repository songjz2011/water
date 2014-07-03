package com.design.model.command;

/**
 * <pre>
 * 命令模式--野餐烤肉者
 * 客户端程序 与 “烤肉串者” 紧耦合，尽管简单，但却极为僵化
 * </pre>
 * 
 * @author songjz
 * @time 2014年7月1日
 */
public class Barbecuer {

	public void bakeMutton() {
		System.out.println("烤羊肉");
	}

	public void bakeChickenWing() {
		System.out.println("烤鸡翅");
	}

	public static void main(String[] args) {
		Barbecuer boy = new Barbecuer();
		boy.bakeMutton();
		boy.bakeMutton();
		boy.bakeMutton();
		boy.bakeMutton();
		boy.bakeChickenWing();
		boy.bakeChickenWing();
		boy.bakeChickenWing();
		boy.bakeChickenWing();
		boy.bakeMutton();
		boy.bakeMutton();
	}
}
