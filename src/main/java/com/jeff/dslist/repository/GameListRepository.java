package com.jeff.dslist.repository;

import com.jeff.dslist.entity.GameList;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GameListRepository extends JpaRepository<GameList, Long> {
}
