package com.torrento.timebilling.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.torrento.timebilling.model.Developer;

@Repository
public interface DeveloperRepository extends JpaRepository<Developer, Long>{

}
