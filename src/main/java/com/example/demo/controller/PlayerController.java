package com.example.demo.controller;

import com.example.demo.service.PlayerService;
import com.example.demo.dto.PlayerDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/players")
public class PlayerController {

    @Autowired
    private PlayerService playerService;

    //Get all players
    @GetMapping
    public ResponseEntity<List<PlayerDTO>> getAllPlayer(){
        return ResponseEntity.ok(playerService.getAllPlayers());

    }

    //Get player by ID
    @GetMapping("/{id}")
    public ResponseEntity<PlayerDTO> getPlayerById(@PathVariable Long id){
        return ResponseEntity.ok(playerService.getPlayerById(id));
    }
}
