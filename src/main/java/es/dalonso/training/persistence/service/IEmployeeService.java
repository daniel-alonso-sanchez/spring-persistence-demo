package es.dalonso.training.persistence.service;

import es.dalonso.training.persistence.model.Employee;

public interface IEmployeeService extends ICrudService<Long, Employee> {

	Employee getByAlias(String alias);

}
