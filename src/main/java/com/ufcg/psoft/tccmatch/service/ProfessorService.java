package com.ufcg.psoft.tccmatch.service;

import com.ufcg.psoft.tccmatch.dto.ProfessorDTO;
import com.ufcg.psoft.tccmatch.entity.Professor;

public interface ProfessorService {
    Professor getProfessorById(long id);

    Professor saveExistedProfessor(Professor professor);

    Professor createProfessor(ProfessorDTO professorDTO);

    Professor updateProfessor(long id, ProfessorDTO professorDTO);

    Professor deleteProfessor(long id);
}
