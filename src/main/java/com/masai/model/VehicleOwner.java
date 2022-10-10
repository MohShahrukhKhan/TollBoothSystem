package com.masai.model;

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
public class VehicleOwner {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer Owner_Id;
	private String OwnerName;
	private String moblieNo;
	private String vehicleType;
	private double wallet;
	
	@ManyToMany(mappedBy = "vehicleOwner", cascade = CascadeType.PERSIST, fetch = FetchType.EAGER)
	private List<TollToken> tolltoken =new ArrayList<>();
	

}
