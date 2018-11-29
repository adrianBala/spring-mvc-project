package com.training.springmvc.dao;

import com.training.springmvc.entity.Notice;
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
    public List<Player> getPlayers() {
        Session session = sessionFactory.getCurrentSession();
        Query<Player> theQuery = session.createQuery("from Player order by lastName",
                                                                Player.class);
        List<Player> players = theQuery.getResultList();
        return players;
    }

    @Override
    public void addPlayer(Player player) {
        Session session = sessionFactory.getCurrentSession();
        session.saveOrUpdate(player);
    }

    @Override
    public Player getPlayer(int id) {
        Session session = sessionFactory.getCurrentSession();
        Player player = session.get(Player.class, id);
        Query theQuery = session.createQuery("from Notice where player_id=:playerId", Notice.class);
        theQuery.setParameter("playerId", id);
        List<Notice> notices = theQuery.getResultList();
        player.setNotices(notices);
        return player;
    }

    @Override
    public void deletePlayer(int id) {
        Session session = sessionFactory.getCurrentSession();
        Query theQuery =
                session.createQuery("delete from Player where id=:playerId");
        theQuery.setParameter("playerId", id);
        theQuery.executeUpdate();
    }

    @Override
    public List<Player> searchPlayers(String theSearchName) {
        Session session = sessionFactory.getCurrentSession();
        Query theQuery = null;
        if(theSearchName != null && theSearchName.trim().length() > 0) {
            theQuery = session.createQuery("from Player where lower(firstName) " +
                    "like: theName or lower(lastName) like: theName order by lastName", Player.class);
            theQuery.setParameter("theName", "%" + theSearchName.toLowerCase() + "%");
        } else {
            theQuery = session.createQuery("from Player order by lastName", Player.class);
        }
        List<Player> players = theQuery.getResultList();
        return players;
    }
}
