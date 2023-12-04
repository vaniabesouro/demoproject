package com.ips.tpsi.demo.bc;

import com.ips.tpsi.demo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ips.tpsi.demo.entity.User;

import java.util.List;

// a anotação Service serve para definir serviços, neste caso o nosso BC que é onde está a componente de lógica de negócio

@Service
public class WebBc {

    @Autowired
    UserRepository repository;

    public boolean isLoginValid(String name, String password) {
        if (name != null && password != null) {
            User user = repository.findUserByUsername(name);
            if (password.equals(user.getPassword())) {
                return true;
            }
        }
        return false;
    }

    public void getRepositoryUserInfo(String username, String pass) {
        List<User> userList = repository.findAll(); // select * from user;

        // método 1 - construir o objeto
        User user1 = new User();
        user1.setUsername(username);
        user1.setPassword(pass);
        repository.save(user1);

        // método 2 - construir o objeto c/ o que vem da bd + a alteração
        User user = repository.findUserByUsername(username);
        user.setPassword(pass);
        repository.save(user);
    }

    public User getRepositoryUserInfoByUsername(String username) {
        return repository.findUserByUsername(username);
    }

}
