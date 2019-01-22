package kr.green.spring.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import kr.green.spring.service.AccountService;
import kr.green.spring.service.BoardService;
import kr.green.spring.vo.BoardVo;

@Controller
@RequestMapping(value="/bbs")
public class BoardController {
	@Autowired
	BoardService boardService;
	
	@RequestMapping(value="/list")
	public String list(Model model) {
		List<BoardVo> boardList = boardService.getBoards();
		model.addAttribute("list", boardList); // jsp안에서 하나씩 꺼내올 수 있도록.
		for(BoardVo tmp : boardList) {
			System.out.println(tmp);
		}
		//System.out.println(boardList);
		return "bbs/list";
	}
	
	@RequestMapping(value="/register", method = RequestMethod.GET)
	public String registerGet(BoardVo board) {
		return "bbs/register"; //jsp를 입력
	}
	
	@RequestMapping(value="/register", method = RequestMethod.POST)
	public String registerPost(BoardVo board, Model model) {
		//System.out.println(board);
		boardService.register(board);
		return "redirect:/bbs/list"; //uri를 입력
	}
}
