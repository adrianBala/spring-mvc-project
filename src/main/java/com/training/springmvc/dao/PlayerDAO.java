package com.training.springmvc.dao;

import com.training.springmvc.entity.Player;

import java.util.List;

public interface PlayerDAO {

    List<Player> getPlayers();
}