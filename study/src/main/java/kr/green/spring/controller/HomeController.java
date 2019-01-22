package kr.green.spring.controller;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import kr.green.spring.service.AccountService;
import kr.green.spring.vo.AccountVo;

/**
 * Handles requests for the application home page.
 */

@Controller
public class HomeController {
	@Autowired
	AccountService accountService;

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String homeGet(Model model, Boolean signup) {
		model.addAttribute("signup", signup);
		return "home";
	}
	
	@RequestMapping(value = "/", method = RequestMethod.POST)
	public String homePost(String id, String pw, Model model) {
	
		AccountVo user = accountService.signin(id, pw);
		if(user != null) {
			model.addAttribute("user", user); // 인터셉터부분
			return "redirect:/bbs/list";
		}	
		else {
			return "redirect:/";
		}	
	}
	
	@RequestMapping(value = "/signup", method = RequestMethod.GET)
	public String signupGet(Model model, Boolean signup) {
		model.addAttribute("signup", signup);
		return "signup";
	}
	
	@RequestMapping(value = "/signup", method = RequestMethod.POST)
	public String signupPost(AccountVo accountVo, Model model) {
		
		if(accountService.signup(accountVo)) {
			System.out.println("회원가입 성공");
			model.addAttribute("signup", true);
			return "redirect:/";
		} else {
			System.out.println("회원가입 실패");
			model.addAttribute("signup", false);
			return "redirect:/signup";
		}		
	}
	
}
