package com.design.model.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class SendGiftHandler implements InvocationHandler {

	private Pursuit pursuit;

	public SendGiftHandler(Pursuit pursuit) {
		this.pursuit = pursuit;
	}

	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		doBeforeMethod(method.getName());
		Object result = method.invoke(pursuit, args);
		doAfterMethod();
		return result;
	}

	private void doBeforeMethod(String methodName) {
		System.out.println("before " + methodName + "....");
	}

	private void doAfterMethod() {
		System.out.println("-------------------");
	}

	public static void main(String[] args) {
		Girl girl = new Girl();
		girl.setName("小乔");

		Pursuit pursuit = new Pursuit(girl);
		ISendGift send = (ISendGift) Proxy.newProxyInstance(Pursuit.class.getClassLoader(),
				Pursuit.class.getInterfaces(), new SendGiftHandler(pursuit));
		send.sendChocolate();
		send.sendFlower();
	}

}
