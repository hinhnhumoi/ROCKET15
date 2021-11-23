package org.VTI.Entity;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.Formula;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "`Account`", catalog = "testingsystem2")
@Inheritance(strategy = InheritanceType.JOINED)
public class Account implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column (name = "AccountID", nullable = false )
    private short id;

    @Column(name = "Email", nullable = false, unique = true, length = 50, updatable = false)
    private String email;

    @Column(name = "Username", nullable = false, unique = true, length = 50, updatable = false)
    private String userName;

    @Column(name = "FirstName", nullable = false, length = 50)
    private String firstName;

    @Column(name = "LastName", nullable = false, length = 50)
    private String lastName;

    @Formula("concat( FirstName ,' ' , LastName)")
    private String fullName;

    @Column(name = "CreateDate", nullable = false, updatable = false)
    @Temporal(TemporalType.TIMESTAMP)
    @CreationTimestamp
    private Date createDate;

    @ManyToOne
    @JoinColumn(name = "DepartmentID", nullable = false)
    private Department department;

    @ManyToOne
    @JoinColumn(name = "PositionID", nullable = false)
    private Position position;

    @ManyToOne
    @JoinColumn(name = "SalaryID", nullable = false)
    private Salary salary;

    @OneToMany(mappedBy = "creator")
    private List<Group> createdGroup;

    @OneToMany(mappedBy = "account")
    private List<GroupAccount> groups;

    public String getFullName() {
        return fullName;
    }

    public Account() {
    }

    public short getId() {
        return id;
    }

    public void setId(short id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }

    public Salary getSalary() {
        return salary;
    }

    public void setSalary(Salary salary) {
        this.salary = salary;
    }

    public List<Group> getCreatedGroup() {
        return createdGroup;
    }

    public void setCreatedGroup(List<Group> createdGroup) {
        this.createdGroup = createdGroup;
    }

    public List<GroupAccount> getGroups() {
        return groups;
    }

    public void setGroups(List<GroupAccount> groups) {
        this.groups = groups;
    }

    @Override
    public String toString() {
        return "Account{" +
                "id=" + id +
                ", email='" + email + '\'' +
                ", userName='" + userName + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", fullName='" + fullName + '\'' +
                ", createDate=" + createDate +
                ", department=" + department.getName() +
                ", position=" + position +
                ", salary=" + salary +
                '}';
    }
}
