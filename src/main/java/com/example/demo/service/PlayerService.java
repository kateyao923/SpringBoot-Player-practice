package com.example.demo.service;

import com.example.demo.dto.PlayerDTO;

import java.util.List;

public interface PlayerService {
    PlayerDTO getPlayerById(Long id);
    List<PlayerDTO> getAllPlayers();
}
