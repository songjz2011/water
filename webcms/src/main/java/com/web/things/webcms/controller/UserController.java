package com.web.things.webcms.controller;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;

import com.web.things.webcms.entity.User;
import com.web.things.webcms.repository.UserRepository;

@Transactional(readOnly = true)
@Controller
@RequestMapping(value = { "/user" })
public class UserController {

	@Resource
	private UserRepository userRepository;

	@Transactional(readOnly = false, rollbackFor = RuntimeException.class)
	@RequestMapping(value = "/list")
	public String list() {
		for (int i = 0; i < 10; i++) {
			User user = new User();
			user.setName("张三");
			userRepository.save(user);
			if (i == 5) {
				throw new RuntimeException();
			}
		}
		return "user/listUser";
	}
}
