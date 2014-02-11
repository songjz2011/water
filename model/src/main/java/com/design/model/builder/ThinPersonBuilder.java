package com.design.model.builder;


public class ThinPersonBuilder extends PersonBuilder {

	private int leftArmX = 55;

	private int rightArmX = 65;
	private int armXOffset = 7;

	private int centerPoint = (rightArmX - leftArmX) / 2;
	private int leftLegX = leftArmX + centerPoint - 2;
	private int rightLegX = leftArmX + centerPoint + 2;

	public void builderHead() {
		// 头
		graphics.drawOval(50, 20, 20, 20);
	}

	public void builderBody() {
		// 身体
		graphics.drawRect(leftArmX, 40, rightArmX - leftArmX, 20);
	}

	public void builderLeftArm() {
		graphics.drawLine(leftArmX, 40, leftArmX - armXOffset, 55);
	}

	public void builderRightArm() {
		graphics.drawLine(rightArmX, 40, rightArmX + armXOffset, 55);
	}

	public void builderLeftLeg() {
		graphics.drawLine(leftLegX, 60, leftLegX - armXOffset, 80);
	}

	public void builderRightLeg() {
		graphics.drawLine(rightLegX, 60, rightLegX + armXOffset, 80);
	}

}
