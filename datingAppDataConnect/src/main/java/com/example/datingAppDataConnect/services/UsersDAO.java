package com.example.datingAppDataConnect.services;

import com.example.datingAppDataConnect.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;

import java.beans.BeanProperty;
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

    public void save (User user){
        SimpleJdbcInsert insertActor = new SimpleJdbcInsert(jdbcTemplate);

        insertActor.withTableName("app_user").usingColumns(
                    "user_mail"
                ,   "user_password"
                ,   "user_phone"
                ,   "user_date"
                ,   "active"
        );
        BeanPropertySqlParameterSource param = new BeanPropertySqlParameterSource(user);

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
        String sql ="UPDATE app_user SET user_password = :user_password, user_phone = :user_phone, user_date = :user_date, active = :active WHERE user_id = :user_id";

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
