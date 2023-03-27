package ezen.project.IGSJ.address.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ezen.project.IGSJ.address.domain.MemberAddressDTO;
import ezen.project.IGSJ.address.service.MemberAddressService;

@Controller
@CrossOrigin(origins = "http://localhost:8081")
@RestController
@RequestMapping("/address")
public class MemberAddressController {

	private static final Logger logger = LoggerFactory.getLogger(MemberAddressController.class);
	
	@Autowired
	private MemberAddressService memberAddressService;
	
	@PostMapping("/memberAddressSignUp")
	public void signUpAddressMember(@RequestBody MemberAddressDTO memberAddressDTO) throws Exception {
		
		logger.info("회원가입 Step1 memberDTO ==> {}", memberAddressDTO.toString());
		
		memberAddressService.signUpAddressMember(memberAddressDTO);
	}
	
	
	
}
