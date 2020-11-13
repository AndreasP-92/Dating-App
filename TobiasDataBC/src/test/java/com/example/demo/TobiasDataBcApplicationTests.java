package com.example.demo;

import com.example.demo.model.Msg;
import com.example.demo.service.MessageDAO;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import java.util.List;

@SpringBootTest
class TobiasDataBcApplicationTests {
    private MessageDAO dao;



    @BeforeEach
    void setUp() throws Exception{
        DriverManagerDataSource datasource = new DriverManagerDataSource();
        datasource.setUrl("jdbc:mysql://138.197.186.159:3306/dating_app");
        datasource.setUsername("captain");
        datasource.setPassword("Uxr56vem.captain");
        datasource.setDriverClassName("com.mysql.jdbc.Driver");

        dao = new MessageDAO(new JdbcTemplate(datasource));
    }

    @Test
    void contextLoads() {
           }

    @Test
    void testList(){
        List<Msg> listMessage = dao.list();
        System.out.println((listMessage));

    }
}