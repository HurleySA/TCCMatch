package com.ufcg.psoft.tccmatch.service;

import com.ufcg.psoft.tccmatch.entity.AppUser;

public interface AppUserService {

    AppUser getUserByEmail(String email);
    
}
