package com.mulcam.bank.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.mulcam.bank.service.AccountService;
import com.mulcam.bank.vo.Account;

@Controller
public class AccountController {

	@Autowired
	private AccountService accountService;
	
	
	@RequestMapping(value="/", method=RequestMethod.GET)
	public String main(Model model) {
		model.addAttribute("page", "login_form");
		return "template";
	}
	
	@RequestMapping(value="/makeaccount", method=RequestMethod.GET)
	public String makeAccount(Model model) {
		model.addAttribute("page", "makeaccount_form");
		return "template";
	}

	@RequestMapping(value="/makeaccount", method=RequestMethod.POST)
	public String makeAccount(@ModelAttribute Account acc, Model model) {
		try {
			accountService.makeAccount(acc);
			model.addAttribute("page", "makeaccount_success");
		} catch(Exception e) {
			e.printStackTrace();
			model.addAttribute("err", "계좌 개설 실패");
			model.addAttribute("page", "err");
		}
		return "template";
	}
	
	@RequestMapping(value="/deposit", method=RequestMethod.GET)
	public String deposit(Model model) {
		model.addAttribute("page", "deposit_form");
		return "template";
	}
	
	@RequestMapping(value="/deposit", method=RequestMethod.POST)
	public String deposit(@RequestParam(value="id", required = true) String id,
						  @RequestParam(value="money", required=true) int money, Model model) {
		
		try {
			accountService.deposit(id, money);
			model.addAttribute("accid", id);
			model.addAttribute("money", money);
			model.addAttribute("page", "deposit_success");
		} catch(Exception e) {
			e.printStackTrace();
			model.addAttribute("err","입금 실패");
			model.addAttribute("page", "err");
		}
		return "template";
	}
	
	@RequestMapping(value="/withdraw", method=RequestMethod.GET)
	public String withdraw(Model model) {
		model.addAttribute("page", "withdraw_form");
		return "template";
	}
	
	@RequestMapping(value="/withdraw", method=RequestMethod.POST)
	public String withdraw(@RequestParam(value="id", required = true) String id,
						   @RequestParam(value="money", required=true) int money, Model model) {
		try {
			accountService.withdraw(id, money);
			model.addAttribute("accid", id);
			model.addAttribute("money", money);
			model.addAttribute("page", "withdraw_success");
		} catch(Exception e) {
			e.printStackTrace();
			model.addAttribute("err","출금 실패");
			model.addAttribute("page", "err");
		}
		return "template";
	}
	
	@RequestMapping(value="/accinfo", method=RequestMethod.GET)
	public String accInfo(Model model) {
		model.addAttribute("page", "accinfo_form");
		return "template";
	}
	@RequestMapping(value="/accinfo", method=RequestMethod.POST)
	public ModelAndView accInfo(@RequestParam(value="id", required = true) String id) {
		ModelAndView modelAndView= new ModelAndView();
		try {
			Account acc = accountService.accountInfo(id);
			modelAndView.addObject("acc", acc);
			modelAndView.addObject("page","accinfo_success");
		} catch(Exception e) {
			e.printStackTrace();
			modelAndView.addObject("err", "계좌조회 오류");
			modelAndView.addObject("page", "err");	
		}
		modelAndView.setViewName("template");
		return modelAndView;
	}
	
	@RequestMapping(value="/allaccinfo", method=RequestMethod.GET)
	public String allAccInfo(Model model) {
		model.addAttribute("page", "allaccinfo_form");
		return "template";
	}
	@RequestMapping(value="/allaccinfo", method=RequestMethod.POST)
	public ModelAndView allAccInfo() {
		ModelAndView modelAndView= new ModelAndView();
		try {
			List<Account> accs = accountService.allAccountInfo();
			modelAndView.addObject("accs", accs);
			modelAndView.addObject("page", "allaccinfo_success");
		} catch(Exception e) {
			e.printStackTrace();
			modelAndView.addObject("err", "전체계좌조회 오류");
			modelAndView.addObject("page", "err");
		}
		modelAndView.setViewName("template");
		return modelAndView;
	}
}
