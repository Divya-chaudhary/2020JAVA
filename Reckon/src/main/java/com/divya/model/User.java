package com.divya.model;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.HashMap;
import java.util.Map;
public class User {
    
	public String _id;
    public String name;
    public User() {
		
	}


	public String email;
    public String password;
    public String phonenumber;
   
    
    
    public User(String _id, String name, String email, String password,  String phonenumber,
			String incomesource, String annualincome) {
		super();
		this._id = _id;
		this.name = name;
		this.email = email;
		this.password = password;
		
		this.phonenumber = phonenumber;
		
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		if(name.length()<2) {
			System.out.println("Invalid Name");
		}else {
			this.name = name;
			System.out.println("Name Set");
		}


	}

    public Map toMap() {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("name", name);
		map.put("email", email);
		map.put("password", password);
		
		map.put("phonenumber",phonenumber);
		
		return map;
	}


	@Override
	public String toString() {
		return "User [_id=" + _id + ", name=" + name + ", email=" + email + ", password=" + password + ", phonenumber="
				+ phonenumber + "]";
	}


	

    
}