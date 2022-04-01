package com.ufcg.psoft.tccmatch.service;

import com.ufcg.psoft.tccmatch.dto.ProfessorDTO;
import com.ufcg.psoft.tccmatch.dto.RequestOrientationDTO;
import com.ufcg.psoft.tccmatch.dto.TCCThemeDTO;
import com.ufcg.psoft.tccmatch.entity.*;

import java.util.List;
import java.util.Set;

public interface ProfessorService {
    Professor getProfessorById(long id);

    void saveExistedProfessor(Professor professor);

    Professor createProfessor(ProfessorDTO professorDTO);

    Professor updateProfessor(long id, ProfessorDTO professorDTO);

    Professor deleteProfessor(long id);

    Professor changeOrientationQuota(long id, int newQuota);

    Professor addStudyArea(long id, String studyAreaName);

    Set<Professor> getProfessorsAvailable(List<StudyArea> studentStudyAreas);

    String registerTCCTheme(long id, TCCThemeDTO TCCThemeDTO);

    String listTCCThemes(long id);

    String listProposalTCCThemes(long id);

    List<Professor> findByStudyArea(StudyArea studyArea);

    RequestOrientation addRequestOrientation(Professor professor, Student student, TCCTheme tccTheme);

    String listaRequestOrientations(long id);

    String listOrientations(long id);

    ReportProfessor registerReport(long idProfessor, long idOrientation, String report);
}
