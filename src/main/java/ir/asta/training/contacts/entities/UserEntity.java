package ir.asta.training.contacts.entities;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(name="UserEntity")
public class UserEntity {
	String name;
	String username;
	String pass;
	String role;
	String verified;


	@Basic
	@Column(name="NAME_")
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

	@Id
	@Basic
	@NotNull
	@Column(name="USERNAME_")
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}

	@Basic
	@Column(name="PASS_")
	public String getPass() {
		return pass;
	}
	public void setPass(String pass) {
		this.pass = pass;
	}

	@Basic
	@Column(name="ROLE_")
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}

	@Basic
	@Column(name="VERIFIED_")
	public String getVerified() {
		return verified;
	}
	public void setVerified(String verified) {
		this.verified = verified;
	}

}
