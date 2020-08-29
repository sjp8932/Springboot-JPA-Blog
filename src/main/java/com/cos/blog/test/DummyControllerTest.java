package com.cos.blog.test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cos.blog.model.RoleType;
import com.cos.blog.model.User;
import com.cos.blog.repository.UserRepository;


@RestController
public class DummyControllerTest {
	
	// @RestController어노테이션이 붙은 클래스가 메모리에 뜰때 @Autowired 어노테이션이 붙은 것들도 같이 메모리에 뜬다 의존성 주입(DI)
	// 즉, Autowired는 UserRepository 타입으로 스프링이 관리하고 있는 객체가 있다면 userRepository 에 넣으라는 소리
	
	@Autowired // 의존성 주입(DI)
	private UserRepository userRepository;
	
	//{id} 주소로 파라미터를 전달 받을 수 있습니다.
	//http://localhost:8000/blog/dummy/user/3
	@GetMapping("/dummy/user/{id}")
	public User detail(@PathVariable int id){
		// user의 4번을 찾으면 내가 데이터베이스에서 못찾아오게 되면  user가 null이 될 것 아닌가..
		// 그럼 리턴할 때 null이 되자나.. 그럼 프로그램에 문제가 있지 않겠니?
		// Optional로 너의 User 객체를 감싸서 가져올테니 null인지 아닌지 판단해서 return 해~!
		userRepository.findByid(id).get(id).orElseGet(other);
		return user;
	}
	
	
	//http://localhost:8000/blog/dummy/join(요청) 
	//httP의 body에 username,password,email 데이터를 가지고 (요청)
	//1번 방법~! 오브젝트로 받아버리기
	@PostMapping("/dummy/join")
	public String join(User user) {
		System.out.println("id: "+user.getId());
		System.out.println("username: "+user.getUsername());
	    System.out.println("password: "+user.getPassword());
	    System.out.println("email: "+user.getEmail());
	    System.out.println("role: " +user.getRole());
	    System.out.println("createDate: "+user.getCreateDate());
	    
	    
	    user.setRole(RoleType.USER);
	    userRepository.save(user);
	    return "회원가입이 완료되었습니다.";
	}
	
	/*
	 * 2번 방법
	 * @PostMapping("/dummy/join")
		public String join(String username, String password, String email) {//key=value(약속된 규칙)
	    System.out.println("username: "+username);
	    System.out.println("password: "+password);
	    System.out.println("email: "+email);
		return "회원가입이 완료되었습니다.";
		}
	*/
}
