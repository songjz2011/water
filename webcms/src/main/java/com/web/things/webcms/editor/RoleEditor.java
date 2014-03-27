package com.web.things.webcms.editor;

import java.beans.PropertyEditorSupport;

import com.web.things.webcms.entity.Role;
import com.web.things.webcms.util.StringUtil;

public class RoleEditor extends PropertyEditorSupport {

	@Override
	public void setAsText(String text) throws IllegalArgumentException {
		if (!StringUtil.isEmpty(text)) {
			Role role = new Role();
			role.setName(text);
			super.setValue(role);
		}
	}

}
