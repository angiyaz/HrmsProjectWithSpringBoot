package kodlamaio.hrms.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import kodlamaio.hrms.entities.concretes.Employees;

public interface EmployeeDao extends JpaRepository<Employees, Integer>{

	
}
