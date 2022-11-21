package com.insmart.app.model;

import org.hibernate.annotations.GeneratorType;

import java.io.Serializable;
import javax.persistence.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


/**
 * The persistent class for the organizations database table.
 * 
 */
@Entity
@Table(name="organizations")
@NamedQuery(name="Organization.findAll", query="SELECT o FROM Organization o")
public class Organization implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="ora_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long oraId;

	@Column(name = "code")
	private String code;
	@Column(name = "description")
	@Lob
	private String description;
	@Column(name = "name")
	@Lob
	private String name;


	@Column(name = "orders")
	private Integer orders;

	@ManyToOne
	@JoinColumn(name="parent_id")
	private Organization organization;

	@ManyToMany(mappedBy="organizations")
	private List<User> users = new ArrayList<>();

	public Organization() {
	}

	public long getOraId() {
		return this.oraId;
	}

	public void setOraId(long oraId) {
		this.oraId = oraId;
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

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getOrders() {
		return this.orders;
	}

	public void setOrders(Integer orders) {
		this.orders = orders;
	}

	public Organization getOrganization() {
		return this.organization;
	}

	public void setOrganization(Organization organization) {
		this.organization = organization;
	}

	public List<User> getUsers() {
		return this.users;
	}
}