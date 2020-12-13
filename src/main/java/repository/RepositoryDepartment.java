package repository;

import model.Department;
import util.DBUtil;

import javax.persistence.EntityManager;
import java.util.List;

public class RepositoryDepartment {

    private EntityManager em;

    public RepositoryDepartment() {
        em = DBUtil.getEntityManager();
    }

    public void saveDepartment(Department department) {

        try {
            em.getTransaction().begin();
            em.persist(department);
            em.getTransaction().commit();
        } catch (Exception ex) {
            em.getTransaction().rollback();
        }
    }

    public void updateDepartment (Department department) {
        try {
            em.getTransaction().begin();
            em.merge(department);
            em.getTransaction().commit();
        } catch (Exception ex) {
            em.getTransaction().rollback();
        }

    }

    public void deleteDepartment(Department department) {
        try {
            em.getTransaction().begin();
            em.remove(em.merge(department));
            em.getTransaction().commit();
        } catch (Exception ex) {
            em.getTransaction().rollback();
        }

    }

    public List<Department> listAllDepartments() {
        return null;
    }

    public Department findByDepartmentId() {
        return null;
    }
}
