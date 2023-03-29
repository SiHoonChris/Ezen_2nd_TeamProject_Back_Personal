package ezen.project.IGSJ.member.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import ezen.project.IGSJ.member.domain.MemberDTO;
import ezen.project.IGSJ.member.service.MemberService;

@Controller("MemberController")
@CrossOrigin(origins = "http://localhost:8080")
@RequestMapping("/member")
public class MemberController {
	@Autowired
	private MemberService memberService;

	//로그인 기능 구현
	@PostMapping("/memberLogin")
	@ResponseBody
	public MemberDTO memberLogin(@RequestBody MemberDTO memberDTO) throws Exception {
		return memberService.memberLogin(memberDTO);
	} // memberLogin()
	
	
} // public class MemberController
