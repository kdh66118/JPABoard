package com.study.board.entity;

import org.springframework.data.jpa.repository.JpaRepository;

/*
	MyBatis의 Mapper를 JPA에서는 Repository로 부른다고 이해해 주시면 되겠습니다.
	참고로 엔티티(Entity) 클래스와 레파지토리(Repository) 인터페이스는 꼭! 같은 패키지에 위치해야 합니다.

	JpaRepository<T, ID>
	엔티티 클래스의 타입(Board)과 PK에 해당하는 데이터 타입(Long)을 선언하면
	해당 엔티티 클래스와 매핑되는 테이블인 board 테이블의 CRUD 기능을 사용할 수 있습니다.
 */
public interface BoardRepository extends JpaRepository<JPABoard, Long>{

}
