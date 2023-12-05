package com.example.demo.Service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.Entity.RestAPIEntity;


@Service
public interface RestAPI_Service {

	public String upsert(RestAPIEntity restAPIEntity);
	
	public List<RestAPIEntity>  upsertall(List<RestAPIEntity> listrestAPIEntity);
	
	public RestAPIEntity getById(Integer id);
	
	public List<RestAPIEntity> getAllDetails();
	
	public String DeleteById(Integer id);
	
}
