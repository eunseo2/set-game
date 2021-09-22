package com.prgrms.setgame.model;

import javax.persistence.*;

@Entity
@Table(name = "Boards")
public class Board {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column()
    private Long id;

    @OneToOne
    @JoinColumn(name = "card_id")
    private Card card;

}
