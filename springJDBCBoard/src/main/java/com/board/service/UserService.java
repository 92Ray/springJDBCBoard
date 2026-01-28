package com.board.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.board.dao.UserDAO;
import com.board.domain.User;

@Service
public class UserService {

    @Autowired
    private UserDAO userDAO;

    // 회원가입
    public int join(User user) throws Exception {
        return userDAO.insertUser(user);
    }

    // 로그인
    public User login(String id, String password) throws Exception {
        User user = userDAO.selectById(id);
        if(user != null && user.getPassword().equals(password)) {
            return user;
        }
        return null;
    }

    // 회원탈퇴
    public int delete(String id) throws Exception {
        return userDAO.deleteUser(id);
    }
}
