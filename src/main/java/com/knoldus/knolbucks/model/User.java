package com.knoldus.knolbucks.model;

import java.util.Date;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
/**
 * 
 * @author meghna
 *
 */
@Getter @Setter @NoArgsConstructor
public class User {
	
	private Long id;
	
	private String name;
	
	private String email;
	
	private Date dateOfBirth;
	
	private RoleEnum role;
	
	private Boolean active;

	private String userId;
	
}
