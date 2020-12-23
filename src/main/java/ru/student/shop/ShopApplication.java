package ru.student.shop;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class ShopApplication {

	public static void main(String[] args) {
		PrepareData.forcePrepareData();
		SpringApplication.run(ShopApplication.class, args);
	}
}
