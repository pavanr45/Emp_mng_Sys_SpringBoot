📌 Project Overview: 

This project is a CRUD (Create, Read, Update, Delete) based Employee Management System developed using Spring Boot and Hibernate ORM.

It provides RESTful APIs to:

Add single/multiple employees

Fetch employee details

Update employee salary

Delete an employee by ID

🚀 Technologies Used:

Java 17+

Spring Boot

Hibernate (ORM)

Maven

MySQL Database

Git/GitHub

📂 Project Structure
Copy code
com.pr
├── controller
│   └── EmployeeController.java
├── service
│   └── EmployeeService.java
├── dao
│   └── EmployeeDao.java
├── entity
│   └── Employee.java
├── EmpMngSystemSpringbootApplication.java

📚 APIs Overview:

Method	Endpoint	Description

GET	/employees/get-login	Test login API
GET	/employees/get-employee/{id}	Fetch employee by ID
GET	/employees/get-employee-list	Fetch all employees
POST	/employees/insert-employee	Insert a single employee
POST	/employees/insert-employee-list	Insert multiple employees
PUT	/employees/update-employee-salary/{id}	Update employee salary by ID
DELETE	/employees/delete-employee/{id}	Delete employee by ID

✍️ Author
Developed by Pavan Rathod
