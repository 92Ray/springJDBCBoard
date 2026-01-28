package com.board.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.slf4j.Slf4j;


@Slf4j
@Controller
@RestController("/users")
public class UsersController {
	
	@GetMapping("/insertForm")
	public String getMethodName(Model model) {
		return "users/insertForm";
	}
	
}
