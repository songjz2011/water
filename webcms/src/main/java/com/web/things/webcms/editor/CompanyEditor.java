package com.web.things.webcms.editor;

import java.beans.PropertyEditorSupport;

import org.springframework.stereotype.Component;

import com.web.things.webcms.entity.Company;
import com.web.things.webcms.util.StringUtil;

@Component
public class CompanyEditor extends PropertyEditorSupport {

	@Override
	public void setAsText(String text) throws IllegalArgumentException {
		if (!StringUtil.isEmpty(text)) {
			Company c = new Company();
			c.setName(text);
			setValue(c);
		}
	}

}
