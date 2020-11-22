package com.example.dating_app02.repository;

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

// GET ALL USERS
    public List<User> list(){
        String sql = "SELECT * FROM app_user";

        List<User> listUser = jdbcTemplate.query(sql,
                BeanPropertyRowMapper.newInstance(User.class));

        return listUser;
    }

//    GET USER WITH MAIL
    public User getUser(String user_mail){
        String sql = "SELECT * FROM app_user WHERE user_mail = ?";
        Object[] args = {user_mail};
        User user = jdbcTemplate.queryForObject(sql, args,
                BeanPropertyRowMapper.newInstance(User.class));

        return user;
    }

// SAVE USER
    public void saveUser (User user){
        SimpleJdbcInsert insertActor = new SimpleJdbcInsert(jdbcTemplate);

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

// SAVE ROLE
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

//
    public User get(int id){
        String sql = "SELECT * FROM app_user WHERE user_id = ?";
        Object[] args = {id};
        User user = jdbcTemplate.queryForObject(sql, args,
                BeanPropertyRowMapper.newInstance(User.class));

        return user;
    }

//    UPDATE USER
    public void update(User user){
//        String sql =
//                "UPDATE user_app SET " +
//                "user_name = : user_name, " +
//                "user_mail = : user_mail, " +
//                "user_phone = :user_phone, " +
//                "user_date = : user_date, " +
//                "active = : active, " +
//                "WHERE user_id = : user_id";
        String sql ="UPDATE app_user SET user_password = :user_password, user_phone = :user_phone, user_date = :user_date, active = :active WHERE user_id = :user_id";

        System.out.println(user);
//        System.out.println("SQL===="+sql);
        BeanPropertySqlParameterSource param = new BeanPropertySqlParameterSource(user);
        NamedParameterJdbcTemplate template = new NamedParameterJdbcTemplate(jdbcTemplate);
        System.out.println(param);
        System.out.println("Template======"+template.update(sql, param));

        template.update(sql, param);
    }

    public void delete(String user_mail){
        String sql = "DELETE app_user FROM app_user LEFT JOIN authorities ON app_user.user_mail = authorities.usermail WHERE user_mail = ?";

        jdbcTemplate.update(sql, user_mail);

    }
}
