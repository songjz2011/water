package com.design.model.builder;

import java.awt.Graphics;

import javax.swing.JPanel;

/**
 * <pre>
 * 绘制小人的画板
 * </pre>
 * 
 * @author songjz
 * @time 2014年1月22日
 */
public class PersonPanel extends JPanel{

	private static final long serialVersionUID = 6886637867682068145L;

	private PersonBuilder personBuilder;
	
	public PersonPanel(PersonBuilder personBuilder) {
		this.personBuilder = personBuilder;
	}

	public void paint(Graphics g) {
		super.paint(g);
		personBuilder.setGraphics(g);
		PersonDirector.builderPerson(personBuilder);
	}
	
}
