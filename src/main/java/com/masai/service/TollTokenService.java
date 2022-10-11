package com.masai.service;

import java.util.List;

import com.masai.exception.VehicleOwnerException;
import com.masai.exception.ownerNotFoundException;
import com.masai.model.TollToken;

public interface TollTokenService {
	public TollToken saveToken(TollToken tolltoken)throws VehicleOwnerException;
    public List<TollToken> getAllTollToken();

}
