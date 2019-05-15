package com.knoldus.knolbucks.model;

import java.util.Date;

import lombok.*;
import lombok.experimental.FieldDefaults;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Getter
@Document
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
@Builder(toBuilder = true)
@AllArgsConstructor
@ToString
public class User {

    @Id
	ObjectId id;

	String name;

	String email;

	String dateOfBirth;

	RoleEnum role;

	Boolean active;

	String employeeId;

}
