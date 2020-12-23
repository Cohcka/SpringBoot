package ru.student.shop;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.util.List;


public class BuyerDao {
    public static Buyer findById(Long id,SessionFactory factory){
        try (Session session = factory.getCurrentSession()) {
            session.beginTransaction();
            Buyer buyer = session.get(Buyer.class, id);
            session.getTransaction().commit();
            if(buyer!=null){
                return buyer;
            } else {
                throw new ResourceNotFoundException("Покупатель с id = "+id+" не найден");
            }
        }
    }

    public static List<Buyer> findAll(SessionFactory factory){
        try (Session session = factory.getCurrentSession()) {
            session.beginTransaction();
            List<Buyer> buyers = session.createQuery("from Buyers").getResultList();
            session.getTransaction().commit();
            return buyers;
        }
    }

    public static void deleteById(Long id, SessionFactory factory){
        try (Session session = factory.getCurrentSession()) {
            session.beginTransaction();
            Buyer buyer = session.get(Buyer.class, id);
            session.delete(buyer);
            session.getTransaction().commit();
        }
    }

    public static Buyer saveOrUpdate(Buyer buyer, SessionFactory factory) {
        try (Session session = factory.getCurrentSession()) {
            session.beginTransaction();
            Buyer newBuyer = buyer;
            session.saveOrUpdate(newBuyer);
            session.getTransaction().commit();
            return newBuyer;
        }
    }
}
