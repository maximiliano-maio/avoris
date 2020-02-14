package com.example.exercise;

import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class FindProductApp {

	@Autowired
	private SqlSessionFactory sqlSessionFactory;

	public static void main(String[] args) {
		SpringApplication.run(FindProductApp.class, args);
	}

}
