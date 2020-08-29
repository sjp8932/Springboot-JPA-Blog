package com.cos.blog.test;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HttpControllerTest {
   
	private static final String TAG = "HttpControllerTest:";
	
	@GetMapping("/http/lombok")
	public String lombokTest() {
		Member m = Member.builder().username("sjp8932").password("sjp8932").email("sjp8932@gmail.com").build();
		System.out.println(TAG+"getter"+m.getId());
		m.setId(5000);
		System.out.println(TAG+"Setter"+m.getId());
		return "lombok test 완료";
	}
	
	@GetMapping("/http/get")
	public String getTest(Member m) {
		return "get요청: " +m.getId()+","+m.getUsername()+","+m.getPassword()+","+m.getEmail();
	}
	@PostMapping("/http/post")
	public String postTest(@RequestBody Member m) {
		return "post요청 "+m.getId()+","+m.getUsername()+","+m.getPassword()+","+m.getEmail();
	}
	@PutMapping("/http/put")
	public String putTest(@RequestBody Member m) {
		return "put요청 "+m.getId()+","+m.getUsername()+","+m.getPassword()+","+m.getEmail();
	}
	@GetMapping("/http/delete")
	public String deleteTest(Member m) {
		return "delete요청 "+m.getId()+","+m.getUsername()+","+m.getPassword()+","+m.getEmail();
	}
}
