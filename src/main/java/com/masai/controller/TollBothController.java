package com.masai.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
	
	@PostMapping("/saveTollToken")
	public ResponseEntity<TollToken> saveTollTokenHandler(@RequestBody TollToken tollToken) {
		return new ResponseEntity<>(tollTokenService.saveToken(tollToken), HttpStatus.CREATED);
	
	}
	
	@GetMapping("/getTollTokens")
	public List<TollToken> getTollTokenHandler(){
		return tollTokenService.getAllTollToken();
	}
	
	
}
