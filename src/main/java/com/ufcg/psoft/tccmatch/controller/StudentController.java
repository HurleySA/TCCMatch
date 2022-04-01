package com.ufcg.psoft.tccmatch.controller;

import com.ufcg.psoft.tccmatch.dto.ProposalTCCThemeDTO;
import com.ufcg.psoft.tccmatch.entity.*;
import com.ufcg.psoft.tccmatch.service.OrientationService;
import com.ufcg.psoft.tccmatch.service.StudentService;
import com.ufcg.psoft.tccmatch.service.TCCThemeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;


import java.util.List;
import java.util.Set;

@RestController
@CrossOrigin
@RequestMapping(value = "api/student")
public class StudentController {

    @Autowired
    StudentService studentService;

    @Autowired
    TCCThemeService tccThemeService;

    @Autowired
    OrientationService orientationService;

    @GetMapping(value="/tcc-themes")
    @ResponseStatus(HttpStatus.OK)
    public List<TCCTheme> listTccThemes(){
        return tccThemeService.listTccThemes();
    }

    @PostMapping(value = "/{id}/study-area/")
    @ResponseStatus(HttpStatus.OK)
    public Student addStudyArea(@PathVariable("id") long id, @RequestBody String studyAreaName){
        return studentService.addStudyArea(id, studyAreaName);
    }

    @GetMapping(value = "/{id}/professor-match")
    @ResponseStatus(HttpStatus.OK)
    public Set<Professor> matchProfessorAvailabe(@PathVariable("id") long id) {
       return this.studentService.matchProfessors(id);
    }

    @PostMapping(value = "/{enrollment}/proposal-tcc-theme")
    @ResponseStatus(HttpStatus.CREATED)
    public String registerProposalTCCTheme(@PathVariable("enrollment") String enrollment, @RequestBody ProposalTCCThemeDTO proposalTCCThemeDTO) {
        return studentService.registerProposalTCCTheme(enrollment, proposalTCCThemeDTO);
    }

    @PostMapping(value = "/{id}/request-orientation")
    @ResponseStatus(HttpStatus.OK)
    public String requestOrientation(@PathVariable("id") long idStudent, long idProfessor, long idTCCTheme) {
        return orientationService.requestOrientation(idStudent, idProfessor, idTCCTheme);
    }

    @PostMapping(value = "/{idStudent}/report-orientation/{idOrientation}")
    @ResponseStatus(HttpStatus.OK)
    public ReportStudent reportOrientation(@PathVariable("idStudent") long idStudent, @PathVariable("idOrientation") long idOrientation, @RequestBody String report){
        return studentService.registerReport(idStudent, idOrientation, report);
    }
}
