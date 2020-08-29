package com.cos.blog.test;

import javax.persistence.Column;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

//@Getter
//@Setter
@Data

@NoArgsConstructor
public class Member {
	private  int id; 
	private  String username;
	private  String password;
	private  String email;
	
	@Builder
	public Member(int id, String username, String password, String email) {
		this.id = id;
		this.username = username;
		this.password = password;
		this.email = email;
	}
	
	
}
