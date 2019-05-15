package com.knoldus.knolbucks.model;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.experimental.FieldDefaults;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

@Document
@Getter
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
@Builder(toBuilder = true)
@AllArgsConstructor
public class User {

    @Id
    ObjectId id;

    String name;

    String email;

    String dateOfBirth;

    RoleEnum role;

    Boolean active;

    Integer employeeId;
}
