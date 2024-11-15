package com.jeff.dslist.service;

import com.jeff.dslist.dto.GameDTO;
import com.jeff.dslist.dto.GameMinDTO;
import com.jeff.dslist.entity.Game;
import com.jeff.dslist.projection.GameMinProjection;
import com.jeff.dslist.repository.GameRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class GameService {

    @Autowired
    private GameRepository gameRepository;

    @Transactional(readOnly = true)
    public List<GameMinDTO> findAll() {
        List<Game> result = gameRepository.findAll();
        return result.stream().map(GameMinDTO::new).toList();
    }

    @Transactional(readOnly = true)
    public GameDTO findById(Long id) {
        Game result = gameRepository.findById(id).orElse(null);
        return new GameDTO(result);
    }

    @Transactional(readOnly = true)
    public List<GameMinDTO> findByList(Long listId) {
        List<GameMinProjection> result = gameRepository.searchByList(listId);
        return result.stream().map(GameMinDTO::new).toList();
    }
}
