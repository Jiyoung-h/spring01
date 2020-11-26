package com.example.spring01.model.admin;

import com.example.spring01.model.dto.MemberDTO;

public interface AdminDAO {
	public String loginCheck(MemberDTO dto);
}
