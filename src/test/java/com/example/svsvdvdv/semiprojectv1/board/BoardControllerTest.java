package com.example.svsvdvdv.semiprojectv1.board;

import com.example.svsvdvdv.semiprojectv1.repository.BoardRepository;
import lombok.RequiredArgsConstructor;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestConstructor;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.servlet.View;

import static org.hamcrest.Matchers.greaterThan;
import static org.hamcrest.Matchers.hasSize;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
@Transactional
@RequiredArgsConstructor
@TestConstructor(autowireMode = TestConstructor.AutowireMode.ALL) // 생성자 주입 시 필요
public class BoardControllerTest {

    private final MockMvc mockMvc;
    private final BoardRepository boardMapper;
    @Autowired
    private View view;

    @Test
    @DisplayName("/list GET request test")
    public void list() throws Exception {
        // Given
        String cpg = "1"; // 출력할 페이지 지정

        // When
        mockMvc.perform(get("/board/list")
                .param("cpg", cpg))
            .andExpect(status().isOk())
            .andDo(print());

    }

    @Test
    @DisplayName("/find GET request test")
    public void find() throws Exception {
        // Given
        String cpg = "1";
        String findtype = "title";
        String findkey = "올해";

        // When
        mockMvc.perform(get("/board/find")
                        .param("cpg", cpg)
                        .param("findtype", findtype)
                        .param("findkey", findkey))
                .andExpect(status().isOk())
                .andExpect(view().name("views/board/list"))
                .andExpect(model().attributeExists("bds"))
                .andExpect(model().attribute("bds", hasSize(greaterThan(0))))   // 객체 내 요소의 갯수 비교
                .andExpect(model().attributeExists("cntpg"))
                .andExpect(model().attribute("cntpg", greaterThan(0)));     // 변수의 값 비교


    }

}
