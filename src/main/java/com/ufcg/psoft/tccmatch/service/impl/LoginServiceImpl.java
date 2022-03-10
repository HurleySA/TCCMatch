package com.ufcg.psoft.tccmatch.service.impl;

import com.ufcg.psoft.tccmatch.dto.LoginDTO;
import com.ufcg.psoft.tccmatch.entity.AppUser;
import com.ufcg.psoft.tccmatch.service.AppUserService;
import com.ufcg.psoft.tccmatch.service.LoginService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoginServiceImpl implements LoginService {

    @Autowired
    private AppUserService appUserService;

    @Override
    public boolean validateToken(String token) {
        // TODO implementar usando jwt
        return true;
    }

    @Override
    public String login(LoginDTO loginDto) {
        AppUser user = appUserService.getUserByEmail(loginDto.getEmail());
        return null;
    }
    










}

