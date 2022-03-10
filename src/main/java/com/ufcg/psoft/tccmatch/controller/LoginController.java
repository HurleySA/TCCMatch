package com.ufcg.psoft.tccmatch.controller;

import javax.validation.Valid;

import com.ufcg.psoft.tccmatch.dto.LoginDTO;
import com.ufcg.psoft.tccmatch.service.LoginService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
@RequestMapping(value = "api/login/")
public class LoginController {

    @Autowired
    private LoginService loginService;
    
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public String login(@RequestBody @Valid LoginDTO loginDto) {
        return loginService.login(loginDto);
    }

}
