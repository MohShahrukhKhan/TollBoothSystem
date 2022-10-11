package com.masai.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.masai.model.VehicleOwner;

@Repository
public interface VehicleOwnerDAO extends JpaRepository<VehicleOwner, Integer>{
	Optional<VehicleOwner> findByNumberPlate(String numberPlate);

}
