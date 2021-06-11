package com.jiban.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.jiban.model.User;


@Repository
public class UserJDBCRepository {
    @Autowired
    JdbcTemplate jdbcTemplate;

    class UserRowMapper implements RowMapper < User > {
        @Override
        public User mapRow(ResultSet rs, int rowNum) throws SQLException {
            User user = new User();
            
            user.setName(rs.getString("name"));
            user.setEmail(rs.getString("email"));
            user.setPassword(rs.getString("password"));
            user.setBirthday(rs.getDate("birthday"));
            user.setProfession(rs.getString("profession"));
            user.setGender(rs.getString("gender"));
            user.setMarried(rs.getBoolean("married"));
            user.setNote(rs.getString("note"));
            
            return user;
        }
    }

    public List < User > findAll() {
        return jdbcTemplate.query("select * from user", new UserRowMapper());
    }

    @SuppressWarnings("deprecation")
	public Optional < User > findByEmail(String string) {
        return Optional.of(jdbcTemplate.queryForObject("select * from user where email=?", new Object[] {
                string
            },
            new BeanPropertyRowMapper < User > (User.class)));
    }
    
//    @SuppressWarnings("deprecation")
//	public User findByEmail(String string) {
//    	return jdbcTemplate.queryForObject("select * from user where email=?", new Object[] {string},new UserRowMapper());
//    }

    public int deleteByEmail(long id) {
        return jdbcTemplate.update("delete from user where email=?", new Object[] {
            id
        });
    }

    public int insert(User user) {
        return jdbcTemplate.update("insert into user (name, email, password,birthday, profession, gender, married, note) " + "values(?, ?, ?, ?,?, ?, ?, ?)",
            new Object[] {
                user.getName(), user.getEmail(), user.getPassword(), user.getBirthday(),user.getProfession(),user.getGender(),user.isMarried(),user.getNote()
            });
    }

    public int update(User user) {
        return jdbcTemplate.update("update user " + " set name = ?, email = ?, passowrd = ?  ,birthday = ?, profession =?, married = ? ,note=? "  + " where email = ?",
            new Object[] {
            		user.getName(), user.getEmail(), user.getPassword(), user.getBirthday(),user.getProfession(),user.getGender(),user.isMarried(),user.getNote()
            });
    }
}

