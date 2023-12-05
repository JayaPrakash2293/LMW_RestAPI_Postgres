package com.example.demo.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.Entity.RestAPIEntity;
import com.example.demo.Repository.RestAPI_Repo;

@Service
public class RestAPIServiceImpl implements RestAPI_Service {

	@Autowired
	private RestAPI_Repo restAPI_Repo;
	
	@Override
	public String upsert(RestAPIEntity restAPIEntity) {
		restAPI_Repo.save(restAPIEntity);
		return "success";
	}
	
	@Override
	public List<RestAPIEntity> upsertall(List<RestAPIEntity> listrestAPIEntity) {		
		List<RestAPIEntity> temp = new ArrayList<RestAPIEntity>();
		
		Optional<RestAPIEntity> findByWork = Optional.empty();
		for(RestAPIEntity user: listrestAPIEntity) {
			System.out.println("UserService::Optional::inside for loop");
			//Optional<RestAPIEntity> findById = restAPI_Repo.findById(user.getWork());
			
			System.out.println("UserService::Optional::findById-->"+restAPI_Repo.findByWork(user.getWork()));
			System.out.println("UserService::Optional::findById-->"+user.getWork());
			findByWork = Optional.ofNullable(restAPI_Repo.findByWork(user.getWork()));
			

			//System.out.println("UserService::Optional::db item-->"+restAPI_Repo.findByWorklist(user.getWork()));
		  	System.out.println("UserService::Optional::getItem-->"+user.getItem());
		  	
		  	if(!findByWork.isPresent()) {
				System.out.println("UserService::Optional::inside IF");
				RestAPIEntity tempestapi =new RestAPIEntity();
				tempestapi.setId(user.getId());
				tempestapi.setWork(user.getWork());
				tempestapi.setItem(user.getItem());
				tempestapi.setWotype(user.getWotype());
				tempestapi.setPlnstrdate(user.getPlnstrdate());
				tempestapi.setPlnenddate(user.getPlnenddate());
				temp.add(tempestapi);
				//return restAPI_Repo.findAll();
			}
//		  	else {
//				System.out.println("UserService::Optional::inside else");
//				restAPI_Repo.saveAllAndFlush(listrestAPIEntity);
//			}
		}
		System.out.println("UserService::Optional::inside else");
		restAPI_Repo.saveAll(temp);
		return listrestAPIEntity;
		
	}

	@Override
	public RestAPIEntity getById(Integer id) {
		Optional<RestAPIEntity> findById = restAPI_Repo.findById(id);
		if(findById.isPresent()) {
			return findById.get();
		}
		return null;
	}

	@Override
	public List<RestAPIEntity> getAllDetails() {
		return restAPI_Repo.findAll();
	}

	@Override
	public String DeleteById(Integer id) {
		if(restAPI_Repo.existsById(id)) {
			restAPI_Repo.deleteById(id);
			return "Delete Sucess";
		}else {
			return "No Record Found";
		}
	}

}
