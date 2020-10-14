package com.galaxe.sonarQube.repository;

import java.sql.Timestamp;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import com.galaxe.sonarQube.entity.SonarqubeEntity;

@org.springframework.stereotype.Repository
public interface SonarRepository  extends JpaRepository<SonarqubeEntity, Integer>{

	@Query("from SonarqubeEntity s WHERE s.date BETWEEN ?1 AND ?2")
	//@Query("from IssueComments e where e.prId=?1")
	List<SonarqubeEntity> findByPriorityBetween(Timestamp timestamp, Timestamp timestamp2);

}
