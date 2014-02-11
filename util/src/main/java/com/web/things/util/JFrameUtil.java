package com.web.things.util;

import javax.swing.JApplet;
import javax.swing.JFrame;

/**
 * <pre>
 * JFrame的Util
 * </pre>
 * 
 * @author songjz
 * @time 2014年1月22日
 */
public class JFrameUtil {

	public static void run(JApplet applet, int width, int height) {
		JFrame frame = new JFrame();
		frame.add(applet);
		frame.setSize(width, height);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

}
