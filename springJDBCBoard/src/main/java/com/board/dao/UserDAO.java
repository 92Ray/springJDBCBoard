package com.board.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.board.domain.User;

@Repository
public class UserDAO {
    
    @Autowired
    private JdbcTemplate jdbcTemplate;
    
    // 회원가입
    public int insertUser(User user) {
        String sql = "INSERT INTO users (id, password, nickName, email) VALUES (?, ?, ?, ?)";
        return jdbcTemplate.update(sql, user.getId(), user.getPassword(), user.getNickName(), user.getEmail());
    }
    
    // 아이디로 조회
    public User selectById(String id) {
        String sql = "SELECT id, password, nickName, email FROM users WHERE id = ?";
        try {
            return jdbcTemplate.queryForObject(sql, new BeanPropertyRowMapper<>(User.class), id);
        } catch (EmptyResultDataAccessException e) {
            return null;
        }
    }

    // 회원탈퇴
    public int deleteUser(String id) {
        String sql = "DELETE FROM users WHERE id = ?";
        return jdbcTemplate.update(sql, id);
    }
}
