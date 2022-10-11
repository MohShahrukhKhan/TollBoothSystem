package com.masai.service;

import java.util.List;

import com.masai.model.TollToken;

public interface TollTokenService {
	public TollToken saveToken(TollToken tolltoken);
    public List<TollToken> getAllTollToken();

}
