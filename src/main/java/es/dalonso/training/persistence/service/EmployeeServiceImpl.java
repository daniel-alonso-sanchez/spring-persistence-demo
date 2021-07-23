package es.dalonso.training.persistence.service;

import es.dalonso.training.persistence.model.Employee;
import es.dalonso.training.persistence.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public class EmployeeServiceImpl implements IEmployeeService {
	
	private EmployeeRepository employeeDAo;
	@Autowired
	public EmployeeServiceImpl(EmployeeRepository employeeDAo) {
		super();
		this.employeeDAo = employeeDAo;
	}

	@Override
	@Transactional(readOnly=true)
	public Iterable<Employee> getAll() {
		
		return employeeDAo.findAll();
	}

	@Override
	@Transactional(readOnly=true)
	public Employee getById(Long key) {
		
		return employeeDAo.findById(key).orElse(null);
	}

	@Override
	@Transactional
	@CacheEvict(value="employees")
	public Employee add(Employee element) {
		employeeDAo.save(element);
		return element;
	}

	@Override
	@Transactional
	@CacheEvict(value="employees")
	public void update(Employee element) {
		Optional<Employee> storedEmployee=employeeDAo.findById(element.getId());
		if (storedEmployee.isPresent()){
			storedEmployee.get().setAlias(element.getAlias());
			//employeeDAo.save(element);
		}

	}

	@Override
	@Transactional
	@CacheEvict(value="employees")
	public void delete(Long key) {
	
		employeeDAo.deleteById(key);
	}

	@Override
	@Transactional(readOnly=true)
	@Cacheable("employees")
	public Employee getByAlias(String alias) {		
		return employeeDAo.findEmployeeWithCustomQuery(alias);
	}

}
