package ru.student.shop;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.util.List;

public class ProductDao {
    private static SessionFactory factory;

    public static void setFactory(SessionFactory factory) {
        ProductDao.factory = factory;
    }

    public static Product findById(Long id){
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

    public static List<Product> findAll(){
        try (Session session = factory.getCurrentSession()) {
            session.beginTransaction();
            List<Product> products = session.createQuery("from SimpleItem").getResultList();
            session.getTransaction().commit();
            return products;
        }
    }

    public static void deleteById(Long id){
        try (Session session = factory.getCurrentSession()) {
            session.beginTransaction();
            Product simpleItem = session.get(Product.class, id);
            session.delete(simpleItem);
            session.getTransaction().commit();
        }
    }

    public static Product saveOrUpdate(Product product) {
        try (Session session = factory.getCurrentSession()) {
            session.beginTransaction();
            Product newProduct = product;
            session.saveOrUpdate(product);
            session.getTransaction().commit();
            return newProduct;
        }
    }
}
