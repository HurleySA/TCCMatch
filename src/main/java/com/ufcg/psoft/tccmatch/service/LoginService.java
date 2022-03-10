package com.ufcg.psoft.tccmatch.service;

import com.ufcg.psoft.tccmatch.dto.LoginDTO;

public interface LoginService {

    boolean validateToken(String token);

    String login(LoginDTO loginDto);
    
}
