package ru.student.shop;

import org.hibernate.cfg.Configuration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ShopApplication {

	public static void main(String[] args) {
		PrepareData.forcePrepareData();
		Controller.setFactory(new Configuration()
				.configure("hibernate.cfg.xml")
				.buildSessionFactory());
		SpringApplication.run(ShopApplication.class, args);
	}
}
