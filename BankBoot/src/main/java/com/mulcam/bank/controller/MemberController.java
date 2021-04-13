package com.mulcam.bank.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.mulcam.bank.service.MemberService;
import com.mulcam.bank.vo.Member;

@Controller
public class MemberController {
	@Autowired
	private MemberService memberService;

	@RequestMapping(value="/login", method=RequestMethod.GET)
	public String login(Model model) {
		model.addAttribute("page", "login_form");
		return "template";
	}
	
	@RequestMapping(value="/login", method=RequestMethod.POST)
	public ModelAndView login(@RequestParam(value="id", required=true) String id,
			@RequestParam(value="password", required=true) String password, HttpServletRequest request) {
		ModelAndView modelAndView = new ModelAndView();
		try {
			boolean success = memberService.login(id, password);
			if(!success) throw new Exception("비밀번호 오류");
			request.getSession().setAttribute("id", id);
			modelAndView.addObject("page", "makeaccount_form");
		} catch(Exception e) {
			e.printStackTrace();
			modelAndView.addObject("page", "login_form");
		}
		modelAndView.setViewName("template");
		return modelAndView;
	}

	@RequestMapping(value="/logout", method=RequestMethod.GET)
	public String logout(HttpServletRequest request, Model model) {
		request.getSession().removeAttribute("id");
		model.addAttribute("page", "login_form");
		return "template";
	}
	
	@RequestMapping(value="/join", method=RequestMethod.GET)
	public String join(Model model) {
		model.addAttribute("page","join_form");
		return "template";
	}
	
	@RequestMapping(value="/join", method=RequestMethod.POST)
	public ModelAndView join(@ModelAttribute Member member) {
		ModelAndView modelAndView = new ModelAndView();
		try {
			memberService.join(member);
			modelAndView.addObject("page", "login_form");
		} catch (Exception e) {
			modelAndView.addObject("err", "회원가입 오류");
			modelAndView.addObject("page", "err");
		}
		modelAndView.setViewName("template");
		return modelAndView;
	}
}
