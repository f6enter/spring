package kr.green.spring.dao;

import org.apache.ibatis.annotations.Param;

import kr.green.spring.vo.AccountVo;

// DB에 접근하기 위한 인터페이스
public interface AccountDao {
	public AccountVo getAccount(String id);

	public void setAccount(@Param("accountVo")AccountVo accountVo);
}
