package com.web.things.webcms.controller;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;

import com.web.things.webcms.entity.User;
import com.web.things.webcms.repository.UserRepository;
import com.web.things.webcms.repository.UserRepository1;

@Transactional(readOnly = true, rollbackFor = RuntimeException.class)
@Controller
@RequestMapping(value = { "/user" })
public class UserController {

	@Resource
	private UserRepository userRepository;
	@Resource(name = "userRepository1")
	private UserRepository1 userRepository1;

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

	@Transactional(readOnly = false, rollbackFor = RuntimeException.class)
	@RequestMapping(value = "/list1")
	public String list1() {
		for (int i = 0; i < 10; i++) {
			User user = new User();
			user.setName("张三");
			userRepository1.save(user);
			if (i == 5) {
				throw new RuntimeException();
			}
		}
		return "user/listUser";
	}
}
