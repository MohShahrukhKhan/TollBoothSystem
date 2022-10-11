package com.masai.service;

import com.masai.model.VehicleOwner;

public interface VehicleOwnerService {
	public VehicleOwner saveVehicleOwner(VehicleOwner vehicleOwner);
	public VehicleOwner updateVehicleOwnerByID(VehicleOwner vehicleOwner);
	public VehicleOwner deleteVehicleOwnerById(Integer id);
    public VehicleOwner getVehicleOwner(Integer id);
}
