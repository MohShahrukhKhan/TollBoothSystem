package com.masai.controller;

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

import com.masai.model.VehicleOwner;
import com.masai.service.VehicleOwnerService;

@RestController
public class UserController {
	
	@Autowired
	private VehicleOwnerService vehicleOwnerService;
	
	@GetMapping("/getUser/{RFID}")
	public ResponseEntity<VehicleOwner> getVehicleOwnerHandle(@PathVariable("RFID") Integer RFID) {
		return new ResponseEntity<>(vehicleOwnerService.getVehicleOwner(RFID), HttpStatus.ACCEPTED);

	}
	@PostMapping("/saveUser")
	public ResponseEntity<VehicleOwner> saveVehicleOwnerHandler(@RequestBody VehicleOwner vehicleOwner) {
		return new ResponseEntity<>(vehicleOwnerService.saveVehicleOwner(vehicleOwner), HttpStatus.CREATED);
	
	}
	
	@PutMapping("/updateUser")
	public VehicleOwner updateVehicleOwnerHandler(@RequestBody VehicleOwner vehicleOwner) {
		return vehicleOwnerService.updateVehicleOwnerByID(vehicleOwner);
	}
	
	@DeleteMapping("/deleteUser/{RFID}")
	public ResponseEntity<VehicleOwner> deleteVehicleOwnerHandler(@PathVariable("RFID") Integer RFID ) {
		return new ResponseEntity<>(vehicleOwnerService.deleteVehicleOwnerById(RFID), HttpStatus.ACCEPTED);
	}

}
