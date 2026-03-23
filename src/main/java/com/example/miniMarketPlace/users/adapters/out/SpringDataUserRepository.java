package com.example.miniMarketPlace.users.adapters.out;

import com.example.miniMarketPlace.users.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface SpringDataUserRepository extends JpaRepository<User, Long>{

    Optional<User> findByUsername(String username);

}
