package com.ufcg.psoft.tccmatch.service;

import com.ufcg.psoft.tccmatch.entity.Professor;
import com.ufcg.psoft.tccmatch.entity.StudyArea;
import com.ufcg.psoft.tccmatch.entity.TCCTheme;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

public interface TCCThemeService {

    TCCTheme registerTCCTheme(String title, String description, Set<StudyArea> studyAreas, Professor professor);

    List<TCCTheme> listTccThemes();

    TCCTheme getTCCThemeById(long idTccTheme);
}
