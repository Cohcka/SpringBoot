package ru.student.shop;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
public class Controller {
    @Autowired
    ProductDao productDao;
    @Autowired
    BuyerDao buyerDao;

    SessionFactory factory = new Configuration()
            .configure("hibernate.cfg.xml")
            .buildSessionFactory();
}
