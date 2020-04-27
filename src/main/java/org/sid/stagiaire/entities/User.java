package org.sid.stagiaire.entities;

import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

@Entity
public class User {
	@Id
	private String username;
	private String password;
	private boolean actived;
	@ManyToMany
	@JoinTable(name="USER_ROLE")
	private Collection<Role> roles;
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public boolean isActived() {
		return actived;
	}
	public void setActived(boolean actived) {
		this.actived = actived;
	}
	public User() {
		super();
	}
	public User(String username, String password, boolean actived, Collection<Role> roles) {
		super();
		this.username = username;
		this.password = password;
		this.actived = actived;
		this.roles = roles;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public Collection<Role> getRoles() {
		return roles;
	}
	public void setRoles(Collection<Role> roles) {
		this.roles = roles;
	}
	
	
}
