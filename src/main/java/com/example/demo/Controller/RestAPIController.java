package com.example.demo.Controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import com.example.demo.Entity.RestAPIEntity;
import com.example.demo.Service.RestAPI_Service;

@RestController
public class RestAPIController {

	@Autowired
	private RestAPI_Service restAPI_Service;
	
	
	@GetMapping("/users")
	public String getUsers() {
		return "displaying the list of user";
	}
	
	@PostMapping("/newrestAPI")
	public ResponseEntity<String> CreateDetails(@RequestBody RestAPIEntity restAPIEntity){
		System.out.println("RestAPIController::CreateDetails");
		String status=restAPI_Service.upsert(restAPIEntity);
		return new ResponseEntity<>(status,HttpStatus.CREATED);
	}
	
	@PostMapping("/newrestAPIDetails")
	public ResponseEntity<List<RestAPIEntity>> CreateAllDetails(@RequestBody List<RestAPIEntity> listrestAPIEntity){
		List<RestAPIEntity> updateall= restAPI_Service.upsertall(listrestAPIEntity);
		return new ResponseEntity<>(updateall, HttpStatus.OK);
	}
	
	@GetMapping("/APIDetail/{id}")
	public ResponseEntity<RestAPIEntity> getDetails(@PathVariable Integer id){
		RestAPIEntity restAPIEntity = restAPI_Service.getById(id);
		return new ResponseEntity<>(restAPIEntity, HttpStatus.OK);
	}
	
	@GetMapping("/APIDetails")
	public ResponseEntity<List<RestAPIEntity>> getAllDetails(){
		List<RestAPIEntity> allDetails= restAPI_Service.getAllDetails();
		return new ResponseEntity<>(allDetails, HttpStatus.OK);
	}
	
	@PutMapping("/restAPI")
	public ResponseEntity<String> updateDetail(@RequestBody RestAPIEntity restAPIEntity){
		String status=restAPI_Service.upsert(restAPIEntity);
		return new ResponseEntity<>(status,HttpStatus.CREATED);
	}
	
	@DeleteMapping("/APIDetail/{id}")
	public ResponseEntity<String> DeleteDetails(@PathVariable Integer id){
		String status = restAPI_Service.DeleteById(id);
		return new ResponseEntity<>(status, HttpStatus.OK);
	}
	
}

