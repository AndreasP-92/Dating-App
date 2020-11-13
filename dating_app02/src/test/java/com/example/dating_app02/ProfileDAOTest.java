package com.example.dating_app02;

import com.example.dating_app02.model.Profile;
import com.example.dating_app02.service.ProfileDAO;
import com.example.dating_app02.service.UsersDAO;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import java.util.List;

public class ProfileDAOTest {
    private ProfileDAO dao;

    @BeforeEach
    void setUp() throws Exception {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setUrl("jdbc:mysql://138.197.186.159:3306/dating_app");
        dataSource.setUsername("captain");
        dataSource.setPassword("Uxr56vem.captain");
        dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");

        dao = new ProfileDAO(new JdbcTemplate(dataSource));

    }

    @Test
    void testList() {
        List<Profile> listProfile = dao.list();

        System.out.println(listProfile);
    }
}
