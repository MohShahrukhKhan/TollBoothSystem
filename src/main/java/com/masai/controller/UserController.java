package com.masai.controller;

import org.springframework.beans.factory.annotation.Autowired;
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
	public VehicleOwner getVehicleOwnerHandle(@PathVariable("RFID") Integer RFID) {
		return vehicleOwnerService.getVehicleOwner(RFID);
		
	}
	@PostMapping("/saveUser")
	public VehicleOwner saveVehicleOwnerHandler(@RequestBody VehicleOwner vehicleOwner) {
		return vehicleOwnerService.saveVehicleOwner(vehicleOwner);
	}
	
	@PutMapping("/updateUser")
	public VehicleOwner updateVehicleOwnerHandler(@RequestBody VehicleOwner vehicleOwner) {
		return vehicleOwnerService.updateVehicleOwnerByID(vehicleOwner);
	}
	
	@DeleteMapping("/deleteUser/{RFID}")
	public VehicleOwner deleteVehicleOwnerHandler(@PathVariable("RFID") Integer RFID ) {
		return vehicleOwnerService.deleteVehicleOwnerById(RFID);
	}

}
