package com.insmart.app.model;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.io.Serializable;
import java.util.*;
import javax.persistence.*;


/**
 * The persistent class for the users database table.
 * 
 */
@Entity
@Table(name="users")
@NamedQuery(name="User.findAll", query="SELECT u FROM User u")
public class User implements Serializable, UserDetails,GrantedAuthority {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="user_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long userId;

	@Column(name = "code")
	private String code;
	@Column(name = "description")
	private String description;
	@Column(name = "email")
	private String email;
	@Column(name = "name")
	@Lob
	private String name;

	@Column(name = "password")
	private String password;

	@Column(name = "username")
	private String username;

	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(name = "zones", joinColumns = {
			@JoinColumn(name = "user_id",nullable = false,updatable = false) },
			inverseJoinColumns = { @JoinColumn(name = "ora_id",nullable = false,updatable = false)

	})
	private List<Organization> organizations = new ArrayList<>();
	public User() {
	}

	public List<Organization> getOrganizations() {
		return organizations;
	}

	public void setOrganizations(List<Organization> organizations) {
		this.organizations = organizations;
	}

	public long getUserId() {
		return this.userId;
	}

	public void setUserId(long userId) {
		this.userId = userId;
	}

	public String getCode() {
		return this.code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getUsername() {
		return this.username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return (Collection<? extends GrantedAuthority>) getOrganizations();
	}

	@Override
	public boolean isAccountNonExpired() {
		return false;
	}

	@Override
	public boolean isAccountNonLocked() {
		return false;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return false;
	}

	@Override
	public boolean isEnabled() {
		return false;
	}

	@Override
	public String getAuthority() {
		return "ADMIN";
	}
}