package com.qa.persistence.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.qa.persistence.model.Team;

public interface TeamRepository extends JpaRepository<Team, Long>{

}
