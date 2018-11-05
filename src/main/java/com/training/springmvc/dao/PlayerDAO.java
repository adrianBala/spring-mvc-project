package com.training.springmvc.dao;

import com.training.springmvc.entity.Player;

import java.util.List;

public interface PlayerDAO {

    List<Player> getPlayers();

    void addPlayer(Player player);

    Player getPlayer(int id);

    void deletePlayer(int id);

    List<Player> searchPlayers(String theSearchName);
}
