package com.prgrms.setgame.controller;

import com.prgrms.setgame.model.Board;
import com.prgrms.setgame.service.BoardService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Controller
public class BoardController {
    private final BoardService boardService;

    public BoardController(BoardService boardService) {
        this.boardService = boardService;
    }

    @GetMapping("/boards")
    public String boardsPage(Model model) {
        List<Board> boards = boardService.boards().stream().collect(Collectors.toList());
        Collections.shuffle(boards);

        model.addAttribute("boards", boards);
        return "main";
    }
}
