package com.bmw.chat.client.authentication.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bmw.chat.client.authentication.domain.model.User;

public interface UserRepository extends JpaRepository<User, String> {

}
