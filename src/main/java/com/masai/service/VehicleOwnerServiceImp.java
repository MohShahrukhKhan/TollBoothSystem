package com.masai.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.masai.exception.VehicleOwnerException;
import com.masai.exception.ownerNotFoundException;
import com.masai.model.VehicleOwner;
import com.masai.repository.VehicleOwnerDAO;
@Service
public class VehicleOwnerServiceImp implements VehicleOwnerService{
	
	@Autowired
	private VehicleOwnerDAO vehicleOwnerDAO;

	@Override
	public VehicleOwner saveVehicleOwner(VehicleOwner vehicleOwner) {
		// TODO Auto-generated method stub
		Optional<VehicleOwner> opt=vehicleOwnerDAO.findByNumberPlate(vehicleOwner.getNumberPlate());
		if(!opt.isPresent()) {
			return vehicleOwnerDAO.save(vehicleOwner);
		}else {
			throw new VehicleOwnerException("Owner already exits!");
		}
		
	}

	@Override
	public VehicleOwner updateVehicleOwnerByID(VehicleOwner vehicleOwner) {
		// TODO Auto-generated method stub
		Optional<VehicleOwner> opt=vehicleOwnerDAO.findByNumberPlate(vehicleOwner.getNumberPlate());
		if(opt.isPresent()) {
			return vehicleOwnerDAO.save(vehicleOwner);
		}else {
			throw new ownerNotFoundException("Onwer Not exits!");
		}
	}

	@Override
	public VehicleOwner deleteVehicleOwnerById(Integer id) {
		Optional<VehicleOwner> opt=vehicleOwnerDAO.findById(id);
		VehicleOwner owner=opt.get();
		if(opt.isPresent()) {
			vehicleOwnerDAO.deleteById(id);
			
		}else {
			throw new ownerNotFoundException("Onwer Not exits!");
		}
		
		return owner;
		
	}

	@Override
	public VehicleOwner getVehicleOwner(Integer id) {
		// TODO Auto-generated method stub
		Optional<VehicleOwner> opt=vehicleOwnerDAO.findById(id);
		if(opt.isPresent()) {
			return opt.get();
		}else {
			throw new ownerNotFoundException("Onwer Not exits!");
		}
		
	}

}
