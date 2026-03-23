package com.example.miniMarketPlace.users.adapters.out;

import com.example.miniMarketPlace.users.domain.User;
import com.example.miniMarketPlace.users.domain.UserRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public class JpaUsersRepository implements UserRepository {

    private final SpringDataUserRepository springDataUserRepository;

    public JpaUsersRepository(SpringDataUserRepository springDataUserRepository) {
        this.springDataUserRepository = springDataUserRepository;
    }

    @Override
    public User save(User user) {
        return springDataUserRepository.save(user);
    }

    @Override
    public Optional<User> findById(Long id) {
        return springDataUserRepository.findById(id);
    }

    @Override
    public Optional<User> findByUsername(String username) {
        return springDataUserRepository.findByUsername(username);
    }

    @Override
    public void deleteById(Long id) {
        springDataUserRepository.deleteById(id);
    }
}
