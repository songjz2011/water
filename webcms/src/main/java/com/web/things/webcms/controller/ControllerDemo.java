package com.web.things.webcms.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSONObject;
import com.web.things.webcms.editor.CompanyEditor;
import com.web.things.webcms.entity.Company;
import com.web.things.webcms.entity.Person;
import com.web.things.webcms.validator.PersonValidator;

/**
 * <pre>
 * spring mvc controller demo
 * </pre>
 * 
 * @author songjz
 * @time 2014年3月24日
 */
@Controller
@RequestMapping(value = "/spring-demo")
public class ControllerDemo {

	@Resource
	private CompanyEditor companyEditor;

	@InitBinder
	public void initBinder(WebDataBinder binder) {
		// 添加一个日期类型编辑器，也就是需要日期类型的时候，怎么把字符串转化为日期类型
//		
//		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
//		dateFormat.setLenient(false);
//		binder.registerCustomEditor(Date.class, "createTime",
//				new CustomDateEditor(dateFormat, true));
//		
		// 添加一个自定义编辑器
		binder.registerCustomEditor(Company.class, "company", companyEditor);

		// 添加一个自定义的validator
		binder.setValidator(new PersonValidator());
	}

	@RequestMapping(value = "/helloworld")
	public String helloworld(HttpServletRequest request) {
		request.setAttribute("name", "汤姆");
		return "demo/spring/helloworld";
	}
	
	@RequestMapping(value = "/json", method = RequestMethod.POST, produces="text/plain;charset=UTF-8")
	@ResponseBody
	public String json(HttpServletRequest request) {
		JSONObject obj = new JSONObject();
		obj.put("data", "我是谁");
		return obj.toString();
	}

	@RequestMapping(value = "/validator")
	public String validator(@Validated Person person, BindingResult br, HttpServletRequest request) {
		if (br.hasErrors()) {
			List<FieldError> list = br.getFieldErrors();
			for(FieldError error : list) {
				System.out.println(error.getField() + " = " + error.getObjectName());
			}
			return "demo/spring/edit_person";
		}
		return "demo/spring/helloworld";
	}
}
