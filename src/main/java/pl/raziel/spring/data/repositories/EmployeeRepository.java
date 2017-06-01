package pl.raziel.spring.data.repositories;

import org.springframework.data.repository.CrudRepository;
import pl.raziel.spring.data.entities.Employee;

public interface EmployeeRepository extends CrudRepository<Employee, Long> {
}
