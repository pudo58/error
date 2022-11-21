package com.insmart.app.model;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigInteger;


/**
 * The persistent class for the permissions database table.
 * 
 */
@Entity
@Table(name="permissions")
@NamedQuery(name="Permission.findAll", query="SELECT p FROM Permission p")
public class Permission implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="permission_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long permissionId;
	@Column(name="edit")
	private Boolean edit;

	@Column(name="resource_id")
	private Long resourceId;

	@Column(name="user_id")
	private Long userId;

	@Column(name="view")
	private Boolean view;

	public Permission() {
	}

	public long getPermissionId() {
		return this.permissionId;
	}

	public void setPermissionId(long permissionId) {
		this.permissionId = permissionId;
	}

	public boolean getEdit() {
		return this.edit;
	}

	public void setEdit(Boolean edit) {
		this.edit = edit;
	}

	public Long getResourceId() {
		return this.resourceId;
	}

	public void setResourceId(Long resourceId) {
		this.resourceId = resourceId;
	}

	public Long getUserId() {
		return this.userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public Boolean getView() {
		return this.view;
	}

	public void setView(Boolean view) {
		this.view = view;
	}

}