package com.revature.models;

import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * This is a persistent class meaning we need to provide a no-args constructor,
 *  a PK, getters & setters, hasCode & equals
 * 
 *
 */

@Entity
@Table(name="employees") // these annotations come from the JPA(that's specification)
public class Employee {
	
	private int id;
	
	private String firstName;
	
	private String lastName;
	
	private String username;
	
	private String password;

	public Employee() {
		super();
	}

	public Employee(int id, String firstName, String lastName, String username, String password) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.username = username;
		this.password = password;
	}

	public Employee(String firstName, String lastName, String username, String password) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.username = username;
		this.password = password;
	}
	
	
	
	
	

}
