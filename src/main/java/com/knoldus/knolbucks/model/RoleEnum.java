package com.knoldus.knolbucks.model;
/**
 * 
 * @author meghna
 *
 */
public enum RoleEnum {

	
	ADMIN("Admin"),

	EMPLOYEE("Employee"),

	FINANCE("Finance"),

	HR("HR");
	
	private String role;
	
	RoleEnum(String role)
	{
		this.role = role;
	}


	public RoleEnum valueOfRole(String role)
	{
		for(RoleEnum r: RoleEnum.values())
		{
			if(role.equals(r.role))
			{
				return r;
			}
		}
		return null;
	}
	
}
