package com.Zomato.Authservicezomato.service;

import com.Zomato.Authservicezomato.model.User;
import com.Zomato.Authservicezomato.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private JwtService jwtService;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public String createUser(User user){
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        userRepository.save(user);
        return "User created and add to system";
    }

    public String generateToken(String username){
        return jwtService.generateToken(username);
    }

    public void validToken(String token){
        jwtService.validateToken(token);
    }
}
