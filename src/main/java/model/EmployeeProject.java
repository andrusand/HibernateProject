package model;

import javax.persistence.*;

@Entity
@Table(name = "employees_projects")
public class EmployeeProject {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int employeeProjectId;

    @ManyToOne
    @JoinColumn(name = "employeeId")
    private Employee employees;

    @ManyToOne
    @JoinColumn(name = "projectId")
    private Project projects;

    public int getEmployeeProjectId() {
        return employeeProjectId;
    }

    public void setEmployeeProjectId(int employeeProjectId) {
        this.employeeProjectId = employeeProjectId;
    }

}

