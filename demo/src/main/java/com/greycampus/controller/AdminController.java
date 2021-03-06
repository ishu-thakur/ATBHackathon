package com.greycampus.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.greycampus.Entity.AdminEntity;
import com.greycampus.repository.AtbRepository;
import com.greycampus.services.SequenceGeneratorService;

@RestController
public class AdminController {

	@Autowired
	public AtbRepository atbRepository;

	@Autowired
	private SequenceGeneratorService service;

	@PostMapping(value = "/canned-responses", consumes = "application/json")
	public ResponseEntity<?> register(@RequestBody AdminEntity atbEntity) {
		atbEntity.setId(service.getSequenceNumber(AdminEntity.SEQUENCE_NAME));
		AdminEntity insert = atbRepository.insert(atbEntity);
		return new ResponseEntity<AdminEntity>(insert, HttpStatus.OK);
	}

	@GetMapping(value = "/canned-responses")
	public List<AdminEntity> getAll() {
		return atbRepository.findAll();
	}

	@GetMapping(value = "/canned-responses/{id}")
	public Optional<AdminEntity> getById(@RequestParam int id) {
		return atbRepository.findById((long) id);
	}

	@DeleteMapping(value = "/canned-responses")
	public ResponseEntity<String> delete(@RequestParam int id) {
		atbRepository.deleteById((long) id);
		return new ResponseEntity<String>("Data have been deleted", HttpStatus.OK);
	}
}
