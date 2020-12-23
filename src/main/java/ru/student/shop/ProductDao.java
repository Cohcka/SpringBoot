package ru.student.shop;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ProductDao {
    public static Product findById(Long id, SessionFactory factory){
        try (Session session = factory.getCurrentSession()) {
            session.beginTransaction();
            Product product = session.get(Product.class, id);
            session.getTransaction().commit();
            if(product!=null){
                return product;
            } else {
                throw new ResourceNotFoundException("Продукт с id = "+id+" не найден");
            }
        }
    }

    public static List<Product> findAll(SessionFactory factory){
        try (Session session = factory.getCurrentSession()) {
            session.beginTransaction();
            List<Product> products = session.createQuery("from Products").getResultList();
            session.getTransaction().commit();
            return products;
        }
    }

    public static void deleteById(Long id, SessionFactory factory){
        try (Session session = factory.getCurrentSession()) {
            session.beginTransaction();
            Product product = session.get(Product.class, id);
            session.delete(product);
            session.getTransaction().commit();
        }
    }

    public static Product saveOrUpdate(Product product, SessionFactory factory) {
        try (Session session = factory.getCurrentSession()) {
            session.beginTransaction();
            Product newProduct = product;
            session.saveOrUpdate(product);
            session.getTransaction().commit();
            return newProduct;
        }
    }
}
