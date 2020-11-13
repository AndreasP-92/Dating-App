package com.example.dating_app02.service;

import com.example.dating_app02.model.Authorities;
import com.example.dating_app02.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class UsersDAO {

    @Autowired
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

    public User getUser(String user_mail){
        String sql = "SELECT * FROM app_user WHERE user_mail = ?";
        Object[] args = {user_mail};
        User user = jdbcTemplate.queryForObject(sql, args,
                BeanPropertyRowMapper.newInstance(User.class));

        return user;
    }

    public void saveUser (User user){
        SimpleJdbcInsert insertActor = new SimpleJdbcInsert(jdbcTemplate);

        System.out.println(user);

        insertActor.withTableName("app_user").usingColumns(
                "user_mail"
                ,   "user_password"
                ,   "user_phone"
                ,   "user_date"
                ,   "active"
                ,   "user_enabled"
        );
        BeanPropertySqlParameterSource param = new BeanPropertySqlParameterSource(user);

        insertActor.execute(param);
    }

    public void saveAuth (Authorities auth){
        SimpleJdbcInsert insertActor = new SimpleJdbcInsert(jdbcTemplate);

        System.out.println(auth);

        insertActor.withTableName("authorities").usingColumns(
                    "usermail"
                ,   "authority"
        );
        BeanPropertySqlParameterSource param = new BeanPropertySqlParameterSource(auth);

        insertActor.execute(param);
    }

    public User get(int id){
        String sql = "SELECT * FROM app_user WHERE user_id = ?";
        Object[] args = {id};
        User user = jdbcTemplate.queryForObject(sql, args,
                BeanPropertyRowMapper.newInstance(User.class));

        return user;
    }

    public void update(User user){
//        String sql =
//                "UPDATE user_app SET " +
//                "user_name = : user_name, " +
//                "user_mail = : user_mail, " +
//                "user_phone = :user_phone, " +
//                "user_date = : user_date, " +
//                "active = : active, " +
//                "WHERE user_id = : user_id";
        String sql ="UPDATE app_user SET user_password = :user_password, user_phone = :user_phone, user_date = :user_date, active = :active user_enabled = :user_enabled WHERE user_id = :user_id";

//        System.out.println(user);
//        System.out.println("SQL===="+sql);
        BeanPropertySqlParameterSource param = new BeanPropertySqlParameterSource(user);
        NamedParameterJdbcTemplate template = new NamedParameterJdbcTemplate(jdbcTemplate);
        System.out.println(param);
        System.out.println("Template======"+template.update(sql, param));

        template.update(sql, param);
    }

    public void delete(int id){
        String sql = "DELETE FROM app_user WHERE user_id = ?";
        jdbcTemplate.update(sql, id);

    }
}
