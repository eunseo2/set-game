package com.prgrms.setgame.controller;

import com.prgrms.setgame.error.Message;
import com.prgrms.setgame.model.Board;
import com.prgrms.setgame.service.BoardService;
import javassist.NotFoundException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Controller
public class BoardController {
    private final BoardService boardService;

    public BoardController(BoardService boardService) {
        this.boardService = boardService;
    }

    @GetMapping("/game")
    public String boardsMainPage(Model model) {
        List<Board> boards = boardService.boards().stream().collect(Collectors.toList());
        Collections.shuffle(boards);

        model.addAttribute("boards", boards);
        return "main";
    }

    @GetMapping("/boards")
    public String boardsPage(Model model) {
        List<Board> boards = boardService.findAll().stream().collect(Collectors.toList());
        Collections.shuffle(boards);

        model.addAttribute("boards", boards);
        return "main";
    }

    @GetMapping("/boards/add")
    public String boardsNewPage(Model model) throws NotFoundException {
        List<Board> boards = new ArrayList<>();

        if (boardService.findAll().stream().count() < 15) {
            boards = boardService.addBoards().stream().collect(Collectors.toList());
            Collections.shuffle(boards);
            model.addAttribute("boards", boards);
            return "main";
        }

        model.addAttribute("message", Message.CANNOT_FIND_CARDS);
        return "message";
    }
}
