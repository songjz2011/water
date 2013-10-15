package com.model.state;

import java.util.ArrayList;
import java.util.List;

/**
 * @author songjz
 * @time 2013年8月27日
 */
public class MouseAction implements Input {

	private String action;

	private static List<MouseAction> instances = new ArrayList<MouseAction>();

	private MouseAction(String action) {
		this.action = action;
		instances.add(this);
	}

	public String toString() {
		return this.action;
	}

	public int hashCode() {
		return action.hashCode();
	}

	public boolean equals(Object o) {
		return (o instanceof MouseAction) && action.equals(((MouseAction) o).action);
	}

	public static MouseAction forString(String description) {
		for (MouseAction mouseAction : instances) {
			if (mouseAction.toString().equals(description)) {
				return mouseAction;
			}
		}
		throw new RuntimeException("not found: " + description);
	}

	public static MouseAction appears = new MouseAction("mouse appears"),
			runsAway = new MouseAction("mouse runs away"), enters = new MouseAction(
					"mouse enters trap"), escapes = new MouseAction("mouse escapes"),
			trapped = new MouseAction("mouse trapped"), removed = new MouseAction("mouse removed");
	
	
}
