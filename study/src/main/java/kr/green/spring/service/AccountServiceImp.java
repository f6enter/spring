package kr.green.spring.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.green.spring.dao.AccountDao;
import kr.green.spring.vo.AccountVo;

@Service
public class AccountServiceImp implements AccountService{
	@Autowired
	AccountDao accountDao;
	
	@Override
	public AccountVo getAccount(String id) {
		// TODO Auto-generated method stub
		return accountDao.getAccount(id);
	}

	@Override
	public boolean signup(AccountVo accountVo) {
		// 가입 여부 확인하여 회원 정보가 있으면(null이 아니면) 작업 중지
		if(accountDao.getAccount(accountVo.getId()) != null) {
			return false;
		}
		accountVo.setAuthority("user");
		accountDao.setAccount(accountVo);
		return true;
	}	
}
