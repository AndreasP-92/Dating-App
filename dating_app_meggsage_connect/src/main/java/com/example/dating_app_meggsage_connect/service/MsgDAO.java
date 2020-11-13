package com.example.dating_app_meggsage_connect.service;

import com.example.dating_app_meggsage_connect.model.Msg;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public class MsgDAO {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    public MsgDAO(JdbcTemplate jdbcTemplate) {

        this.jdbcTemplate = jdbcTemplate;
    }

    public List<Msg> list(){
        String sql = "SELECT * FROM app_messages";

        List<Msg> listMsg = jdbcTemplate.query(sql,
                BeanPropertyRowMapper.newInstance(Msg.class));

        System.out.println(sql);
        System.out.println(listMsg);
        return listMsg;
    }

    public void save(Msg message){

    }

    public Msg get(int id){
        return null;
    }

    public void update(Msg message){

    }
    public void delete(int id){

    }
}
