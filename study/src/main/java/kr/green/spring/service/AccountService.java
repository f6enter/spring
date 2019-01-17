package kr.green.spring.service;

import kr.green.spring.vo.AccountVo;

// 컨트롤러에서 전달받은 매개변수(인자,파라미터)를 가공하거나 DB에 있는 정보를 가져와서 가공.
public interface AccountService {
	public AccountVo getAccount(String id);

	public boolean signup(AccountVo accountVo);
	
}
