package com.greycampus.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import com.greycampus.Entity.AdminEntity;

@Repository
public interface AtbRepository extends MongoRepository<AdminEntity, Long> {
	@Query("{lookupvalue :?0}")
	AdminEntity findByName(String lookupvalue);//SQL Equivalent : SELECT * FROM BOOK WHERE lookupvalue=?
}
