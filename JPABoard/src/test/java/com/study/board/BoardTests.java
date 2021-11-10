package com.study.board;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.test.context.SpringBootTest;

import com.study.board.entity.BoardRepository;
import com.study.board.entity.JPABoard;

@SpringBootTest
public class BoardTests {

	@Autowired
	BoardRepository boardRepository;

	@Test
	void save() {

		// 1. 게시글 파라미터 생성
		JPABoard params = JPABoard.builder()
						.title("1번 게시글 제목")
						.content("1번 게시글 내용")
						.writer("짱구")
						.hits(0)
						.deleteYn('N')
						.build();

		// 2. 게시글 저장
		boardRepository.save(params);

		// 3. 1번 게시글 정보 조회
		JPABoard entity = boardRepository.findById((long) 1).get();
		assertThat(entity.getTitle()).isEqualTo("1번 게시글 제목");
		assertThat(entity.getContent()).isEqualTo("1번 게시글 내용");
		assertThat(entity.getWriter()).isEqualTo("짱구");
	}

	@Test
	void findAll() {
		// 1. 전체 게시글 수 조회
		long boardCount = boardRepository.count();

		// 2. 전체 게시글 리스트 조회
		List<JPABoard> boards = boardRepository.findAll();
	}

	@Test
	void delete() {
		// 1. 게시글 조회
		JPABoard enity = boardRepository.findById((long) 1).get();

		// 2. 게시글 삭제
		boardRepository.delete(enity);
	}

}
