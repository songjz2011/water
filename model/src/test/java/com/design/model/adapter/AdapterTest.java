package com.design.model.adapter;

import java.util.LinkedList;
import java.util.List;

import org.junit.Test;

public class AdapterTest {

	@Test
	public void test() {
		List<Player> list = new LinkedList<Player>();
		
		Player f = new ForwardsPlayer("NBA的前锋");
		list.add(f);
		
		Player d = new GuardsPlayer("NBA的后卫");
		list.add(d);
		
		Player c = new TranslatorPlayer("NBA的外籍后卫");
		list.add(c);
		
		for(Player player : list) {
			player.attack();
			player.defense();
			System.out.println();
		}
		
	}

}
