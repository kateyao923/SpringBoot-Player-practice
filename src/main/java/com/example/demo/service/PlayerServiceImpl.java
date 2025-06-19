package com.example.demo.service;

import com.example.demo.domain.Player;
import com.example.demo.dto.PlayerDTO;
import com.example.demo.repository.PlayerRepository;
import com.example.demo.util.PlayerConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class PlayerServiceImpl implements PlayerService {

    @Autowired
    private PlayerRepository repository;

    @Override
    public PlayerDTO getPlayerById(Long id){
        Player player = repository.findById(id).orElseThrow(() -> new RuntimeException("Player not found"));
        PlayerDTO dto = PlayerConverter.toDTO(player);
        return dto;

    }

    @Override
    public List<PlayerDTO> getAllPlayers() {
        return repository.findAll()
                .stream()
                .map(PlayerConverter::toDTO)
                .collect(Collectors.toList());
    }
}
