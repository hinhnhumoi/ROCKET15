package com.company.entity;

public class Employee extends User{

    /**
     * This class is Employee
     *
     * @Description: every employee of the company
     * @author : Tung
     * @create_date: ${13-8-2021}
     * @version : 1.0
     * @modifier : Tung
     * @modifier_date : ${13-8-2021}
     */

    enum ProSkill {dev,test,sql,java}

    private int projectId;
    private ProSkill proSkill;

    public Employee(int id, String fullName, String email, String passWord,int projectId, ProSkill proSkill) {
        super(id, fullName, email, passWord);
        this.projectId = projectId;
        this.proSkill = proSkill;
    }

    public int getProjectId() {
        return projectId;
    }

    public void setProjectId(int projectId) {
        this.projectId = projectId;
    }

    public ProSkill getProSkill() {
        return proSkill;
    }

    public void setProSkill(ProSkill proSkill) {
        this.proSkill = proSkill;
    }
}
