package com.pr.service;  // Package declaration for organizing the service class

import java.util.List;  // Import List to handle multiple Employee objects
import org.springframework.beans.factory.annotation.Autowired;  // Enables automatic dependency injection
import org.springframework.stereotype.Service;  // Marks this class as a service component
import com.pr.dao.EmployeeDao;  // Imports the EmployeeDao interface for database operations
import com.pr.entity.Employee;  // Imports the Employee entity class

/**
 * EmployeeService is responsible for handling business logic 
 * related to Employee operations.
 */
@Service  // Marks this class as a service component, making it eligible for Spring's component scanning
public class EmployeeService {
    
    @Autowired  // Spring automatically injects an instance of EmployeeDao
    private EmployeeDao dao;

    /**
     * Retrieves a single employee from the database.
     * @return Employee object
     */
    public Employee getEmployee() {
        return dao.getEmployee();  // Calls DAO method to fetch an employee
    }

    /**
     * Retrieves a list of all employees.
     * @return List of Employee objects
     */
    public List<Employee> getEmployeeList() {
        return dao.getEmployeeList();  // Calls DAO method to fetch all employees
    }

    /**
     * Inserts a new employee into the database.
     * @param employee The Employee object to be inserted
     */
    public void insertEmployee(Employee employee) {
        dao.insertEmployee(employee);  // Calls DAO method to insert an employee
    }

    /**
     * Inserts a list of employees into the database.
     * @param employeeList List of Employee objects to be inserted
     */
    public void insertEmployeeList(List<Employee> employeeList) {
        dao.insertEmployeeList(employeeList);  // Calls DAO method to insert multiple employees
    }

	public Employee getEmployee(int id) {
		
		return dao.getEmployee(id);
	}
	
	public boolean updateEmployeeSalary(int id, double salary) {
	    return dao.updateEmployeeSalary(id, salary);
	}

	public boolean deleteEmployeeById(int id) {
	    return dao.deleteEmployeeById(id);
	}

}
