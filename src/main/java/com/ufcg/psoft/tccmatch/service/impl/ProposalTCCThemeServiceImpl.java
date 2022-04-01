package com.ufcg.psoft.tccmatch.service.impl;

import com.ufcg.psoft.tccmatch.entity.ProposalTCCTheme;
import com.ufcg.psoft.tccmatch.entity.Student;
import com.ufcg.psoft.tccmatch.entity.StudyArea;
import com.ufcg.psoft.tccmatch.repository.ProposalTCCThemeRepository;
import com.ufcg.psoft.tccmatch.service.ProposalTCCThemeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProposalTCCThemeServiceImpl implements ProposalTCCThemeService {

    @Autowired
    ProposalTCCThemeRepository proposalTCCThemeRepository;

    @Override
    public ProposalTCCTheme registerProposalTCCTheme(String title, String description, boolean status, List<StudyArea> studyAreas, Student student) {
        List<ProposalTCCTheme> proposal = this.getProposalTCCThemeByTitle(title);
        if(proposal.isEmpty()) {
            ProposalTCCTheme proposalTCCTheme = new ProposalTCCTheme(title, description, status, studyAreas, student);
            proposalTCCThemeRepository.save(proposalTCCTheme);
            return proposalTCCTheme;
        }
        throw new RuntimeException("Proposal TCC Theme already exists");
    }

    @Override
    public List<ProposalTCCTheme> getProposalTCCThemeByTitle(String title) {
        return proposalTCCThemeRepository.findByTitle(title);

    }

    @Override
    public List<ProposalTCCTheme> getAllProposalTCCThemes() {
        return proposalTCCThemeRepository.findAll();
    }
}


