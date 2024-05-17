package org.example.eshopfinal.service;

import org.example.eshopfinal.entities.UserInfo;
import org.example.eshopfinal.models.RefreshToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.stereotype.Service;
import org.example.eshopfinal.repository.RefreshTokenRepository;
import org.example.eshopfinal.repository.UserRepository;

import javax.security.auth.login.AccountNotFoundException;
import java.time.Instant;
import java.util.Optional;
import java.util.UUID;

/**
 * @author mhmdz
 * Created By Zeeshan on 20-05-2023
 * @project oauth-jwt
 */

@Service
public class RefreshTokenService {

    @Autowired
    RefreshTokenRepository refreshTokenRepository;
    @Autowired
    UserRepository userInfoRepository;

    @Autowired
    UserRepository userRepository;

    public RefreshToken createRefreshToken(String username) throws AccountNotFoundException {
        UserInfo userInfo = userInfoRepository.findByUsername(username);
        if(userInfo==null){
            throw new AccountNotFoundException("User not Found");
        }
        RefreshToken refreshToken = refreshTokenRepository.findByUserInfo(userInfo)
                .map(existingToken -> existingToken.toBuilder()
                        .token(UUID.randomUUID().toString())
                        .expiryDate(Instant.now().plusMillis(600000))
                        .build())
                .orElse(RefreshToken.builder()
                        .token(UUID.randomUUID().toString())
                        .expiryDate(Instant.now().plusMillis(600000))
                        .userInfo(userInfo)
                        .build());
        return refreshTokenRepository.save(refreshToken);
    }



    public Optional<RefreshToken> findByToken(String token){
        return refreshTokenRepository.findByToken(token);
    }

    public RefreshToken verifyExpiration(RefreshToken token){
        if(token.getExpiryDate().compareTo(Instant.now())<0){
            refreshTokenRepository.delete(token);
            throw new RuntimeException(token.getToken() + " Refresh token is expired. Please make a new login..!");
        }
        return token;

    }

}

