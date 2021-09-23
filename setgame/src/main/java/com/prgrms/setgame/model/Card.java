package com.prgrms.setgame.model;

import lombok.Getter;

import javax.persistence.*;

@Entity
@Table(name = "Cards")
@Getter
public class Card {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column()
    private Long id;

    @Column
    private String color;

    @Column
    private String shape;

    @Column
    private Long number;

    @Column
    private String shade;

    @Column(columnDefinition = "TEXT")
    private String image;

    @Column(name = "is_used", columnDefinition = "boolean default false")
    private Boolean isUsed;
}