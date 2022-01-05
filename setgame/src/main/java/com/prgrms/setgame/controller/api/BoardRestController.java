package com.prgrms.setgame.controller.api;

import com.prgrms.setgame.error.Message;
import com.prgrms.setgame.model.Board;
import com.prgrms.setgame.service.BoardService;
import javassist.NotFoundException;
import org.springframework.web.bind.annotation.*;

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
    public List<Board> addBoardList() throws NotFoundException {
        if (boardService.findAll().stream().count() < 15) {
            return boardService.addBoards();
        }
        throw new NotFoundException(Message.CANNOT_FIND_CARDS);
    }

    @GetMapping("/set/{card1}/{card2}/{card3}")
    public String Set(@PathVariable Long card1,
                      @PathVariable Long card2,
                      @PathVariable Long card3

    ) throws NotFoundException {
        boardService.findById(card1).orElseThrow(() -> new NotFoundException(Message.CANNOT_FIND_BOARD_ONE));
        boardService.findById(card2).orElseThrow(() -> new NotFoundException(Message.CANNOT_FIND_BOARD_TWO));
        boardService.findById(card3).orElseThrow(() -> new NotFoundException(Message.CANNOT_FIND_BOARD_THREE));

        if (boardService.isSet(card1, card2, card3)) {
            boardService.deleteById(card1, card2, card3);
            return "Found a set!";
        }

        return "Not a set!";

    }

}
