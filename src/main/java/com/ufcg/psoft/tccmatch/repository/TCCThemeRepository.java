package com.ufcg.psoft.tccmatch.repository;

import com.ufcg.psoft.tccmatch.entity.TCCTheme;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TCCThemeRepository extends JpaRepository<TCCTheme, Long> {
    List<TCCTheme> findByTitle(String title);
}
