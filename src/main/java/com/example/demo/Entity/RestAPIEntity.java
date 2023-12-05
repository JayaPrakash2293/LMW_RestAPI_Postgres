package com.example.demo.Entity;

import java.sql.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity
@Data
@Table(name= "WORKORDERHEADER")
@NoArgsConstructor
@AllArgsConstructor
public class RestAPIEntity {
	
	@Id
	@Column(name="ID")
	@GeneratedValue
	private int id;
	
	@Column(name="WORK_ORDER")
	private int work;
	

	@Column(name="ITEM_NAME")
	private String item;
	
	@Column(name="WORK_ORDER_TYPE")
	private String wotype;
	
	@Column(name="PLANNED_START_DATE")
	private String plnstrdate;
	
	@Column(name="PLANNED_END_DATE")
	private String plnenddate;
}
