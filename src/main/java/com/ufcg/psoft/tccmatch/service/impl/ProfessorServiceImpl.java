package com.ufcg.psoft.tccmatch.service.impl;

import com.ufcg.psoft.tccmatch.dto.ProfessorDTO;
import com.ufcg.psoft.tccmatch.entity.Professor;
import com.ufcg.psoft.tccmatch.repository.ProfessorRepository;
import com.ufcg.psoft.tccmatch.service.ProfessorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProfessorServiceImpl implements ProfessorService {

    @Autowired
    ProfessorRepository professorRepository;

    @Override
    public Professor getProfessorById(long id){
        return professorRepository.findById(id).orElseThrow(() -> new RuntimeException(("Professor not found.")));
    }

    @Override
    public Professor saveExistedProfessor(Professor professor){
        return professorRepository.save(professor);
    }

    @Override
    public Professor createProfessor(ProfessorDTO professorDTO) {
        Professor professor = new Professor(professorDTO.getName(), professorDTO.getEmail(), professorDTO.getLaboratories());
        professorRepository.save(professor);
        return professor;
    }

    @Override
    public Professor updateProfessor(long id, ProfessorDTO professorDTO) {
        Professor professor = this.getProfessorById(id);
        professor.setName(professorDTO.getName());
        professor.setEmail(professorDTO.getEmail());
        professor.setLaboratories(professorDTO.getLaboratories());
        this.saveExistedProfessor(professor);
        return professor;
    }

    @Override
    public Professor deleteProfessor(long id) {
        Professor professor = this.getProfessorById(id);
        professorRepository.delete(professor);

        return professor;
    }
}
