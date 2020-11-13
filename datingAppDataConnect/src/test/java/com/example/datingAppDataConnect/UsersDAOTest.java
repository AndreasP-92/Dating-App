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

    @Test
    void testSave() {
        User user = new User("tobias@gmail.com", "1234", 2222, "11-12-2020", 1);
        dao.save(user);
    }

    @Test
    void testGet() {
        int id = 2;
        User user = dao.get(id);

        assertNotNull(user);
    }

    @Test
    void testUpdate() {
        User user = new User();
        user.setUser_id(2);
        user.setUser_password("test");
        user.setUser_phone(333);
        user.setUser_date("date test");
        user.setActive(1);

        System.out.println(user);
        dao.update(user);
    }

    @Test
    void testDelete() {
        int id = 7;
        dao.delete(id);
    }
}
