package com.ufcg.psoft.tccmatch.repository;

import com.ufcg.psoft.tccmatch.entity.ProposalTCCTheme;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProposalTCCThemeRepository extends JpaRepository<ProposalTCCTheme, Long> {

    List<ProposalTCCTheme> findByTitle(String title);

}
