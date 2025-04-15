package com.example.svsvdvdv.semiprojectv1.board;

import com.example.svsvdvdv.semiprojectv1.domain.Board;
import com.example.svsvdvdv.semiprojectv1.domain.BoardDTO;
import com.example.svsvdvdv.semiprojectv1.domain.BoardListDTO;
import com.example.svsvdvdv.semiprojectv1.domain.BoardReplyDTO;
import com.example.svsvdvdv.semiprojectv1.service.BoardService;
import lombok.RequiredArgsConstructor;
import org.assertj.core.api.AssertionsForClassTypes;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestConstructor;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
@Transactional
@RequiredArgsConstructor
@TestConstructor(autowireMode = TestConstructor.AutowireMode.ALL) // 생성자 주입 시 필요
public class BoardServiceTest {

    private final BoardService boardService;

    @Test
    @DisplayName("BoardService readall test")
    public void readAllTest() {
        // Given
        int cpg = 1;    // 현재 페이지가 1일 때 게시글들을 읽어옴

        // when
        // List<BoardDTO> results = boardService.readBoard(cpg);
        BoardListDTO results = boardService.readBoard(cpg);

        // Then
        assertNotNull(results);

    }

    @Test
    @DisplayName("BoardService find test")
    public void findTest() {
        // Given
        int cpg = 1;
        String findtype = "userid";
        String findkey = "123";

        // when
        BoardListDTO results = boardService.findBoard(cpg, findtype, findkey);

        // Then
        assertNotNull(results);
    }

    @Test
    @DisplayName("BoardService countfind test")
    public void countfindTest() {
        // Given
        int cpg = 1;
        String findtype = "title";
        String findkey = "SDT";

        // when
        //int results = boardService.countfindBoard(findtype, findkey);

        // Then
        //assertThat(results).isGreaterThan(0);

    }

    @Test
    @DisplayName("BoardService readOne test")
    public void readOneTest() {
        // Given
        int bno = 3006;

        // when
        //Board result = boardService.readOneBoard(bno);
        BoardReplyDTO result = boardService.readOneBoardReply(bno);

        // Then
        assertThat(result).isNotNull();
        assertThat(result.getBd().getUserid()).isNotNull();

    }
}
