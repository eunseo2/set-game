package com.prgrms.setgame.controller.api;

import com.prgrms.setgame.model.Board;
import com.prgrms.setgame.service.BoardService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequestMapping("/api/v1/boards")
@RestController
public class BoardRestController {
    private final BoardService boardService;

    public BoardRestController(BoardService boardService) {
        this.boardService = boardService;
    }

    @GetMapping("/")
    public List<Board> boardList() {
        return boardService.boards();
    }

    @GetMapping("/add")
    public List<Board> addBoardList() {
        return boardService.addBoards();
    }

}
