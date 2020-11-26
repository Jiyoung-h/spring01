package com.example.spring01.model.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.example.spring01.model.dto.MemberDTO;


@Repository
public class MemberDAOImpl implements MemberDAO {

	@Inject
	SqlSession sqlSession;
	
	@Override
	public List<MemberDTO> list() {
		return sqlSession.selectList("member.list");
	}

	@Override
	public void insert(MemberDTO dto) {
		sqlSession.insert("member.insert", dto);
	}

	@Override
	public MemberDTO detail(String userid) {
		return sqlSession.selectOne("member.detail", userid);
	}	// selectOne() 레코드가 1개 selectList() 2개 이상

	@Override
	public void delete(String userid) {
		sqlSession.delete("member.delete", userid);
	}

	@Override
	public void update(MemberDTO dto) {
		sqlSession.update("member.update", dto);
	}

	@Override
	public boolean check_passwd(String userid, String passwd) {
		boolean result = false;
		Map<String, String> map = new HashMap<>();
		map.put("userid", userid);
		map.put("passwd", passwd);
		int count = sqlSession.selectOne("member.check_passwd", map); 
		//selectOne은 하나밖에 전달하지 못하기 때문에 map으로 묶어서 전달
		if(count == 1)
			result = true;
		return result;
	}
	
	@Override
	public String loginCheck(MemberDTO dto) {
		return sqlSession.selectOne("member.login_check", dto);
	}
}
