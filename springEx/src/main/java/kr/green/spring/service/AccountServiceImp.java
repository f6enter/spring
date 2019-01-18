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
		return accountDao.getAccount(id);
	}

	@Override
	public boolean signup(AccountVo accountVo) {
		String id = accountVo.getId();
		AccountVo tmp = accountDao.getAccount(id);
		System.out.println(accountVo);
		if(tmp == null) {
			accountDao.setAccount(accountVo);
			return true;
		} else
		return false;

	}

	

}
