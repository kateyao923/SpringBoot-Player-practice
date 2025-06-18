package com.example.demo.repository;

import com.example.demo.domain.Player;
import com.example.demo.dto.PlayerDTO;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PlayerRepository extends JpaRepository<Player, Long> {
}
