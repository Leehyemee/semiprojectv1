package com.example.svsvdvdv.semiprojectv1.domain;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

@Data   // setter, getter, toStirng 자동 생성
@Builder    // 롬복에 있는 빌더
public class Member {       // 테이블과 1:1 대응

    private int mno;
    private String userid;
    private String userpwd;
    private String name;
    private String email;
    private LocalDateTime regdate;

}
