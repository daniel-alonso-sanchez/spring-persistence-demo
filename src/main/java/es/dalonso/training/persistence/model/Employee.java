package es.dalonso.training.persistence.model;

import javax.persistence.*;
import java.util.List;

@Entity
public class Employee {
	@Id
	@GeneratedValue
	private Long id;

	@Column(name = "alias")
	private String alias;

	@ManyToMany
	private List<Task> tasks;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getAlias() {
		return alias;
	}

	public void setAlias(String alias) {
		this.alias = alias;
	}

	public List<Task> getTasks() {
		return tasks;
	}

	public void setTasks(List<Task> tasks) {
		this.tasks = tasks;
	}
	
	
}
