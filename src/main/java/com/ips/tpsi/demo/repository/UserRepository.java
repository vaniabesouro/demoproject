package com.ips.tpsi.demo.repository;
import com.ips.tpsi.demo.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

    User findUserByUsername(String username);

}
