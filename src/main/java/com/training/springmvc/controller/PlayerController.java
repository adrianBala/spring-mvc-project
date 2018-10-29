package com.training.springmvc.controller;

import com.training.springmvc.dao.PlayerDAO;
import com.training.springmvc.entity.Player;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/player")
public class PlayerController {

    @Autowired
    private PlayerDAO playerDAO;

    @GetMapping("/list")
    public String listPlayers(Model theModel) {
        List<Player> players = playerDAO.getPlayers();
        theModel.addAttribute("players", players);
        return "list-players";
    }
}
