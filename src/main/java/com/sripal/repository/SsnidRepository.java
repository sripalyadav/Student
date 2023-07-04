package com.sripal.repository;

import java.io.Serializable;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sripal.Entity.SsnidEntity;
@Repository
public interface SsnidRepository extends JpaRepository<SsnidEntity, Serializable> {
	
	Optional<SsnidEntity> findByEmail(String Email);
	Optional<SsnidEntity> findByName(String Name);

	Optional<SsnidEntity> FindByName(String name);
	
}
