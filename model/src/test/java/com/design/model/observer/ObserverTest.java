package com.design.model.observer;

import org.junit.Test;

public class ObserverTest {

	@Test
	public void bossTest() {
		BossSubject boss = new BossSubject();
		
		StockObserver stock = new StockObserver("张三", boss);
		GameObserver game = new GameObserver("李四", boss);
		
		boss.attach(stock);
		boss.attach(game);
		
		boss.setAction("我胡汉三又回来了");
		
		boss.notice();
	}
	
}
