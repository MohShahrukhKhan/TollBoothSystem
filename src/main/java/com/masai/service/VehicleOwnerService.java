package com.masai.service;

import com.masai.exception.VehicleOwnerException;
import com.masai.exception.ownerNotFoundException;
import com.masai.model.VehicleOwner;

public interface VehicleOwnerService {
	public VehicleOwner saveVehicleOwner(VehicleOwner vehicleOwner) throws VehicleOwnerException;
	public VehicleOwner updateVehicleOwnerByID(VehicleOwner vehicleOwner)throws ownerNotFoundException;
	public VehicleOwner deleteVehicleOwnerById(Integer id)throws ownerNotFoundException;
    public VehicleOwner getVehicleOwner(Integer id)throws ownerNotFoundException;
}
