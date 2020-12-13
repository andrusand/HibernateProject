package repository;

import model.EmployeeProject;
import model.Project;
import util.DBUtil;

import javax.persistence.EntityManager;
import java.util.List;

public class RepositoryEmployeeProject {

    private EntityManager em;

    public RepositoryEmployeeProject() {
        em = DBUtil.getEntityManager();
    }

    public void saveProject(EmployeeProject employeeProject) {

        try {
            em.getTransaction().begin();
            em.persist(employeeProject);
            em.getTransaction().commit();
        } catch (Exception ex) {
            em.getTransaction().rollback();
        }
    }

    public void updateEmployeeProject(EmployeeProject employeeProject) {
        try {
            em.getTransaction().begin();
            em.merge(employeeProject);
            em.getTransaction().commit();
        } catch (Exception ex) {
            em.getTransaction().rollback();
        }

    }

    public void deleteProject(EmployeeProject employeeProject) {
        try {
            em.getTransaction().begin();
            em.remove(em.merge(employeeProject));
            em.getTransaction().commit();
        } catch (Exception ex) {
            em.getTransaction().rollback();
        }

    }

    public List<Project> listAllProjects() {
        return null;
    }

    public Project findProjectById() {
        return null;
    }
}
