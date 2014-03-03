package com.design.model.adapter;

public class TranslatorPlayer extends Player {

	private ForeignCenterPlayer player;

	public TranslatorPlayer(String name) {
		super(name);
		this.player = new ForeignCenterPlayer(name);
	}

	public void attack() {
		player.jingong();
	}

	public void defense() {
		player.fangshou();
	}

}
