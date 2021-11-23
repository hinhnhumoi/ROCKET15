package com.company.entity;

public class Project {

    /**
     * This class is Employee
     *
     * @Description: every project of the company
     * @author : Tung
     * @create_date: ${13-8-2021}
     * @version : 1.0
     * @modifier : Tung
     * @modifier_date : ${13-8-2021}
     */

    private int projectId;
    private int teamSize;
    private int idManager;
    private int[] idEmployees;

    public int getProjectId() {
        return projectId;
    }

    public void setProjectId(int projectId) {
        this.projectId = projectId;
    }

    public int getTeamSize() {
        return teamSize;
    }

    public void setTeamSize(int teamSize) {
        this.teamSize = teamSize;
    }

    public int getIdManager() {
        return idManager;
    }

    public void setIdManager(int idManager) {
        this.idManager = idManager;
    }

    public int[] getIdEmployees() {
        return idEmployees;
    }

    public void setIdEmployees(int[] idEmployees) {
        this.idEmployees = idEmployees;
    }
}
