package com.example.svsvdvdv.semiprojectv1.service;

import com.example.svsvdvdv.semiprojectv1.domain.BoardDTO;

import java.util.List;

public interface BoardService {

    List<BoardDTO> readBoard(int cpg);  // 추상메서드

}
