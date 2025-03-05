package com.example.svsvdvdv.semiprojectv1.domain;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Reply {
    private String rno;
    private String comments;
    private String userid;
    private String regdate;
    private String ref;
    private String pno;
}
