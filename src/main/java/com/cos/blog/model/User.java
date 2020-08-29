package com.cos.blog.model;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.DynamicInsert;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

// ORM -> JAVA 또는 다른언어의 Object를 테이블로 매핑해주는 기술
// 클래스를 테이블화 하기  위해 Entitiy 어노테이션을 붙이면, User 클래스가 필드들을 읽어서



@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder // 빌더패턴
@Entity //User 클래스가 mysql에 테이블이 생성된다.
//@DynamicInsert ==>Insert시에 Null인 필드를 제외시켜준다.
@DynamicInsert
public class User {
	  
	@Id //Primary key임을 알려주는 어노테이션
	@GeneratedValue(strategy = GenerationType.IDENTITY) // 해당 프로젝트에서 연결된 DB의 넘버링 전략을 따라간다.
	private int id; // 오라클은 시퀀스, mysql은 auto_increment
	
	@Column(nullable = false , length = 30)
	private String username;
	
	@Column(nullable = false , length = 100) // 100자이상 주는 이유는 . 패스워드를 해쉬로 변경해서 비밀번호를 암호화 할 것이기 때문임
	private String password;
	
	@Column(nullable = false, length = 50)
	private String email;

	// application.yml에 주석을 못 달기에 여기에 적는다.
	/*
	 * jpa: open- in-view:true hibernate: ddl-auto:create ==> 기존에 테이블이 있으면 다 지우고 새로
	 * 만들기 naming: physical-strategy:
	 * org.hibernate.boot.model.naming.PhysicalNamingStrategyStandardImp ==> 엔티티를 만들
	 * 때(테이블을 만들때) 변수명 그대로 테이블에 넣어준다는 뜻 use-new-id-generator-mappings: false ==>jpa의
	 * 기본 전략을 따라가지 않겠다. show-sql: true => 콘솔창에 작성된 sql문을 보여준다 properties:
	 * hibernate.format_sql:true ==> 일렬로 콘솔창에 찍히는 sql문을 한줄한줄 나눠서 출력한다.
	 */
	
	//org.hibernate.boot.model.naming.PhysicalNamingStrategyStandardImpl  ==> 위에 적어둠
	//org.springframeword.boot.orm.jpa.hibernate.SpringPhysicalNamingStrategy ==> Camel 표기법인 MyEmail 을 my_email로 바꾸어 버린다.
	
	/*
	@ColumnDefault("'user'") // 쌍 따옴표 안에 반드시 홋 따옴표 입력해줘야 한다.*/	
	//DB는 RoleType이라는 게  없다.
	
	
	//private RoleType role; // Enum을 쓰는게 좋다. // 회원의 권한을 admin, manager, user 이런식으로 하기 때문에
	@Enumerated(EnumType.STRING)
	private RoleType role; 
	
	@CreationTimestamp // 시간이 자동으로 입력
	private Timestamp createDate;
}
