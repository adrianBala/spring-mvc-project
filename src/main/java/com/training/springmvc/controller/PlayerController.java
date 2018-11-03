package com.training.springmvc.controller;

import com.training.springmvc.entity.Player;
import com.training.springmvc.service.PlayerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/player")
public class PlayerController {

    @Autowired
    private PlayerService playerService;

    @GetMapping("/list")
    public String listPlayers(Model theModel) {
        List<Player> players = playerService.getPlayers();
        theModel.addAttribute("players", players);
        return "list-players";
    }

    @GetMapping("/showFormForAdd")
    public String showFormForAdd(Model theModel){
        Player player = new Player();
        theModel.addAttribute("player", player);
        return "player-form";
    }

    @PostMapping("/addPlayer")
    public String addPlayer(@ModelAttribute Player player) {
        playerService.addPlayer(player);
        return "redirect:/player/list";
    }

    @GetMapping("/showFormForUpdate")
    public String showFormForUpdate(@RequestParam("playerId") int id,
                                    Model theModel) {
        Player player = playerService.getPlayer(id);
        theModel.addAttribute("player", player);
        return "player-form";
    }

    @GetMapping("/delete")
    public String deletePlayer(@RequestParam("playerId") int id) {
        playerService.deletePlayer(id);
        return "redirect:/player/list";
    }
}
