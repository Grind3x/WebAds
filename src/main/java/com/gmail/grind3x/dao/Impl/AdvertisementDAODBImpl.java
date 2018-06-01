package com.gmail.grind3x.dao.Impl;

import com.gmail.grind3x.dao.AdvertisementDAO;
import com.gmail.grind3x.dao.PostgresDAOFactory;
import com.gmail.grind3x.model.Advertisement;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.NonUniqueResultException;
import javax.persistence.Query;
import java.util.List;

public class AdvertisementDAODBImpl implements AdvertisementDAO {
    private EntityManager em;

    public AdvertisementDAODBImpl() {
        em = PostgresDAOFactory.getEntityManager();
    }

    @Override
    public List<Advertisement> getAll() {
        List<Advertisement> list = null;
        try {
            Query query = em.createQuery("SELECT a FROM Advertisement a", Advertisement.class);
            list = (List<Advertisement>) query.getResultList();
        } catch (NoResultException e) {
            return null;
        }
        return list;
    }

    @Override
    public void insert(Advertisement advertisement) {
        em.getTransaction().begin();
        em.persist(advertisement);
        em.getTransaction().commit();
    }

    @Override
    public void delete(Advertisement advertisement) {
        em.getTransaction().begin();
        em.remove(advertisement);
        em.getTransaction().commit();
    }

    @Override
    public List<Advertisement> findByAuthor(String name) {
        List<Advertisement> list = null;
        try {
            Query query = em.createQuery("SELECT a FROM Advertisement a WHERE a.author = :name", Advertisement.class);
            query.setParameter("name", name);
            list = query.getResultList();
        } catch (NoResultException e) {
            return null;
        }
        return list;
    }

    @Override
    public Advertisement findById(Long id) {
        Advertisement advertisement = null;
        try {
            Query query = em.createQuery("SELECT a FROM Advertisement a WHERE a.id = :id", Advertisement.class);
            query.setParameter("id", id);
            advertisement = (Advertisement) query.getSingleResult();
        } catch (NoResultException | NonUniqueResultException e) {
            return null;
        }
        return advertisement;
    }

    @Override
    public void update(Advertisement advertisement) {
        em.getTransaction().begin();
        em.refresh(advertisement);
        em.getTransaction().commit();
    }
}
