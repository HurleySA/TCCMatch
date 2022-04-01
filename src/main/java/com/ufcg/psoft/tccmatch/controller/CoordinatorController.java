package com.ufcg.psoft.tccmatch.controller;

import com.ufcg.psoft.tccmatch.dto.OrientationDTO;
import com.ufcg.psoft.tccmatch.dto.ProfessorDTO;
import com.ufcg.psoft.tccmatch.dto.StudentDTO;
import com.ufcg.psoft.tccmatch.entity.Orientation;
import com.ufcg.psoft.tccmatch.entity.Professor;
import com.ufcg.psoft.tccmatch.entity.Student;
import com.ufcg.psoft.tccmatch.entity.StudyArea;
import com.ufcg.psoft.tccmatch.service.CoordinatorService;
import com.ufcg.psoft.tccmatch.service.StudyAreaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping("api/coordinator")
public class CoordinatorController {

    @Autowired
    CoordinatorService coordinatorService;

    @Autowired
    StudyAreaService studyAreaService;

    @PostMapping(value = "/student/")
    @ResponseStatus(HttpStatus.CREATED)
    public Student registerStudent(@RequestBody StudentDTO studentDTO) {
        return coordinatorService.registerStudent(studentDTO);
    }

    @PutMapping(value = "/student/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Student updateStudent(@PathVariable("id") long id,@RequestBody StudentDTO studentDTO) {
        return coordinatorService.updateStudent(id,studentDTO);
    }

    @DeleteMapping(value = "/student/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Student deleteStudant(@PathVariable("id") long id) {
        return coordinatorService.deleteStudent(id);
    }

    @PostMapping("/professor/")
    @ResponseStatus(HttpStatus.CREATED)
    public Professor registerProfessor(@RequestBody ProfessorDTO professorDTO) {
        return coordinatorService.registerProfessor(professorDTO);
    }

    @PutMapping(value = "/professor/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Professor updateProfessor(@PathVariable("id") long id,@RequestBody ProfessorDTO professorDTO) {
        return coordinatorService.updateProfessor(id, professorDTO);
    }

    @DeleteMapping(value = "/professor/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Professor deleteProfessor(@PathVariable("id") long id) {
        return coordinatorService.deleteProfessor(id);
    }

    @PostMapping("/study-area/")
    @ResponseStatus(HttpStatus.CREATED)
    public StudyArea registerStudyArea(@RequestBody String studyAreaName) {
        return studyAreaService.registerStudyArea(studyAreaName);
    }

    @PostMapping(value = "/orientation")
    @ResponseStatus(HttpStatus.CREATED)
    public Orientation registerStudent(@RequestBody OrientationDTO orientationDTO) {

        return coordinatorService.registerOrientation(orientationDTO.getIdStudent(),orientationDTO.getIdProfessor(), orientationDTO.getIdTccTheme(), orientationDTO.getPeriodo());
    }
    @GetMapping(value = "/reports")
    @ResponseStatus(HttpStatus.CREATED)
    public String listReports(){
        return coordinatorService.listReports();
    }

    @PutMapping(value = "/orientation/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Orientation concludesOrientation(@PathVariable("id") long orientationId, @RequestBody String period) {
        return this.coordinatorService.concludesOrientation(orientationId, period);
    }

}
