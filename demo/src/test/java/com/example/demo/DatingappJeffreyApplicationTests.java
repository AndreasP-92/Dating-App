package com.example.demo;

import com.example.demo.model.Profile;
import com.example.demo.service.ProfileDAO;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import static org.junit.Assert.*;

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

	@Test
	void testSave() {
		Profile profile = new Profile("Tobias","Cho","sfsdf","sfdfsdf", 0,"werer");
		dao.save(profile);
	}

	@Test
	void testGet() {
		int Profile_id = 6;
		Profile profile = dao.get(Profile_id);

		assertNotNull(profile);
	}

	@Test
	void testUpdate() {
		Profile profile = new Profile();
		profile.setProfile_id(6);
		profile.setProfile_firstname("test New");
		profile.setProfile_lastname("test New");
		profile.setProfile_desc("test New");
		profile.setProfile_img("test New");
		profile.setProfile_matches(2);
		profile.setProfile_matchTag("test New");

		dao.update(profile);
	}
	@Test
	void testDelete() {
		int profile_id = 6;
		dao.delete(profile_id);
	}
}
