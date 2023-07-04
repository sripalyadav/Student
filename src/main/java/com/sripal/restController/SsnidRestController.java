package com.sripal.restController;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.sripal.Entity.SsnidEntity;
import com.sripal.Service.SsnidServiceimpl;

@RestController

public class SsnidRestController {
	
	@Autowired
	private SsnidServiceimpl ssnimpl;
	
	@GetMapping("/Home")
    public ResponseEntity<String> handle_home_page() {
		
		String str="Welcome to the App";
		
    	return new ResponseEntity<String>(str, HttpStatus.OK);
	}
	
	@GetMapping("/success")
    public ResponseEntity<String> handle_success_page() {
		
		String str="Welcome to the App";
		
    	return new ResponseEntity<String>(str, HttpStatus.OK);
	}
	
	
	@PostMapping("/save")
	public ResponseEntity<SsnidEntity> handle_Save_method(@Valid @RequestBody SsnidEntity ssnidEntity){
		
		return new ResponseEntity<SsnidEntity>(ssnimpl.save(ssnidEntity), HttpStatus.OK);
		
	}
	
	@GetMapping("/get/{ssnid}")
	public ResponseEntity<SsnidEntity> handle_finbyId_method(@PathVariable("ssnid")String ssnid){
		
		return new ResponseEntity<SsnidEntity>(ssnimpl.findbyid(ssnid), HttpStatus.OK);
		
   }
	@GetMapping("/findAll")
	public ResponseEntity<List<SsnidEntity>> handle_FindAll_method(SsnidEntity ssnidEntity){
		
		return new ResponseEntity<List<SsnidEntity>>(ssnimpl.findall(), HttpStatus.OK);
	}
	
	@PutMapping("/update/{ssnid}")
	public ResponseEntity<SsnidEntity> handle_update_method(@Valid @PathVariable("Ssnid") String Ssnid,SsnidEntity ssnidEntity){
		
		return new ResponseEntity<SsnidEntity>(ssnimpl.upadtebyid(Ssnid, ssnidEntity), HttpStatus.OK);
	}
	
	@DeleteMapping("/delete/{ssnid}")
	public ResponseEntity<String> handle_Delete_method(@PathVariable("ssnid")String ssnid){
		ssnimpl.deletebyid(ssnid);
		return new ResponseEntity<String>("deleted Successfully", HttpStatus.OK);
	}
	@DeleteMapping("/deleteAll")
	public ResponseEntity<String> handle_DeleteAll_method(SsnidEntity ssnidEntity){
		ssnimpl.deleteall(ssnidEntity);
		
		return new ResponseEntity<>(HttpStatus.OK);
   }
	
	@GetMapping("/findby/{Email}")
	public ResponseEntity<SsnidEntity> handle_Email_method(@PathVariable("Email")String Email){
		
		return new ResponseEntity<SsnidEntity>(ssnimpl.findByEmail(Email), HttpStatus.OK);
		
   }
	@GetMapping("/getUser/{Name}")
	public ResponseEntity<SsnidEntity> handle_finbyId_Name_method(@PathVariable("Name")String Name){
		
		return new ResponseEntity<SsnidEntity>(ssnimpl.findByName(Name), HttpStatus.OK);
		
   }
	
	@PostMapping("/saveAll")
		public ResponseEntity<List<SsnidEntity>> handle_saveAll_methode(@RequestBody List<SsnidEntity> lssnidEntity){
			
		return new ResponseEntity<List<SsnidEntity>>(ssnimpl.saveAll(lssnidEntity), HttpStatus.OK);
			
		}
	
}
