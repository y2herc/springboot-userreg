package com.hbokhari.demo.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Entity
@Table(name="Userdb")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    
    @NotNull	
    @Size(min=5,max=12)
    @Pattern(regexp = "[A-Za-z0-9]+$",message="must be alphanumeric")
    @Column(name="user_name")
    private String name;
	
	@NotNull	
	@Pattern(regexp = "^(?=.*?[A-Z])(?=.*?[a-z])(?=.*?[0-9]).{8,}$",message="Atleast 1: Number, Uppercase, LowerCase and Atleast 8 Characters ")
	@Column(name="user_pass")
	private String password;


public User(){
	
}

public User(String userName,String Password){
	this.name=userName;
	this.password=Password;
}


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
public Long getId() {
    return id;
}

public void setId(Long id) {
    this.id = id;
}
@Override
public String toString() {
	return "User [name=" + name + ", password=" + password + "]";
}
	

}