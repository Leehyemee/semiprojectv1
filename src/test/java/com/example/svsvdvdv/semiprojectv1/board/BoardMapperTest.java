package com.example.svsvdvdv.semiprojectv1.board;

import com.example.svsvdvdv.semiprojectv1.domain.BoardDTO;
import com.example.svsvdvdv.semiprojectv1.repository.BoardRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mybatis.spring.boot.test.autoconfigure.MybatisTest;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.test.context.TestConstructor;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@Slf4j
@MybatisTest
@RequiredArgsConstructor    // final 필드변수로 생성자 생성
@TestConstructor(autowireMode = TestConstructor.AutowireMode.ALL) // 생성자 주입 시 필요
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE) // H2 데이터베이스 사용중지
public class BoardMapperTest {

    // autowired가 아닌 생성자를 이용한 의존성 주입 사용
    private final BoardRepository boardMapper;
    @Value("${board.page-size}") private int pageSize;

    @Test
    @DisplayName("BoardrMapper select test")
    void selectTest() {
        // Given : 테스트에 사용할 데이터 제공
        int stnum = 0; // 조회할 게시물 시작 위치

        // When : 데이터로 테스트할 기능 호출
        List<BoardDTO> results = boardMapper.selectBoard(stnum, pageSize);

        // Then : 호출되고 난 후 결과값 확인
        log.info("result : {}", results);
        assertNotNull(results);

    }

    @Test
    @DisplayName("BoardrMapper find test")
    void findTest() {
        // Given : 테스트에 사용할 데이터 제공
        Map<String, Object> params = new HashMap();
        params.put("stnum", 0);
        params.put("pageSize", 35);
        params.put("findtype", "title");
        params.put("findkey", "올해");

        // When : 데이터로 테스트할 기능 호출
        // List<BoardDTO> results = boardMapper.selectFindBoard(
        //        0, 35, "title", "웹툰");

        // List<BoardDTO> results = boardMapper.selectFindBoard(
        //       0, 35, "userid", "abc");

        // List<BoardDTO> results = boardMapper.selectFindBoard(
        //        0, 35, "contents", "네이버");

        // HashMap 형태로 검색관련 데이터 넘김
        List<BoardDTO> results = boardMapper.selectFindBoard(params);

        // Then : 호출되고 난 후 결과값 확인
        log.info("result : {}", results);
        assertNotNull(results); // 널 여부 확인 - 리스트일 경우 의미 없는 검사!
        assertThat(results).isNotEmpty(); // 비어있는지 여부 확인
        assertThat(results.size()).isGreaterThan(1); // 결과 갯수 확인

    }
}

