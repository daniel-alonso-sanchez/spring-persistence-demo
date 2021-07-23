package es.dalonso.training.persistence.model;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "Task")
public class Task {
	@Id
	@GeneratedValue
	private Long id;

	@Column(name = "description")
	private String desc;

	@Column(name = "target_date")
	private Date targetDate;

	@Column(name = "is_done")
	private boolean isDone;
	@ManyToMany(mappedBy = "tasks")
	private List<Employee> employees;
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

	public Date getTargetDate() {
		return targetDate;
	}

	public void setTargetDate(Date targetDate) {
		this.targetDate = targetDate;
	}

	public boolean isDone() {
		return isDone;
	}

	public void setDone(boolean isDone) {
		this.isDone = isDone;
	}

	public List<Employee> getEmployees() {
		return employees;
	}

	public void setEmployees(List<Employee> employees) {
		this.employees = employees;
	}

}

