package ezen.project.IGSJ.member.controller;


import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import ezen.project.IGSJ.member.domain.MemberDTO;
import ezen.project.IGSJ.member.domain.OAuthToken;
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
	
	// 카카오API 활용한 로그인 구현
	@GetMapping("/KAKAOlogin")
	public @ResponseBody String KakaoLogin(String code) throws ParseException {
		// 1. 발급된 인가코드로 Access_Token 생성
		RestTemplate rt = new RestTemplate();
		
		HttpHeaders headers = new HttpHeaders();
		headers.add("Content-type", "application/x-www-form-urlencoded;charset=utf-8");
		
		MultiValueMap<String, String> params = new LinkedMultiValueMap<>();
		params.add("grant_type", "authorization_code");
		params.add("client_id", "XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX");
		params.add("redirect_uri", "http://localhost:8086/member/KAKAOlogin");
		params.add("code", code);
		
		HttpEntity<MultiValueMap<String, String>> kakaoTokenRequest = new HttpEntity<>(params, headers);
		ResponseEntity<String> response = rt.exchange(
			"https://kauth.kakao.com/oauth/token",
			HttpMethod.POST,
			kakaoTokenRequest,
			String.class
		);
		
		// 2. 생성된 Access_Token으로 사용자 정보 추출
		ObjectMapper objectMapper = new ObjectMapper();
		OAuthToken oauthToken = null;
		
		try {oauthToken = objectMapper.readValue(response.getBody(), OAuthToken.class);}
		catch(JsonMappingException e) {e.printStackTrace();}
		catch(JsonProcessingException e) {e.printStackTrace();}
		
		RestTemplate rt2 = new RestTemplate();
		
		HttpHeaders headers2 = new HttpHeaders();
		headers2.add("Authorization", "Bearer "+oauthToken.getAccess_token());
		headers2.add("Content-type", "application/x-www-form-urlencoded;charset=utf-8");
		
		HttpEntity<MultiValueMap<String, String>> kakaoTokenRequest2 = new HttpEntity<>(headers2);
		ResponseEntity<String> response2 = rt2.exchange(
			"https://kapi.kakao.com/v2/user/me",
			HttpMethod.POST,
			kakaoTokenRequest2,
			String.class
		);

		// 3. 추출된 사용자 정보 가공
		JSONParser parser     = new JSONParser();
		JSONObject jsonObject = (JSONObject) parser.parse(response2.getBody());
//		JSONArray  jsonArr    = (JSONArray)jsonObject.get("properties");
		
		System.out.println("userId          : "+jsonObject.get("id")); // java.lang.Long
		System.out.println("userPwd         : 없음");
		System.out.println("userName        : "+jsonObject.get("properties")); // org.json.simple.JSONObject
		System.out.println("userPhoneNumber : 없음");
		System.out.println("userEmail       : "+jsonObject.get("kakao_account")); // org.json.simple.JSONObject
		System.out.println("userJoinDate    : "+jsonObject.get("connected_at"));  // java.lang.String
		System.out.println("userVerify      : 사용자");
		System.out.println("userBirth       : 없음");

//		*** 출력 결과 ***
//		userId          : 2736576636
//		userPwd         : 없음
//		userName        : {"nickname":"이시훈"}
//		userPhoneNumber : 없음
//		userEmail       : {"email_needs_agreement":false,"profile_nickname_needs_agreement":false,"profile":{"nickname":"이시훈"},"is_email_valid":true,"is_email_verified":true,"has_email":true,"email":"hoonee26@naver.com"}
//		userJoinDate    : 2023-04-05T09:03:18Z
//		userVerify      : 사용자
//		userBirth       : 없음
		
		return response2.getBody();
		
	} // KakaoLogin()

		
} // public class MemberController
