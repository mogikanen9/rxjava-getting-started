package com.mogikanensoftware.rx.vo;

import java.io.Serializable;
import java.util.Date;

public class ToDoItem implements Serializable {

	private static final long serialVersionUID = 1L;

	private long id;
	private String name;
	private String description;
	private Date created;
	private Date updated;
	private ItemStatus status;

	public ToDoItem() {
		super();
	}

	public ToDoItem(long id, String name, String description, Date created, Date updated, ItemStatus status) {
		super();
		this.id = id;
		this.name = name;
		this.description = description;
		this.created = created;
		this.updated = updated;
		this.status = status;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Date getCreated() {
		return created;
	}

	public void setCreated(Date created) {
		this.created = created;
	}

	public Date getUpdated() {
		return updated;
	}

	public void setUpdated(Date updated) {
		this.updated = updated;
	}

	public ItemStatus getStatus() {
		return status;
	}

	public void setStatus(ItemStatus status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "ToDoItem [id=" + id + ", name=" + name + ", description=" + description + ", created=" + created
				+ ", updated=" + updated + ", status=" + status + "]";
	}

}
