package com.model.state;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * @author songjz
 * @time 2013年8月27日
 */
public class MouseMoveList extends ArrayList<MouseAction> {

	private static final long serialVersionUID = 3979223160393100842L;

	public MouseMoveList(Iterator<String> it) {
		while (it.hasNext()) {
			add(MouseAction.forString(it.next()));
		}
	}

}
