package com.ufcg.psoft.tccmatch.service.impl;

import com.ufcg.psoft.tccmatch.entity.Professor;
import com.ufcg.psoft.tccmatch.entity.ProposalTCCTheme;
import com.ufcg.psoft.tccmatch.entity.StudyArea;
import com.ufcg.psoft.tccmatch.entity.TCCTheme;
import com.ufcg.psoft.tccmatch.repository.TCCThemeRepository;
import com.ufcg.psoft.tccmatch.service.TCCThemeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

@Service
public class TCCThemeServiceImpl implements TCCThemeService {

    @Autowired
    TCCThemeRepository tccThemeRepository;


    @Override
    public TCCTheme registerTCCTheme(String title, String description, Set<StudyArea> studyAreas, Professor professor) {
        List<TCCTheme> themes = tccThemeRepository.findByTitle(title);
        if(themes.isEmpty()) {
            TCCTheme tccTheme = new TCCTheme(title, description, studyAreas, professor);
            tccThemeRepository.save(tccTheme);
            return tccTheme;
        }
        throw new RuntimeException("TCC Theme already exists");
    }

    @Override
    public List<TCCTheme> listTccThemes() {
        return tccThemeRepository.findAll();
    }

    @Override
    public TCCTheme getTCCThemeById(long idTccTheme) {
        return tccThemeRepository.findById(idTccTheme).orElseThrow(() -> new RuntimeException("TCCTheme not found"));
    }
}
