package services;

import entities.Artist;


import entities.CD;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class CDServices {

    private EntityManager em = null;
    private EntityTransaction tx = null;

    public CDServices(EntityManager em) {
        this.em = em;
        this.tx = em.getTransaction();
    }

    public CD createCD(String title, String description, String year, Set<Artist> Artist, Double price) {
        CD cd = new CD();
        //  cd.setId(ID);
        cd.setTitle(title);
        cd.setDescription(description);
        cd.setYear(year);

        tx.begin();
        em.persist(cd);
        tx.commit();

        return cd;
    }

    public CD createCD(CD cd) {
        tx.begin();
        em.persist(cd);
        tx.commit();
        return cd;
    }

    public CD findCD(Long id) {
        return em.find(CD.class, id);
    }

    public List<Long> findAll() {
        List cds_ids =  em.createQuery("SELECT id from CD").getResultList();
        return cds_ids;
    }

    public void removeCD(Long id) {
        CD cd = em.find(CD.class, id);
        if (cd != null) {
            tx.begin();
            em.remove(cd);
            tx.commit();
        }
    }

    public CD changeCDPrice(Long id, Double raiseBy) {
        CD cd = em.find(CD.class, id);
        if (cd != null) {
            tx.begin();
            cd.setPrice(cd.price() + raiseBy);
            tx.commit();
        }
        return cd;
    }

    public CD changeCDPrice(CD cd, Double raiseBy) {
        if (cd != null)
        {
            tx.begin();
             cd.setPrice(cd.price() + raiseBy);
             tx.commit();}
        return cd;
    }
}
