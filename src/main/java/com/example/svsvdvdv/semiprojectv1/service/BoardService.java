package com.example.svsvdvdv.semiprojectv1.service;

import com.example.svsvdvdv.semiprojectv1.domain.*;

import java.util.List;

public interface BoardService {

    List<BoardDTO> readBoard(int cpg);  // 추상메서드

    int countBoard();

    List<BoardDTO> findBoard(int cpg, String findtype, String findkey);

    int countfindBoard(String findtype, String findkey);

    Board readOneBoard(int bno);

    void readOneView(int bno);

    boolean newBoard(NewBoardDTO newBoard);

    boolean newReply(NewReplyDTO newReplyDTO);

    List<Reply> readReply(int pno);

    boolean newComment(NewReplyDTO newReplyDTO);
}
