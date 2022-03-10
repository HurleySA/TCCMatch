package com.ufcg.psoft.tccmatch.service.impl;

import com.ufcg.psoft.tccmatch.entity.StudyArea;
import com.ufcg.psoft.tccmatch.repository.StudyAreaRepository;
import com.ufcg.psoft.tccmatch.service.StudyAreaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class StudyAreaServiceImpl implements StudyAreaService {

    @Autowired
    StudyAreaRepository studyAreaRepository;

    @Override
    public StudyArea registerStudyArea(String studyAreaName) {
        Optional<StudyArea> opt = studyAreaRepository.findByName(studyAreaName);
        if(!opt.isPresent()){
            StudyArea studyArea = new StudyArea(studyAreaName);
            studyAreaRepository.save(studyArea);
            return studyArea;
        }
        throw new RuntimeException(("Study Area Already exists"));
    }

    @Override
    public StudyArea getStudyAreaByName(String studyAreaName) {
        return studyAreaRepository.findByName(studyAreaName).orElseThrow(() -> new RuntimeException(("Study Area not found.")));
    }
}
