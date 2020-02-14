package com.example.exercise.bootstrap;

import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

@Component
public class ProductBootstrap implements ApplicationListener<ContextRefreshedEvent> {


    @Autowired
    private DataSource DataSource;
    @Autowired
    private SqlSessionFactory sqlSessionFactory;

    @Override
    public void onApplicationEvent(ContextRefreshedEvent arg0) {
        addProducts();

    }

    private void addProducts() {
    }

    
}