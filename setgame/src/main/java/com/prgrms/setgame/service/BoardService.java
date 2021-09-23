package com.prgrms.setgame.service;

import com.prgrms.setgame.model.Board;

import java.util.List;
import java.util.Optional;

public interface BoardService {
    List<Board> boards();

    List<Board> addBoards();

    List<Board> findAll();

    Optional<Board> findById(Long id);

    void deleteById(Long id1, Long id2, Long id3);

    Boolean isSet(Long id1, Long id2, Long id3);
}
