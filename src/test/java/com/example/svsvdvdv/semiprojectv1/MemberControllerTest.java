package com.example.svsvdvdv.semiprojectv1;

import com.example.svsvdvdv.semiprojectv1.domain.Member;
import com.example.svsvdvdv.semiprojectv1.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestConstructor;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.transaction.annotation.Transactional;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.redirectedUrl;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
@Transactional
@RequiredArgsConstructor
@TestConstructor(autowireMode = TestConstructor.AutowireMode.ALL) // 생성자 주입 시 필요
public class MemberControllerTest {

    private final MockMvc mockMvc;
    private final MemberRepository memeberMapper;

    @Test
    @DisplayName("/join POST request test")
    public void login() throws Exception {
        // Given
        String userid = "abc1232";
        String userpwd = "abc1232";
        String name = "abc1232";
        String email = "abc123@gmail.com";

        // When
        mockMvc.perform(post("/member/join")
                .param("userid", userid)
                .param("userpwd", userpwd)
                .param("name", name)
                .param("email", email))
            .andExpect(status().is3xxRedirection())
            .andExpect(redirectedUrl("/member/login"));

        // Then
    //    Member member = memberMapper.findByUserid(userid);
    //    assertThat(member).isNull();
    //    assertThat(member.getMno()).isNull();
    //    assertThat(member.getRegdate()).isNull();
    //    assertThat(member.getName()).isEqualTo("abc123");
    //    assertThat(member.getEmail()).isEqualTo("abc123@gmail.com");

    }

}
