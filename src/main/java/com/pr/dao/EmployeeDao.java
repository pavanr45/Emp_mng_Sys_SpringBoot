package com.pr.dao;  // Package declaration for organizing DAO classes

import java.util.List;
import org.hibernate.Session;  // Hibernate Session for database transactions
import org.hibernate.SessionFactory;  // Factory to manage Hibernate sessions
import org.springframework.beans.factory.annotation.Autowired;  // Enables automatic dependency injection
import org.springframework.stereotype.Repository;  // Marks this class as a Repository component
import com.pr.entity.Employee;  // Imports Employee entity

/**
 * EmployeeDao is responsible for interacting with the database
 * using Hibernate for CRUD operations on Employee entities.
 */
@Repository  // Marks this class as a Spring-managed DAO component
public class EmployeeDao {

    @Autowired  // Spring automatically injects the SessionFactory instance
    private SessionFactory factory; 

    /**
     * Retrieves a single Employee from the database.
     * @return Employee object (Currently returns null as a placeholder)
     */
    public Employee getEmployee() {
        return null; // Placeholder for future implementation
    }

    /**
     * Retrieves a list of all Employees.
     * @return List of Employee objects (Currently returns null as a placeholder)
     */
    public List<Employee> getEmployeeList() {
        return null; // Placeholder for future implementation
    }

    /**
     * Inserts a single Employee record into the database.
     * @param employee The Employee object to be inserted
     */
    public void insertEmployee(Employee employee) {
        System.out.println("in dao ---factory >> " + factory);

        // Using try-with-resources to automatically close the session
        try (Session session = factory.openSession()) { 
            session.beginTransaction();  // Start a transaction
            session.save(employee);  // Save the employee entity
            session.getTransaction().commit();  // Commit the transaction
            System.out.println("Data inserted ...");
        } catch (Exception e) {
            e.printStackTrace();  // Print error stack trace if insertion fails
        }
    }

    /**
     * Inserts multiple Employee records into the database.
     * @param employeeList List of Employee objects to be inserted
     */
    public void insertEmployeeList(List<Employee> employeeList) {
        // Implement batch insert logic if needed for performance optimization
    }

    public Employee getEmployee(int id) {
        try (Session session = factory.openSession()) { // Try-with-resources for auto-closing session
            return session.get(Employee.class, id); // Fetch employee by ID
        } catch (Exception e) {
            e.printStackTrace();
            return null; // Return null if employee not found
        }
    }
    
    public boolean updateEmployeeSalary(int id, double salary) {
        try (Session session = factory.openSession()) {  
            session.beginTransaction();
            
            Employee employee = session.get(Employee.class, id);
            if (employee != null) {
                employee.setSalary(salary);  // Update the salary
                session.update(employee);
                session.getTransaction().commit();
                System.out.println("Salary updated for Employee ID: " + id);
                return true;
            }
            
            return false; // Employee not found
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    
    public boolean deleteEmployeeById(int id) {
        try (Session session = factory.openSession()) {  
            session.beginTransaction();
            
            Employee employee = session.get(Employee.class, id);
            if (employee != null) {
                session.delete(employee);  // Delete the employee
                session.getTransaction().commit();
                System.out.println("Employee deleted with ID: " + id);
                return true;
            }
            
            return false; // Employee not found
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }


}
