package com.web.things.tag;

import javax.servlet.jsp.tagext.TagData;
import javax.servlet.jsp.tagext.TagExtraInfo;
import javax.servlet.jsp.tagext.VariableInfo;

/**
 * @author songjz
 * @time 2013年7月31日
 */
public class ForEachTEI extends TagExtraInfo {

	/**
	 * <pre>
	 * 其中AT_BEGIN, NESTED, AT_END是标签扩展信息类(TEI)的VariableInfo中定义。
	 * 如果设置为AT_BEGIN：变量在当前动作元素的开始标记之后就对调用者可见；
	 * 如果此属性设置为AT_END：那么变量则在结束标记之后可见；
	 * NESTED：说明它仅在开始和结束标记之间可见。
	 * </pre>
	 */
	@Override
	public VariableInfo[] getVariableInfo(TagData data) {
		return new VariableInfo[] { new VariableInfo(data.getAttributeString("name"),
				data.getAttributeString("type"), true, VariableInfo.NESTED), };
	}

}
