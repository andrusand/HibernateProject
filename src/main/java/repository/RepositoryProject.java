package repository;

import model.Project;
import util.DBUtil;

import javax.persistence.EntityManager;
import java.util.List;

public class RepositoryProject {

    private EntityManager em;

    public RepositoryProject() {
        em = DBUtil.getEntityManager();
    }

    public void saveProject(Project project) {

        try {
            em.getTransaction().begin();
            em.persist(project);
            em.getTransaction().commit();
        } catch (Exception ex) {
            em.getTransaction().rollback();
        }
    }

    public void updateProject(Project project) {
        try {
            em.getTransaction().begin();
            em.merge(project);
            em.getTransaction().commit();
        } catch (Exception ex) {
            em.getTransaction().rollback();
        }

    }

    public void deleteProject(Project project) {
        try {
            em.getTransaction().begin();
            em.remove(em.merge(project));
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

