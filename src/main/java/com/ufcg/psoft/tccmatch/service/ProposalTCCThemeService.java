package com.ufcg.psoft.tccmatch.service;

import com.ufcg.psoft.tccmatch.entity.ProposalTCCTheme;
import com.ufcg.psoft.tccmatch.entity.Student;
import com.ufcg.psoft.tccmatch.entity.StudyArea;

import java.util.List;

public interface ProposalTCCThemeService {

    ProposalTCCTheme registerProposalTCCTheme(String title, String description, boolean status, List<StudyArea> studyAreas, Student student);

    List<ProposalTCCTheme> getProposalTCCThemeByTitle(String title);

    List<ProposalTCCTheme> getAllProposalTCCThemes();
}

