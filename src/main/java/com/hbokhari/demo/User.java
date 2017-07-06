package com.hbokhari.demo;

import javax.validation.constraints.Digits;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

public class User {

@NotNull	
@Size(min=5,max=12)
@Pattern(regexp = "[A-Za-z0-9]+$",message="must be alphanumeric")
private String name;

@NotNull	
@Pattern(regexp = "^(?=.*?[A-Z])(?=.*?[a-z])(?=.*?[0-9]).{8,}$",message="Atleast 1: Number, Uppercase, LowerCase and Atleast 8 Characters ")
private String password;

public String getName() {
	return name;
}

public void setName(String name) {
	this.name = name;
}

public String getPassword() {
	return password;
}

public void setPassword(String password) {
	this.password = password;
}

@Override
public String toString() {
	return "User [name=" + name + ", password=" + password + "]";
}
	

}
