package com.ips.tpsi.demo.bc;

import com.ips.tpsi.demo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ips.tpsi.demo.entity.User;

import java.util.List;

@Service
public class WebBc {

    @Autowired
    UserRepository repository;

    public boolean login(String name, String password) {
        if (name != null && password != null) {
            // name passord
            return true;
        }
        return false;
    }

    public void getRepositoryUserInfo() {
        List<User> userList = repository.findAll();
    }

    public User getRepositoryUserInfoByUsername(String username) {
        User user = repository.findUserByUsername(username);
        return user;
    }
}
