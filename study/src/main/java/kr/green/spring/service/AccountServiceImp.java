package kr.green.spring.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import kr.green.spring.dao.AccountDao;
import kr.green.spring.vo.AccountVo;

@Service
public class AccountServiceImp implements AccountService{
	@Autowired
	AccountDao accountDao;
	
	@Autowired // 비밀번호 암호화
	BCryptPasswordEncoder passwordEncoder;
	
	@Override
	public AccountVo getAccount(String id) {
		// TODO Auto-generated method stub
		return accountDao.getAccount(id);
	}

	@Override
	public boolean signup(AccountVo accountVo) {
		// 가입 여부 확인하여 회원 정보가 있으면(null이 아니면) 작업 중지
		String id = accountVo.getId();
		AccountVo tmp = accountDao.getAccount(id);
		if(tmp == null) {
			String encPw = passwordEncoder.encode(accountVo.getPw());
			accountVo.setPw(encPw);
			accountVo.setAuthority("user");
			accountDao.setAccount(accountVo);
			return true;
		} else
		return false;
	}

	@Override
	public AccountVo signin(String id, String pw) {
		AccountVo user = accountDao.getAccount(id);
		if(user != null && passwordEncoder.matches(pw, user.getPw()))
			return user;
		return null;
	}

}
