package com.training.springmvc.service;

import com.training.springmvc.dao.PlayerDAO;
import com.training.springmvc.entity.Player;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class PlayerServiceImpl implements PlayerService {

    @Autowired
    PlayerDAO playerDAO;

    @Override
    @Transactional
    public List<Player> getPlayers() {
        return playerDAO.getPlayers();
    }

    @Override
    @Transactional
    public void addPlayer(Player player) {
        playerDAO.addPlayer(player);
    }

    @Override
    @Transactional
    public Player getPlayer(int id) {
        return playerDAO.getPlayer(id);
    }

    @Override
    @Transactional
    public void deletePlayer(int id) {
        playerDAO.deletePlayer(id);
    }

    @Override
    @Transactional
    public List<Player> searchPlayers(String theSearchName) {
        return playerDAO.searchPlayers(theSearchName);
    }
}
