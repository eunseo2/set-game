package com.prgrms.setgame.repository;

import com.prgrms.setgame.model.Card;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface CardRepository extends JpaRepository<Card, Long> {

    @Query(value = "SELECT * FROM cards ORDER BY RAND() LIMIT 12", nativeQuery = true)
    List<Card> cards();

}
