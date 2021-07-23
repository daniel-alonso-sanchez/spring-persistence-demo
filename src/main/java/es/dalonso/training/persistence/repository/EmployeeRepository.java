package es.dalonso.training.persistence.repository;


import es.dalonso.training.persistence.model.Employee;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepository extends CrudRepository<Employee,Long> {
	public Employee readEmployeeByAlias(String alias);
	@Query("select s from Employee s where s.alias like %:alias")
	public Employee findEmployeeWithCustomQuery(@Param("alias") String alias);
}
