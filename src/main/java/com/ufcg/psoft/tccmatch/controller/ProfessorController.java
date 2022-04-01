package com.ufcg.psoft.tccmatch.controller;

import com.ufcg.psoft.tccmatch.entity.Professor;

import com.ufcg.psoft.tccmatch.dto.TCCThemeDTO;

import com.ufcg.psoft.tccmatch.entity.ReportProfessor;
import com.ufcg.psoft.tccmatch.entity.ReportStudent;
import com.ufcg.psoft.tccmatch.service.ProfessorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping(value = "api/professor")
public class ProfessorController {

    @Autowired
    ProfessorService professorService;

    @PutMapping(value = "/{id}/orientation-quota/")
    @ResponseStatus(HttpStatus.OK)
    public Professor changeOrientationQuota(@PathVariable("id") long id, @RequestBody int orientationQuota){
        return this.professorService.changeOrientationQuota(id, orientationQuota);
    }

    @PostMapping(value = "/{id}/study-area/")
    @ResponseStatus(HttpStatus.OK)
    public Professor addStudyArea(@PathVariable("id") long id, @RequestBody String studyAreaName){
        return professorService.addStudyArea(id, studyAreaName);
    }

    @PostMapping(value = "/{id}/tcc-theme")
    @ResponseStatus(HttpStatus.CREATED)
    public String registerProposalTCCTheme(@PathVariable("id") long id, @RequestBody TCCThemeDTO TCCThemeDTO) {
        return professorService.registerTCCTheme(id, TCCThemeDTO);
    }

    @GetMapping(value = "{id}/tcc-themes")
    @ResponseStatus(HttpStatus.OK)
    public String listTCCThemes(@PathVariable("id") long id) {
        return professorService.listTCCThemes(id);
    }

    @GetMapping(value = "/{id}/proposal-tcc-themes")
    @ResponseStatus(HttpStatus.OK)
    public String listaProposalTCCThemes(@PathVariable("id") long id) {return professorService.listProposalTCCThemes(id);}

    @GetMapping(value = "/{id}/request-orientations")
    @ResponseStatus(HttpStatus.OK)
    public String listaRequestOrientations(@PathVariable("id") long id) {return professorService.listaRequestOrientations(id);}

    @GetMapping(value = "/{id}/orientations")
    @ResponseStatus(HttpStatus.OK)
    public String listOrientations(@PathVariable("id") long id) { return professorService.listOrientations(id);}

    @PostMapping(value = "/{idProfessor}/report-orientation/{idOrientation}")
    @ResponseStatus(HttpStatus.OK)
    public ReportProfessor reportOrientation(@PathVariable("idProfessor") long idProfessor, @PathVariable("idOrientation") long idOrientation, @RequestBody String report){
        return professorService.registerReport(idProfessor, idOrientation, report);
    }

}
