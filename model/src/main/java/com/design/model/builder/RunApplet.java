package com.design.model.builder;

import javax.swing.JApplet;
import javax.swing.JPanel;

import com.web.things.util.JFrameUtil;

public class RunApplet extends JApplet{

	private static final long serialVersionUID = 1L;

	public void init() {
		PersonBuilder pen = new ThinPersonBuilder();
		JPanel panel = new PersonPanel(pen);
		this.add(panel);
	}
	
	public static void main(String[] args) {
		JFrameUtil.run(new RunApplet(), 100, 100);
	}
	
}
