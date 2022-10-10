package com.masai.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.masai.model.TollToken;
import com.masai.service.TollTokenService;

@RestController
public class TollBothController {
	@Autowired
	private TollTokenService tollTokenService;
	
	@PostMapping("/save")
	public TollToken saveTollTokenHandler(@RequestBody TollToken tollToken) {
		return tollTokenService.saveToken(tollToken);
	}
	
	@PutMapping("/update/")
	public TollToken updateTollTokenHandler(@RequestBody TollToken tollToken) {
		return tollTokenService.updateTollToken(tollToken);
	}
    
	@GetMapping("/get")
	public List<TollToken> getTollTokenHandler(){
		return tollTokenService.getAllTollToken();
	}
}
