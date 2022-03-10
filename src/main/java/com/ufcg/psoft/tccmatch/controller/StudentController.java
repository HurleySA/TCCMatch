package com.ufcg.psoft.tccmatch.controller;

import com.ufcg.psoft.tccmatch.entity.Student;
import com.ufcg.psoft.tccmatch.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping(value = "api/student")
public class StudentController {

    @Autowired
    StudentService studentService;

    @PostMapping(value = "/{id}/study-area/")
    @ResponseStatus(HttpStatus.OK)
    public Student addStudyArea(@PathVariable("id") long id, @RequestBody String studyAreaName){
        return studentService.addStudyArea(id, studyAreaName);
    }
}
