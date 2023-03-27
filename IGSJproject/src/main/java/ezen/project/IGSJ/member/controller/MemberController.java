package ezen.project.IGSJ.member.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import ezen.project.IGSJ.member.domain.MemberDTO;
import ezen.project.IGSJ.member.service.MemberService;

@CrossOrigin(origins = "http://localhost:8080")
@RestController
@RequestMapping("/member")
public class MemberController {

	private static final Logger logger = LoggerFactory.getLogger(MemberController.class);

	@Autowired
	private MemberService memberService;
	
	 @Autowired
	 private BCryptPasswordEncoder passEncoder;

	// 회원가입(POST)
	@PostMapping("/memberSignUp")
	public void signUpMember(@RequestBody MemberDTO memberDTO) throws Exception {
		
		logger.info("회원가입 Step1 memberDTO ==> {}", memberDTO.toString());
		 
		String inputPass = memberDTO.getUserPwd();
		 String pass = passEncoder.encode(inputPass);
		 memberDTO.setUserPwd(pass);

		 memberService.signUpMember(memberDTO);

		
		
		memberService.signUpMember(memberDTO);
	}
	
	//로그인 기능 구현
	@GetMapping("/member/memberLogin")
	public void memberLogin(MemberDTO memberDTO, HttpServletRequest req, RedirectAttributes reat) throws Exception {

		// memberDTO를 로그로 찍어서 앞단에서 넘어온 입력값을 확인하여 요청자의 오류부터 확인한다.
		logger.info("로그인 진행 memberLoginPage - Controller");

		String inputPass = memberDTO.getUserPwd();
		
		String pass = passEncoder.encode(inputPass);
		
		memberDTO.setUserPwd(pass);

		MemberDTO memberInfo = memberService.memberLogin(memberDTO);

		HttpSession session = req.getSession();

		// 로그인 정보가 없을 경우 공통화 시키기
		if (memberInfo == null) {
			session.setAttribute("isLogon", null);
			reat.addFlashAttribute("loginMessage", false);
			logger.info("로그인이 실패하였습니다.");

		} else {
			// DB에 로그인과 관련된 정보가 있다면?
			session.setAttribute("memberInfo", memberInfo);
		}

	}

	// 로그아웃 기능
	@GetMapping("/memberLogout")
	public String memberLogout(HttpSession session) throws Exception {

		logger.info("회원 로그아웃, 로그아웃 계정 : {}", session.getAttribute("memberInfo").toString());

		session.invalidate();

		// 성공시 앞단에서 메인페이지로 이동시켜준다.
		return "https://localhost:8080/";
	}
	 
	// 회원가입 아이디 중복 체크
	@ResponseBody
	@PostMapping("/idCheck")
	public int memberIdCheck(@RequestBody MemberDTO memberDTO) throws Exception {
	
		logger.info("회원가입 아이디 중복 체크 memberIdCheck - Controller");
		
		int result =  memberService.memberIdCheck(memberDTO);
		
		System.out.println("회원가입 중복 여부 => " + result);
		
		return result;
	}

}
