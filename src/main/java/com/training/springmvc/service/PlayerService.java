package com.training.springmvc.service;

import com.training.springmvc.entity.Player;

import java.util.List;

public interface PlayerService {

    List<Player> getPlayers();

    void addPlayer(Player player);

    Player getPlayer(int id);
}
