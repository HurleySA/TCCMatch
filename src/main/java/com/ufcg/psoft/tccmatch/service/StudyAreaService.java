package com.ufcg.psoft.tccmatch.service;

import com.ufcg.psoft.tccmatch.entity.Professor;
import com.ufcg.psoft.tccmatch.entity.StudyArea;
import org.springframework.stereotype.Service;

public interface StudyAreaService {
    StudyArea registerStudyArea(String studyAreaName);

    StudyArea getStudyAreaByName(String studyAreaName);
}
