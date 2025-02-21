package com.example.svsvdvdv.semiprojectv1.domain;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

@Data   // setter, getter, toStirng 자동 생성
@Builder    // 롬복에 있는 빌더
public class Member {

    private int mno;
    private String userid;
    private String userpwd;
    private String reuserpwd;
    private String name;
    private String email;
    private LocalDateTime regdate;

}
