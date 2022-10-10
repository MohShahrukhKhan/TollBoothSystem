package com.masai.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.masai.model.TollToken;
import com.masai.repository.TolltokenDAO;

@Service
public class TollTokenServiceImp implements TollTokenService{
	@Autowired
	private TolltokenDAO  tolltokenDAO;

	@Override
	public TollToken saveToken(TollToken tolltoken) {
		// TODO Auto-generated method stub
		return tolltokenDAO.save(tolltoken);
	}

	@Override
	public TollToken updateTollToken(TollToken tollToken) {
		// TODO Auto-generated method stub
		return tolltokenDAO.save(tollToken);
	}

	@Override
	public List<TollToken> getAllTollToken() {
		// TODO Auto-generated method stub
		return tolltokenDAO.findAll();
	}

}
