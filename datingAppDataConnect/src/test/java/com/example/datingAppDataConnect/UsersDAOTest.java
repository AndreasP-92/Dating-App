package com.example.datingAppDataConnect;

import com.example.datingAppDataConnect.model.User;
import com.example.datingAppDataConnect.services.UsersDAO;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import static org.junit.Assert.*;

import org.springframework.jdbc.datasource.SimpleDriverDataSource;

import java.util.List;

public class UsersDAOTest {
    private UsersDAO dao;

    @BeforeEach
    void setUp() throws Exception {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setUrl("jdbc:mysql://138.197.186.159:3306/dating_app");
        dataSource.setUsername("captain");
        dataSource.setPassword("Uxr56vem.captain");
        dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");

        dao = new UsersDAO(new JdbcTemplate(dataSource));

    }

    @Test
    void testList() {
        List<User> listSale = dao.list();

        System.out.println(listSale);
    }
}
