package com.example.demo;

import com.example.demo.model.Profile;
import com.example.demo.service.ProfileDAO;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.jdbc.datasource.SimpleDriverDataSource;

import java.sql.Driver;
import java.util.List;

@SpringBootTest
class DatingappJeffreyApplicationTests {
	private ProfileDAO dao;

	@Test
	void contextLoads() {
	}

	@BeforeEach
	void setUp() throws Exception{
		DriverManagerDataSource datasource = new DriverManagerDataSource();
		datasource.setUrl("jdbc:mysql://138.197.186.159:3306/dating_app");
		datasource.setUsername("captain");
		datasource.setPassword("Uxr56vem.captain");
		datasource.setDriverClassName("com.mysql.jdbc.Driver");

		dao = new ProfileDAO( new JdbcTemplate(datasource));

	}

	@Test
	void testlist() {
		List<Profile> listProfile = dao.list();

		System.out.println(listProfile);
	}

}
