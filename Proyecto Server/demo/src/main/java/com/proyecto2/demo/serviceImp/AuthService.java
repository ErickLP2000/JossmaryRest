package com.proyecto2.demo.serviceImp;

import org.springframework.stereotype.Service;

import com.proyecto2.demo.dto.AuthRequest;
import com.proyecto2.demo.dto.AuthResponse;

import lombok.RequiredArgsConstructor;


@Service
@RequiredArgsConstructor
public class AuthService {
 
    
    public AuthResponse login(AuthRequest request){
        return null;
    }
}
