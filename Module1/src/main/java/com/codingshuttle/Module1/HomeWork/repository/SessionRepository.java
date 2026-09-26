package com.codingshuttle.Module1.HomeWork.repository;

import com.codingshuttle.Module1.HomeWork.entity.Session;
import com.codingshuttle.Module1.HomeWork.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface SessionRepository extends JpaRepository<Session, UUID> {
    List<Session> findByUser(UserEntity user);

    Session findByRefreshToken(String refreshToken);
}