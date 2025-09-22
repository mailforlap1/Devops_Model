package com.example.crud_app.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.crud_app.model.User;

public interface UserRepository extends JpaRepository<User,Long> {

}
