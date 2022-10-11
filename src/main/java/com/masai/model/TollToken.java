package com.masai.model;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class TollToken {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer token_Id;
	private LocalDateTime localDateTime;
	private double charge;
	private String vehicleType;
	private String booth_location;
	private Integer tollBooth_No;
	private Integer RFID;
//    
//	@ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.PERSIST)
//	private List<VehicleOwner> vehicleOwner =new ArrayList<>();
//	

	

}
