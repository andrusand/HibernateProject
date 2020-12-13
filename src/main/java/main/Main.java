package main;

import model.Employee;
import model.EmployeeDepartment;
import repository.RepositoryDepartment;
import repository.RepositoryEmployee;
import repository.RepositoryEmployeeProject;
import repository.RepositoryProject;

import java.util.List;

public class Main {

    public static void main(String[] args) {

        RepositoryProject repositoryProject = new RepositoryProject();
        RepositoryEmployee repositoryEmployee = new RepositoryEmployee();
        RepositoryDepartment repositoryDepartment = new RepositoryDepartment();
        RepositoryEmployeeProject repositoryEmployeeProject = new RepositoryEmployeeProject();


        Employee em = new Employee();
        em.setFirstName("Elvis");
        em.setLastName("Milton");
        em.setPhoneNumber("888-555-666");
        em.setEmail("elvis@milton.com");
        em.setDateOfBirth("1994-03-01");
        em.setSalary(40000);
        //em.setEmployeeId(1); //For update only

        //repositoryEmployee.saveEmployee(em);
        //repositoryEmployee.updateEmployee(em);
        //repositoryEmployee.deleteEmployee(em);

       /* List<Employee> list = repositoryEmployee.listAllEmployees();
        for(Employee emp:list) {
            System.out.println(emp.toString());
        }*/

        /*List<Employee> list2 = repositoryEmployee.findByFirstName("Afsana");
        for(Employee emp:list2) {
            System.out.println(emp.toString());
        }*/

        /*Employee empResult = repositoryEmployee.findById(2);
        System.out.println(empResult.toString());*/

        List<EmployeeDepartment> listE = repositoryEmployee.listEmployeeWithDepartmentName();
        for(EmployeeDepartment emD:listE) {
            System.out.println(emD.getEmployeeId() + " " + emD.getEmployeeFirstName() + " " + emD.getDepartmentName());
        }

        /*List<Employee> lisDept = repositoryEmployee.listEmployeeByDepartment("HR");
        for(Employee e: lisDept) {
            System.out.println(e.getEmployeeId() + " " + e.getFirstName());
        }*/
        }
    }


