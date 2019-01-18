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
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model, String id) {
		logger.info("Welcome home! The client locale is {}.", locale);
		
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		
		String formattedDate = dateFormat.format(date);
		
		model.addAttribute("serverTime", formattedDate );
		
		System.out.println("id : " + id);
		return "home";
	}
	
	@RequestMapping(value = "/signup", method = RequestMethod.GET)
	public String signupGet(Model model, String id, String pw, String name, Boolean signup) {
		model.addAttribute("signup", signup);
		return "signup";
	}
	
	@RequestMapping(value = "/signup", method = RequestMethod.POST)
	public String signupPost(Model model, AccountVo accountVo) {
		accountService.signup(accountVo);
		return "redirect:/signup";
		
//		if(accountService.signup(accountVo)) {
//			System.out.println("회원가입 성공");
//			model.addAttribute("signup", true);
//			return "redirect:/";
//		} else {
//			System.out.println("회원가입 실패");
//			model.addAttribute("signup", false);
//			return "redirect:/signup";
//		}		

	}	
}
