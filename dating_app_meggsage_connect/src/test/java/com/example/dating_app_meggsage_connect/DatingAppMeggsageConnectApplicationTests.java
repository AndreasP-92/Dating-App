package com.example.dating_app_meggsage_connect;

import com.example.dating_app_meggsage_connect.model.Msg;
import com.example.dating_app_meggsage_connect.service.MsgDAO;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import java.util.List;

@SpringBootTest
class DatingAppMeggsageConnectApplicationTests {

    private MsgDAO dao;

    @BeforeEach
    void setUp() {
        DriverManagerDataSource datasource = new DriverManagerDataSource();
        datasource.setUrl("jdbc:mysql://138.197.186.159:3306/dating_app");
        datasource.setUsername("captain");
        datasource.setPassword("Uxr56vem.captain");
        datasource.setDriverClassName("com.mysql.jdbc.Driver");

        dao = new MsgDAO(new JdbcTemplate(datasource));
    }

    @Test
    void contextLoads() {
        List<Msg> listMsg = dao.list();
        System.out.println(listMsg);
    }

    @Test
    void testSave() {
        Msg msg = new Msg("asdasd", 22, "22-22-2020");
        dao.save(msg);
    }

}
