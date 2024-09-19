package com.sisd.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sisd.entity.Users;

public interface UsersRepository extends JpaRepository<Users, String> {
    Users findByUserName(String userName);
}
