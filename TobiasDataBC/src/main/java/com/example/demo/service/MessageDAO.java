package com.example.demo.service;

import com.example.demo.model.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class MessageDAO {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public MessageDAO(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<Message> list(){
        String sql = "SELECT * FROM app_messages";

      List<Message> listMessage = jdbcTemplate.query(sql, BeanPropertyRowMapper.newInstance(Message.class));

        return listMessage;
    }

    public void save(Message message){

    }

    public Message get(int id){
        return null;
    }

    public void update(Message message){

    }
    public void delete(int id){

    }
}
