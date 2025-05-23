package com.example.svsvdvdv.semiprojectv1.domain;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Builder
public class GalleryListDTO {
    private int gno;
    private String title;
    private String userid;
    private LocalDateTime regdate;
    private String thumbs;
    private String views;
    private String simgname;
}
