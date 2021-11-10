package com.study.board.entity;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity //해당 클래스가 테이블과 매핑되는 JPA의 엔티티(Entity) 클래스임을 의미합니다
public class JPABoard {
	@Id // 엔티티의 pk 명시
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	/*PK 자동 증가를 지원하는 DB는 해당 어노테이션을 선언해야 합니다.
	오라클과 같이 시퀀스(Sequence)를 이용하는 DB는 GenerationType.SEQUENCE를 이용해야 하며,
	GenerationType.AUTO로 설정하게 되면 DB에서 제공하는 PK 생성 전략을 가져가게 된다고 합니다.
	*/
	private Long id;
	private String title;
	private String content;
	private String writer;
	private int hits;
	private char deleteYn;
	private LocalDateTime createdDate = LocalDateTime.now();
	private LocalDateTime modifiedDate;

	/*
	컬럼에 대한 setter를 무작정 생성하는 경우, 객체의 값이 어느 시점에 변경되었는지 알 수가 없습니다.
	이러한 이유로 Entity 클래스에는 절대로 Set 메서드가 존재해서는 안된답니다.
	 */
	@Builder
	//우선은 "생성자를 대신하는 놈이구나" 생각해 주시면 되겠습니다.
	public JPABoard(String title, String content, String writer, int hits, char deleteYn) {
		this.title = title;
		this.content = content;
		this.writer = writer;
		this.hits = hits;
		this.deleteYn = deleteYn;
	}
}
