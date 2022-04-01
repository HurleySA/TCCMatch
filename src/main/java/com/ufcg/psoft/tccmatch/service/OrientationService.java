package com.ufcg.psoft.tccmatch.service;

import com.ufcg.psoft.tccmatch.entity.Orientation;
import com.ufcg.psoft.tccmatch.entity.RequestOrientation;

import java.util.List;

public interface OrientationService {

    Orientation getOrientationById(long id);

    void saveExistedOrientation(Orientation orientation);

    Orientation createOrientation(long idStudent, long idProfessor, long idTccTheme, String period);

    String requestOrientation(long idStudent, long idProfessor, long idTccTheme);

    List<Orientation> getOrientationByProfessorId(long id);

    Orientation concludesOrientation(long orientationId, String period);
}
