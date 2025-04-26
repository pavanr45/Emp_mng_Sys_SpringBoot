package com.pr.controller;  // Package declaration for organizing the controller class

import org.springframework.beans.factory.annotation.Autowired;  // Enables automatic dependency injection
import org.springframework.web.bind.annotation.*;  // Imports all required Spring MVC annotations
import com.pr.entity.Employee;  // Imports the Employee entity class
import com.pr.service.EmployeeService;  // Imports the EmployeeService class to handle business logic
import java.util.List;  // Imports List for handling multiple Employee objects

/**
 * EmployeeController is a RESTful controller that handles HTTP requests 
 * related to Employee operations.
 */
@RestController  // Marks this class as a REST controller, meaning it handles web requests and returns JSON responses
@RequestMapping("/employees")  // Ensures all endpoints in this controller start with "/employees"
public class EmployeeController {

    @Autowired  // Spring will automatically inject an instance of EmployeeService
    private EmployeeService service;

    /**
     * Endpoint to check if the login is successful.
     * @return A success message
     */
    //http://localhost:8080/employees/get-login
    @GetMapping("/get-login")
    public String login() {
        System.out.println("Login Successful...");
        return "Login successful";
    }

    /**
     * Retrieves a single employee.
     * @return Employee object
     */
    // http://localhost:8080/employees/get-employee/1
    @GetMapping("/get-employee/{id}")
    public Employee getEmployee( @PathVariable int id) {
        return service.getEmployee(id);  // Calls the service method to fetch an employee
    }

    /**
     * Retrieves a list of employees.
     * @return List of Employee objects
     */
    @GetMapping("/get-employee-list")
    public List<Employee> getEmployeeListSample() {
        return service.getEmployeeList();  // Calls the service method to fetch all employees
    }

    /**
     * Inserts a new employee into the database.
     * @param employee The employee object sent in the request body
     */
    //http://localhost:8080/employees/insert-Employee
    @PostMapping("/insert-employee")
    public void insertEmployee(@RequestBody Employee employee) {
        System.out.println("API-insertEmployee calling ...");
        System.out.println(employee);
        service.insertEmployee(employee);  // Calls the service method to insert an employee
    }

    /**
     * Inserts multiple employees into the database.
     * @param employeeList List of employees sent in the request body
     */
    @PostMapping("/insert-employee-list")
    public void insertEmployeeList(@RequestBody List<Employee> employeeList) {
        System.out.println("API-insertEmployeeList calling ...");
        service.insertEmployeeList(employeeList);  // Calls the service method to insert multiple employees
    }
    
    //update 
    //http://localhost:8080/employees/update-employee/1/85000.0
    @PutMapping("/update-employee/{id}/{salary}")
    public String updateEmployeeSalary(@PathVariable int id, @PathVariable double salary) {
        boolean updated = service.updateEmployeeSalary(id, salary);
        return updated ? "Salary updated successfully!" : "Employee not found!";
    }

    // delete 
    
    @DeleteMapping("/delete-employee/{id}")
    public String deleteEmployee(@PathVariable int id) {
        boolean deleted = service.deleteEmployeeById(id);
        return deleted ? "Employee deleted successfully!" : "Employee not found!";
    }

}
