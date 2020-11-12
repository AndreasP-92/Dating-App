package com.example.datingAppDataConnect.services;

import com.example.datingAppDataConnect.model.User;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

public class UsersDAO {
    private JdbcTemplate jdbcTemplate;


    public UsersDAO(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<User> list(){
        String sql = "SELECT * FROM app_user";

        List<User> listUser = jdbcTemplate.query(sql,
                BeanPropertyRowMapper.newInstance(User.class));

        return listUser;
    }

    public void save (User user){

    }

    public User get(int id){
        return null;
    }

    public void update(User user){

    }

    public void delete(User id){

    }
}
