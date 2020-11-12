package com.example.demo.service;

import com.example.demo.model.Profile;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

public class ProfileDAO {
    private JdbcTemplate jdbcTemplate;

    public ProfileDAO(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<Profile> list() {
        String sql = "SELET * FROM APP_PROFILE";

        List<Profile> listProfile = jdbcTemplate.query(sql, BeanPropertyRowMapper.newInstance(Profile.class));

        return listProfile;
    }

    public void save(Profile profile) {

    }

    public Profile get(int Profile_id) {
        return null;
    }

    public void update(Profile profile) {

    }

    public void delete(int profile_id) {

    }
}
