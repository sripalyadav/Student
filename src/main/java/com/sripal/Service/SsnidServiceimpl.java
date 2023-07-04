package com.sripal.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sripal.Entity.SsnidEntity;
import com.sripal.Exception.NoDatafoundException;
import com.sripal.repository.SsnidRepository;
@Service

public class SsnidServiceimpl implements SsnidService {
	
	@Autowired
	private SsnidRepository ssnRepo;

	@Override
	public SsnidEntity save(SsnidEntity ssnidEntity) {
		
	
		return ssnRepo.save(ssnidEntity);
	}

	@Override
	public SsnidEntity findbyid(String ssnid){
		return ssnRepo.findById(ssnid).orElseThrow(() -> new NoDatafoundException("there is no datafound with given id"+ssnid));
		
	}

	@Override
	public SsnidEntity upadtebyid(String ssnid, SsnidEntity ssnidEntity){
		
		
		
		 SsnidEntity existssnId = ssnRepo.findById(ssnid).orElseThrow(()-> new NoDatafoundException("there is no id exist with given"+ssnid));

		 existssnId.setName(ssnidEntity.getName());
		 existssnId.setAge(ssnidEntity.getAge());
		 existssnId.setGender(ssnidEntity.getGender());
		 existssnId.setDob(ssnidEntity.getDob());
		 existssnId.setEmail(ssnidEntity.getEmail());
		 existssnId.setPassword(ssnidEntity.getPassword());
		 existssnId.setMobile(ssnidEntity.getMobile());
		 existssnId.setAddress(ssnidEntity.getAddress());
		 
		 ssnRepo.save(ssnidEntity);
		 
		 return existssnId;
	}

	@Override
	public void deletebyid(String ssnid){
		
	ssnRepo.deleteById(ssnid);
		 
	}

	@Override
	public List<SsnidEntity> findall() {
		
		List<SsnidEntity> findAll = ssnRepo.findAll();
		
		if (findAll.isEmpty()) {
			
			throw new NoDatafoundException("there is no data Exist");
			
		}
		
		return findAll;
	}

	@Override
	public SsnidEntity findByEmail(String Email){

		
		return ssnRepo.findByEmail(Email).orElseThrow(()-> new NoDatafoundException(" there is no ssnid id existed with this"+Email));
	}

	@Override
	public SsnidEntity findByName(String Name) throws NoDatafoundException {

		return ssnRepo.findByName(Name).orElseThrow(()-> new NoDatafoundException("no data found with this name"+Name));
		
	}

	@Override
	public void deleteall(SsnidEntity ssnidEntity) {
		ssnRepo.deleteAll();
		
	}



	@Override
	public List<SsnidEntity> saveAll(List<SsnidEntity> ssnidEntity) {
		List<SsnidEntity> saveAll = ssnRepo.saveAll(ssnidEntity);
		
		return saveAll;
	}

	@Override
	public SsnidEntity FindByName(String name) {
		
		return ssnRepo.FindByName(name).orElseThrow(() -> new NoDatafoundException("hello"));
		
	
	}


}
