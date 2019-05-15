package com.knoldus.knolbucks.model;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.ToString;
import lombok.experimental.FieldDefaults;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.format.annotation.DateTimeFormat;

@Getter
@Document
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
@Builder(toBuilder = true)
@AllArgsConstructor
@ToString
public class User {

    @Id
	Integer id;

	String name;

	String email;

	@JsonFormat(pattern = "yyyy-MM-dd")
	Date dateOfBirth;

	RoleEnum role;

	Boolean active;

	String employeeId;

}
