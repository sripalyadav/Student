package com.sripal.Service;

import java.util.List;
import java.util.Optional;

import com.sripal.Entity.SsnidEntity;

public interface SsnidService{
	
	
	
	SsnidEntity FindByName(String name);
	
	SsnidEntity save(SsnidEntity ssnidEntity);
	SsnidEntity findbyid(String ssnid);
	SsnidEntity upadtebyid(String ssnid,SsnidEntity ssnidEntity);
    void  deletebyid(String ssnid);
	List<SsnidEntity> findall();
	void deleteall(SsnidEntity ssnidEntity);
	
	SsnidEntity findByEmail(String Email);
	SsnidEntity findByName(String Name);
	List<SsnidEntity> saveAll(List<SsnidEntity> ssnidEntity);
}