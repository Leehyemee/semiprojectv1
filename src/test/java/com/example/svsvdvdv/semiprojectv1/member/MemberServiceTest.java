package com.example.svsvdvdv.semiprojectv1.member;

import com.example.svsvdvdv.semiprojectv1.domain.MemberDTO;
import com.example.svsvdvdv.semiprojectv1.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestConstructor;
import org.springframework.transaction.annotation.Transactional;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
@Transactional
@RequiredArgsConstructor
@TestConstructor(autowireMode = TestConstructor.AutowireMode.ALL) // 생성자 주입 시 필요
public class MemberServiceTest {

    private final MemberService memberService;

    @Test
    @DisplayName("MemberService newMember test")
    public void newMemberTest() {
        // Given
        MemberDTO dto = MemberDTO.builder()
            .userid("abc1234")
            .userpwd("987xyz")
            .name("abc123")
            .email("abc123@gmail.com")
            .build();

        // when
        boolean result = memberService.newMember(dto);

        // Then
        assertTrue(result);

    }
}
