package com.cos.blog.repository;

import org.springframework.data.jpa.repository.JpaRepository;


import com.cos.blog.model.User;

// 밑의 인터페이스는 JSP로 따지면 DAO
// 스프링 레거시나 부트에서 빈으로 등록이 되는지 여부 ===> 자동으로 Bean 등록이 된다.
//따라서 @Repository // 생략이 가능하다.
public interface UserRepository extends JpaRepository<User, Integer>{
 //해당 JpaRepository는 user 테이블을 관리하는 repository와 이 User테이블의 primary 키는 integer이다
// JpaRepository는 findall()이라는 내장 함수를 가지고 있는데 이를 상속한 UserRepository  User테이블을 들고있는 모든 행을 리턴하라는 말
	
	
		
	}

