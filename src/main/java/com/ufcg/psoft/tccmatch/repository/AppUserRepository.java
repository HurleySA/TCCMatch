package com.ufcg.psoft.tccmatch.repository;

import java.util.Optional;

import com.ufcg.psoft.tccmatch.entity.AppUser;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AppUserRepository extends JpaRepository<AppUser, Long> {
    
    Optional<AppUser> findByEmail(String email);

}
