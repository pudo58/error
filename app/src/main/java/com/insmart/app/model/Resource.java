package com.insmart.app.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


/**
 * The persistent class for the resources database table.
 * 
 */
@Entity
@Table(name="resources")
@NamedQuery(name="Resource.findAll", query="SELECT r FROM Resource r")
public class Resource implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="resource_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long resourceId;
	@Column(name= "code")
	private String code;
	@Column(name= "description")
	private String description;
	@Column(name= "name")
	private String name;
	@Column(name= "orders")
	private Integer order;
	@Column(name= "url")
	private String url;
	@ManyToOne
	@JoinColumn(name="parent_id")
	private Resource resource;

	@OneToMany(mappedBy="resource", cascade = {CascadeType.REMOVE, CascadeType.MERGE})
	private List<Resource> resources;

	@ManyToMany(fetch = FetchType.LAZY,cascade = {CascadeType.PERSIST})
	@JoinTable
	(
		name="previlleges",
		joinColumns={ @JoinColumn(name="resource_id", referencedColumnName="resource_id",
				nullable = false, updatable = false)},
		inverseJoinColumns={ @JoinColumn(name="role_id", referencedColumnName="role_id",
				nullable = false, updatable = false)}
	)
	private Set<Role> roles = new HashSet<>();

	public long getResourceId() {
		return resourceId;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public void setResourceId(long resourceId) {
		this.resourceId = resourceId;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getOrder() {
		return order;
	}

	public void setOrder(Integer order) {
		this.order = order;
	}

	public Resource getResource() {
		return resource;
	}

	public void setResource(Resource resource) {
		this.resource = resource;
	}

	public List<Resource> getResources() {
		return resources;
	}

	public void setResources(List<Resource> resources) {
		this.resources = resources;
	}

	public Set<Role> getRoles() {
		return roles;
	}

	public void setRoles(Set<Role> roles) {
		this.roles = roles;
	}
}