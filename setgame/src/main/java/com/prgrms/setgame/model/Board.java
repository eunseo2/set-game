package com.prgrms.setgame.model;

import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@NoArgsConstructor
@Getter
@Table(name = "Boards")
public class Board {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column()
    private Long id;

    @OneToOne
    @JoinColumn(name = "card_id")
    private Card card;

    public Board(Card card) {
        this.card = card;
    }

}
