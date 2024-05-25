package com.sam.TaskTrek.repo;

import com.sam.TaskTrek.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepo extends JpaRepository<User,Long> {
    Optional<User> findByUsername(String username);
    Boolean existsByEmail(String email);
    Optional<User> findByUsernameOrEmail(String userName, String email);

    Boolean existsByUsername(String username);
}
