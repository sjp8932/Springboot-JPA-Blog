package com.cos.blog.model;

import java.sql.Timestamp;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.CreationTimestamp;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity //Entitiy 어노테이션은 클래스와 가까이 있는게 좋다.
public class Board {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) // auto_increment를 사용하겠다.
	private int id;
	
	@Column(nullable = false, length=100)
	private String title;

	@Lob // 대용량 데이터
	private String content; //써머노트 라이브러리를 쓸 것인데 <HTML> 태그가 섞여서 디자인 됨.  그러다 보니 내용이 많아지고 용량이 많아짐 // @Lob 은 대용량 데이터를 쓸때 쓴다.

	@ColumnDefault("0") // int 값이기 때문에 홋따옴표 필요 없다.
	private int count;
	
	@ManyToOne(fetch = FetchType.EAGER) // Many는 Board , User는 one 향상 앞에 있는게 클래스로 기준이 됌  ==> 한명의 유저는 여러개의 게시글을 쓸 수 있다는 뜻. one to one은 한명의 유저는 하나의 게시글만 쓸 수 있다.
	@JoinColumn(name="userId")
	private  User user; // DB는 오브젝트를 저장할 수 없다. 그래서 일반적으로 데이터 베이스는 FK를 사용하는데, 하지만 자바는 오브젝트를 저장할 수 있다.그럼 fk를 사용하지 않아도 된다. 
	
	@OneToMany(mappedBy="board" , fetch=FetchType.EAGER) // mappedBy를 쓰는 이유? --> mappedBy가 적혀있으면 reply가 연관관계의 주인이 아니다.( == 난 fk가 아니에요. 그러니 DB에 칼럼을 만들지 마세요)
	private List<Reply> reply;
	
	@CreationTimestamp //데이터가 insert 또는 업데이트 될 때 현재시간이 자동으로 들어간다.
	private Timestamp createDate;
} 
