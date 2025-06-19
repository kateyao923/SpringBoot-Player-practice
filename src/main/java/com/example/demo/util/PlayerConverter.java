package com.example.demo.util;

import com.example.demo.domain.Player;
import com.example.demo.dto.PlayerDTO;

import java.time.LocalDate;

public class PlayerConverter {

    public static PlayerDTO toDTO(Player player) {
        Long id = player.getId();
        String name = player.getName();
        int age = calculateAge(player);
        return new PlayerDTO(id, name, age);
    }

    public static int calculateAge(Player player) {
        String year = player.getBirthYear();
        String month = player.getBirthMonth();
        String day = player.getBirthDay();
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
