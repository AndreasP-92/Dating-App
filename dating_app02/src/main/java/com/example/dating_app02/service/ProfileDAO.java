package com.example.dating_app02.service;

import com.example.dating_app02.model.Profile;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ProfileDAO {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public ProfileDAO(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<Profile> list() {
        String sql = "SELECT * FROM app_profile";

        List<Profile> listProfile = jdbcTemplate.query(sql, BeanPropertyRowMapper.newInstance(Profile.class));

        return listProfile;
    }

    public void save(Profile profile) {
        SimpleJdbcInsert insertActor = new SimpleJdbcInsert(jdbcTemplate);
        insertActor.withTableName("app_profile").usingColumns("profile_firstname","profile_lastname", "profile_desc", "profile_img", "profile_matches", "profile_matchTag");

        BeanPropertySqlParameterSource param = new BeanPropertySqlParameterSource(profile);
        insertActor.execute(param);
    }

    public Profile get(int Profile_id) {
        String sql = "SELECT * FROM app_profile WHERE Profile_id = ?";
        Object[] args = {Profile_id};
        Profile profile = jdbcTemplate.queryForObject(sql, args, BeanPropertyRowMapper.newInstance(Profile.class));

        return profile;
    }

    public void update(Profile profile) {
        String sql = "UPDATE app_profile SET profile_firstname = :profile_firstname, profile_lastname = :profile_lastname, profile_desc = :profile_desc, profile_img = :profile_img, profile_matches = :profile_matches, profile_Matchtag = :profile_matchTag WHERE profile_id = :profile_id";
        BeanPropertySqlParameterSource param = new BeanPropertySqlParameterSource(profile);
        NamedParameterJdbcTemplate template = new NamedParameterJdbcTemplate(jdbcTemplate);

        template.update(sql, param);
    }

    public void delete(int profile_id) {
        String sql = "DELETE FROM app_profile WHERE profile_id = ?";
        jdbcTemplate.update(sql, profile_id);
    }
}
