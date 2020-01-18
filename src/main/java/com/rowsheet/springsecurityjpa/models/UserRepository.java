package com.rowsheet.springsecurityjpa.models;

import com.rowsheet.springsecurityjpa.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.access.prepost.PreAuthorize;

import java.util.Optional;

@PreAuthorize("hasRole('ROLE_ADMIN')")
public interface UserRepository extends JpaRepository<User, Integer> {
    Optional<User> findUserByUserName(String username);
}
