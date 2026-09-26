package com.codingshuttle.Module1.HomeWork.service;

import com.codingshuttle.Module1.HomeWork.entity.Session;
import com.codingshuttle.Module1.HomeWork.entity.UserEntity;
import com.codingshuttle.Module1.HomeWork.repository.SessionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.web.authentication.session.SessionAuthenticationException;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Comparator;
import java.util.List;

@Service
@RequiredArgsConstructor
public class SessionService {

    private final SessionRepository sessionRepository;
    private final int LIMIT=2;

    public void generateSession(UserEntity user, String refreshToken){
        List<Session> userSessions = sessionRepository.findByUser(user);
        if(userSessions.size()==LIMIT){
            userSessions.sort(Comparator.comparing(Session::getLastUsedAt));
            Session lastUsedSession = userSessions.getFirst();
            sessionRepository.delete(lastUsedSession);
        }

        Session newSession = Session.builder()
                .refreshToken(refreshToken)
                .user(user)
                .build();
        sessionRepository.save(newSession);
    }

    public void validateSession(String refreshToken){
        if(sessionRepository.findByRefreshToken(refreshToken)==null){
            throw new SessionAuthenticationException("Invalid refresh token");
        }
        Session session = sessionRepository.findByRefreshToken(refreshToken);
        session.setLastUsedAt(LocalDateTime.now());
        sessionRepository.save(session);
    }
}
