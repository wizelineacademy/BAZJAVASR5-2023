package com.wizeline.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.wizeline.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    // Métodos personalizados, si es necesario
}