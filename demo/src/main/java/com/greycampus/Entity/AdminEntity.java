package com.greycampus.Entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "atb")
public class AdminEntity {

	@Transient
	public static final String SEQUENCE_NAME = "user_sequence";

	@Id
	private int id;
	private String lookupvalue;
	private String body;

}
