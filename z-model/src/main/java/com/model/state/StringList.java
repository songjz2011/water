package com.model.state;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;

/**
 * @author songjz
 * @time 2013年8月27日
 */
public class StringList extends ArrayList<String> {

	private static final long serialVersionUID = 4194873684200555511L;

	@SuppressWarnings("resource")
	public StringList(String textFilePath) {
		try {
			BufferedReader br = new BufferedReader(new FileReader(textFilePath));
			String line = br.readLine();
			while (line != null) {
				add(line.trim());
				line = br.readLine();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
