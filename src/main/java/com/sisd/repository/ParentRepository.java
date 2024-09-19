package com.sisd.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sisd.entity.Parent;

public interface ParentRepository extends JpaRepository<Parent, String>{
    
}
