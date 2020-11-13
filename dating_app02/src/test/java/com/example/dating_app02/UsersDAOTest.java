package com.example.dating_app02;

import com.example.dating_app02.model.User;
import com.example.dating_app02.service.UsersDAO;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

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

    @Test
    void testSave() {
        User user = new User("tobia22s@gmail.com", "1234", 2222, "11-12-2020",0, 1);
        dao.saveUser(user);
    }
}
