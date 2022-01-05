package com.prgrms.setgame.service;

import com.prgrms.setgame.model.Board;
import com.prgrms.setgame.model.Card;
import com.prgrms.setgame.repository.BoardRepository;
import com.prgrms.setgame.repository.CardRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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

    @Override
    public List<Board> findAll() {
        return boardRepository.findAll();
    }

    @Override
    public Optional<Board> findById(Long id) {
        return boardRepository.findById(id);
    }

    @Override
    public void deleteById(Long id1, Long id2, Long id3) {
        boardRepository.deleteById(id1);
        boardRepository.deleteById(id2);
        boardRepository.deleteById(id3);
    }

    @Override
    public Boolean isSet(Long id1, Long id2, Long id3) {
        var card1 = boardRepository.findById(id1).get().getCard();
        var card2 = boardRepository.findById(id2).get().getCard();
        var card3 = boardRepository.findById(id3).get().getCard();
        return check(card1.getColor(), card2.getColor(), card3.getColor()) &&
                check(card1.getShade(), card2.getShade(), card3.getShade()) &&
                check(card1.getShape(), card2.getShape(), card3.getShape()) &&
                check(card1.getNumber(), card2.getNumber(), card3.getNumber());
    }

    private Boolean check(String c1, String c2, String c3) {
        if (c1.equals(c2) && c2.equals(c3) && c1.equals(c3)) {
            return true;
        }
        if (!c1.equals(c2) && !c2.equals(c3) && !c1.equals(c3)) {
            return true;
        }
        return false;
    }

}
