package com.example.dating_app02.repository;

import com.example.dating_app02.model.Message;
import com.example.dating_app02.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class MessageDAO {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    // GET ALL MESSAGES
    public List<Message> list(){
        String sql = "SELECT * FROM app_messages";

        List<Message> listMessage = jdbcTemplate.query(sql,
                BeanPropertyRowMapper.newInstance(Message.class));

        return listMessage;
    }
    //        System.out.println(usermail);
//        String sql = "SELECT * FROM app_messages WHERE messages_usermail = 'test@asd.dk'";


//        String sql = "SELECT * FROM app_messages WHERE messages_usermail = ?";
    //        List<Message> conversation = (List<Message>) jdbcTemplate.queryForObject(sql, args,
//                BeanPropertyRowMapper.newInstance(Message.class));

    //        "+ "'" + usermail +" ' "
//        List <Message> conversation =  jdbcTemplate.query(sql,
//                BeanPropertyRowMapper.newInstance(Message.class));


    public List<Message> getConversation(){
        String sql = "SELECT * FROM app_messages";
//        Object[] args = {usermail};

        List<Message> listMessage = jdbcTemplate.query(sql,
                BeanPropertyRowMapper.newInstance(Message.class));

        return listMessage;
    }

    public Message getMessage(String user_mail){
        String sql = "SELECT * FROM app_user WHERE user_mail = ?";
        Object[] args = {user_mail};
        Message message = jdbcTemplate.queryForObject(sql, args,
                BeanPropertyRowMapper.newInstance(Message.class));

        return message;
    }

    public void saveChat (Message message){
        SimpleJdbcInsert insertActor = new SimpleJdbcInsert(jdbcTemplate);

        insertActor.withTableName("app_messages").usingColumns(
                "messages_context"
                ,   "messages_usermail"
                ,   "messages_date"
                );
        BeanPropertySqlParameterSource param = new BeanPropertySqlParameterSource(message);

        insertActor.execute(param);
    }

}
