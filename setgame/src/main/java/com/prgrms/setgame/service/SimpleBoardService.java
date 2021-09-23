package com.prgrms.setgame.service;

import com.prgrms.setgame.model.Board;
import com.prgrms.setgame.model.Card;
import com.prgrms.setgame.repository.BoardRepository;
import com.prgrms.setgame.repository.CardRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SimpleBoardService implements BoardService {
    private final BoardRepository boardRepository;
    private final CardRepository cardRepository;

    public SimpleBoardService(BoardRepository boardRepository, CardRepository cardRepository) {
        this.boardRepository = boardRepository;
        this.cardRepository = cardRepository;
    }

    @Override
    public List<Board> boards() {
        //게임 초기 설정
        cardRepository.findByIsUsed().forEach(card -> {
            card.setIsUsed(Boolean.FALSE);
            cardRepository.save(card);
        });
        boardRepository.deleteAll();

        //게임 시작
        cardRepository.cards().forEach(card -> {
            boardRepository.save(new Board(card));
            card.setIsUsed(Boolean.TRUE);
            cardRepository.save(card);
        });
        return boardRepository.findAll();
    }

    @Override
    public List<Board> addBoards() {
        cardRepository.addCards().forEach(card -> {
            boardRepository.save(new Board(card));
            card.setIsUsed(Boolean.TRUE);
            cardRepository.save(card);
        });

        return boardRepository.findAll();
    }

}
