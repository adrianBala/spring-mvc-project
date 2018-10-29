package com.training.springmvc.dao;

import com.training.springmvc.entity.Player;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public class PlayerDAOImpl implements PlayerDAO {

    @Autowired
    private SessionFactory sessionFactory;


    @Override
    @Transactional
    public List<Player> getPlayers() {
        Session session = sessionFactory.getCurrentSession();
        Query<Player> theQuery = session.createQuery("from Player", Player.class);
        List<Player> players = theQuery.getResultList();
        return players;
    }
}