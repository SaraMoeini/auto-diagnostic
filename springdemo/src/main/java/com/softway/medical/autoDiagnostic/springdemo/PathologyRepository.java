package com.softway.medical.autoDiagnostic.springdemo;

import org.springframework.data.jpa.repository.JpaRepository;

public interface PathologyRepository extends JpaRepository<Pathology, Integer>{
    
} 

