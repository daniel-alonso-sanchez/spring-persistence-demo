package es.dalonso.training.persistence.resource;

import es.dalonso.training.persistence.model.Employee;
import es.dalonso.training.persistence.service.IEmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/employees")
public class EmployeeController {
	@Autowired
	private IEmployeeService employeeService;

	@GetMapping("/{alias}")
	public Employee getById(@PathVariable("alias") String alias) {
		Employee article = employeeService.getByAlias(alias);
		return article;
	}

	@GetMapping
	public Iterable<Employee> getAll() {
		Iterable<Employee> list = employeeService.getAll();
		return list;
	}

	@PostMapping
	public Employee addEmployee(@RequestBody Employee element) {
		Employee returned = employeeService.add(element);
		
		return returned;
	}

	@PutMapping
	public Employee update(@RequestBody Employee element) {
		employeeService.update(element);
		return element;
	}

	@DeleteMapping("/{id}")
	public Optional<Void> delete(@PathVariable("id") Long id) {
		employeeService.delete(id);
		return Optional.empty();

	}
}
