package com.example.svsvdvdv.semiprojectv1.controller;

import com.example.svsvdvdv.semiprojectv1.domain.NewBoardDTO;
import com.example.svsvdvdv.semiprojectv1.domain.NewReplyDTO;
import com.example.svsvdvdv.semiprojectv1.service.BoardService;
import com.example.svsvdvdv.semiprojectv1.service.GoogleRecaptchaService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@Slf4j
@Controller
@RequestMapping("/board")
@RequiredArgsConstructor
public class BoardController {

    private final BoardService boardService;
    private final GoogleRecaptchaService googleRecaptchaService;

    @GetMapping("/list")
    public String list(HttpServletResponse response) {
        // 클라이언트 캐시 케어
        response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate");
        response.setHeader("Pragma", "no-cache");
        response.setHeader("Expires", "0");

        log.info("board/list 호출!!");

        return "views/board/list";

    }
    @GetMapping("/find")
    public String find(Model m, String findtype, String findkey,
                       @RequestParam(defaultValue = "1") int cpg) {

        m.addAttribute("bds", boardService.findBoard(cpg,findtype,findkey));
        m.addAttribute("cpg", cpg);
        m.addAttribute("stblk", ((cpg - 1) / 10) * 10 + 1);
        m.addAttribute("cntpg", boardService.countfindBoard(findtype, findkey));

        return "views/board/list";
    }

    @GetMapping("/view")
    public String view(Model m, int bno) {

        m.addAttribute("bdrps", boardService.readOneBoardReply(bno));
//        boardService.readOneView(bno);
//        m.addAttribute("bd", boardService.readOneBoard(bno));
//        m.addAttribute("rps", boardService.readReply(bno));

        return "views/board/view";
    }

    @GetMapping("/write")
    public String write(Model m, Authentication authentication) {
        String returnPage = "redirect:/member/login";

        if (authentication!= null && authentication.isAuthenticated()) {
            // 시스템 환경변수에 저장된 사이트키 불러옴
            m.addAttribute("sitekey", System.getenv("recaptcha.sitekey"));
            returnPage = "views/board/write";
        }

        return returnPage;
    }

    @PostMapping("/write")
    public ResponseEntity<?> writeOk(NewBoardDTO newBoardDTO,
                                     @RequestParam("g-recaptcha-response") String gRecaptchaResponse) {
        ResponseEntity<?> response = ResponseEntity.internalServerError().build();
        log.info("submit된 게시글 정보 : {}", newBoardDTO);
        log.info("submit된 recaptcha 응답코드 : {}", gRecaptchaResponse);

        try {
            if (!googleRecaptchaService.verifyRecaptcha(gRecaptchaResponse)) {
                throw new IllegalStateException("자동가입방지 코드 오류!!");
            }

            if (boardService.newBoard(newBoardDTO)) {
                response = ResponseEntity.ok().build();
            }
        } catch (IllegalStateException ex) {
            response = ResponseEntity.badRequest().body(ex.getMessage());
        }

        return response;
    }

    @PostMapping("/reply")
    public String repleok(NewReplyDTO newReplyDTO) {
        String retrunPage = "redirect:/board/view?bno=" + newReplyDTO.getPno();

        if (!boardService.newReply(newReplyDTO)) {
            retrunPage = "redirect:/board/error?type=1";
        }

        return retrunPage;
    }

    @PostMapping("/cmmt")
    public String cmmtok(NewReplyDTO newReplyDTO) {
        String retrunPage = "redirect:/board/view?bno=" + newReplyDTO.getPno();

        if (!boardService.newComment(newReplyDTO)) {
            retrunPage = "redirect:/board/error?type=1";
        }

        return retrunPage;
    }

}
