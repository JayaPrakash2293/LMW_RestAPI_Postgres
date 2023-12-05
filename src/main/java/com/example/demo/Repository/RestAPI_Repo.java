package com.example.demo.Repository;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.demo.Entity.RestAPIEntity;

public interface RestAPI_Repo extends JpaRepository<RestAPIEntity, Serializable> {

	List<RestAPIEntity> findByItem(String item);
	
	RestAPIEntity findByWork(int work);
}
