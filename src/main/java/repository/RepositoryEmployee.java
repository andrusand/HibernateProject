package repository;

import model.Employee;
import model.EmployeeDepartment;
import util.DBUtil;

import javax.persistence.EntityManager;
import java.util.List;

public class RepositoryEmployee {

    private EntityManager em;

    public RepositoryEmployee() {
        em = DBUtil.getEntityManager();
    }

    public void saveEmployee(Employee employee) {

        try {
            em.getTransaction().begin();
            em.persist(employee);
            em.getTransaction().commit();
        } catch (Exception ex) {
        em.getTransaction().rollback();
        }
    }

    public void updateEmployee(Employee employee) {
        try {
            em.getTransaction().begin();
            em.merge(employee);
            em.getTransaction().commit();
        } catch (Exception ex) {
            em.getTransaction().rollback();
        }

    }

    public void deleteEmployee(Employee employee) {
        try {
            em.getTransaction().begin();
            em.remove(em.merge(employee));
            em.getTransaction().commit();
        } catch (Exception ex) {
            em.getTransaction().rollback();
        }

    }

    public List<Employee> listAllEmployees() {
        String sql = "FROM Employee e";
        return em.createQuery(sql).getResultList();
    }

    public List<Employee> findByFirstName(String fName) {
        String sql = "FROM Employee e WHERE e.firstName = :fN"; //instead of ? we use :smthSmth
        return em.createQuery(sql).setParameter("fN", fName).getResultList();
    }

    public Employee findById(int id) {
        String sql = "FROM Employee e WHERE e.employeeId = :empId";
        return em.createQuery(sql, Employee.class).setParameter("empId", id).getSingleResult();
    }

    public List<EmployeeDepartment> listEmployeeWithDepartmentName() {
        String sql = "SELECT new model.EmployeeDepartment(e.employeeId, e.firstName, d.name)" +
                     "FROM Employee e " +
                     "JOIN e.departments d";

        return em.createQuery(sql, EmployeeDepartment.class).getResultList();
    }

    public List<Employee> listEmployeeByDepartment (String departmentName) {
        String sql = "from Employee e " +
                     //"JOIN e.departments d " +
                     "WHERE e.departments.name = :deptN";

        return em.createQuery(sql).setParameter("deptN", departmentName).getResultList();
    }
}
