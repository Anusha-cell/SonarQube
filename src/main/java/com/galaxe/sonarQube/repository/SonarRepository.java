package com.galaxe.sonarQube.repository;

import java.sql.Timestamp;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.galaxe.sonarQube.entity.SonarqubeEntity;

@Repository
public interface SonarRepository  extends JpaRepository<SonarqubeEntity, Integer>{

	@Query("from SonarqubeEntity s WHERE s.date BETWEEN ?1 AND ?2")
	List<SonarqubeEntity> findByPriorityBetween(Timestamp timestamp, Timestamp timestamp2);


	
}
