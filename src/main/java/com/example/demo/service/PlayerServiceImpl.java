package com.example.demo.service;

import com.example.demo.domain.Player;
import com.example.demo.dto.PlayerDTO;
import com.example.demo.repository.PlayerRepository;
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
        // 1. get player by id through repo
        Player player = repository.findById(id).orElseThrow(() -> new RuntimeException("Player not found"));
        // 2. calculate age from the player info
        int age = calculateAge(player.getBirthYear(), player.getBirthMonth(), player.getBirthDay());
        // 3. use id + name + age to build the dto
        PlayerDTO dto = new PlayerDTO(
                player.getId(),player.getName(),age
        );
        // 4. return
        return dto;

    }

    @Override
    public List<PlayerDTO> getAllPlayers() {
        return repository.findAll()
                .stream()
                .map(player -> new PlayerDTO(
                        player.getId(), player.getName(), calculateAge(
                        player.getBirthYear(), player.getBirthMonth(), player.getBirthDay())
                ))
                .collect(Collectors.toList());
    }

    private int calculateAge(String year, String month, String day){
        try{
            int birthYear = Integer.parseInt(year);
            int birthMonth = Integer.parseInt(month);
            int birthDay = Integer.parseInt(day);

            //Get date of today
            LocalDate today = LocalDate.now();
            int currentYear = today.getYear();
            int currentMonth = today.getMonthValue();
            int currentDay = today.getDayOfMonth();

            //assume
            int currentAge = currentYear - birthYear;

            if (currentMonth < birthMonth || (currentMonth == birthMonth && currentDay < birthDay)) {
                currentAge--;
            }

            return currentAge;
        }catch (Exception e) {
            throw new RuntimeException("The date of birth format is incorrect.");
        }

    }


}
