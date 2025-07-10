package com.smhrd.web.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.smhrd.web.entity.DataMember;
import com.smhrd.web.repo.DataMemberRepository;

import jakarta.servlet.http.HttpSession;

@Controller
public class MyController {
	
	Logger logger = LoggerFactory.getLogger(getClass());
	
	@Autowired
	DataMemberRepository repository;
	
	@PostMapping("/login-process")
	public String main(DataMember member, HttpSession session) {
		// HttpSession을 사용하고 싶다면 파라미터로 수집
		DataMember loginMember = repository.findByIdAndPw(member.getId(), member.getPw());
		session.setAttribute("login", loginMember);
		
		return "redirect:/main";
	}
	
	@PostMapping("/join-process")
	public String joinProcess(DataMember member) {
		repository.save(member);
		return "redirect:/";
	}
}
