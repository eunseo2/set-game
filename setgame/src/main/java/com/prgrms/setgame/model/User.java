package com.prgrms.setgame.model;

import org.springframework.data.annotation.CreatedDate;

import javax.persistence.*;
import java.util.Date;
import java.util.UUID;

@Entity
@Table(name = "Users")
public class User {
    @Id
    @Column()
    private UUID id;

    @Column(columnDefinition = "integer default 0")
    private Integer score;

    @CreatedDate
    @Column(name = "created_at")
    private Date createdAt;
}
