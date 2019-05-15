package com.knoldus.knolbucks.model.dbModels;

import com.knoldus.knolbucks.model.RoleEnum;
import com.knoldus.knolbucks.utils.DateUtils;

import java.util.Date;
/**
 * 
 * @author meghna
 *
 */
public class Users {

	private static RoleEnum getEnum(String role){
		return RoleEnum.valueOf(role);
	}
	
	private String id;
	
	private String name;
	
	private String email;
	
	private Date dateOfBirth;
	
	private RoleEnum role;
	
	private Boolean active = true;

	private String empId;

	public String getId() {
		return id;
	}

	/**
	 *
	 * To Do right now we are providing
	 * id but may be not in future
	 *
	 */
	public Users(String id,String empId, String name, String email, String dateOfBirth,String role){
		this.id = id;
		this.name = name;
		this.email = email;
		this.role = RoleEnum.ADMIN;
		this.dateOfBirth = DateUtils.formatData(dateOfBirth);
		this.empId = empId;
	}

	public Users setId(String id) {
		this.id = id;
		return this;
	}

	public String getName() {
		return name;
	}

	public Users setName(String name) {
		this.name = name;
		return this;
	}

	public String getEmail() {
		return email;
	}

	public Users setEmail(String email) {
		this.email = email;
		return this;
	}

	public Date getDateOfBirth() {
		return dateOfBirth;
	}

	public Users setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
		return this;
	}

	public RoleEnum getRole() {
		return role;
	}

	public Users setRole(RoleEnum role) {
		this.role = role;
		return this;
	}

	public Boolean getActive() {
		return active;
	}

	public Users setActive(Boolean active) {
		this.active = active;
		return this;
	}
	
}
