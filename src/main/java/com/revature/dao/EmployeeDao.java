package com.revature.dao;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.revature.models.Employee;
import com.revature.util.HibernateUtil;

public class EmployeeDao {
	
	//CRUD methods
	
	//Create (think that in the service layer we'll have a REGISTER()
	
	public int insert(Employee e) {
		
		//grab the session object
		Session ses = HibernateUtil.getSession();
		
		//begin a tx
		Transaction tx = ses.beginTransaction();
		
		int pk =(int) ses.save(e);
		
	}
	
	//Read

}
