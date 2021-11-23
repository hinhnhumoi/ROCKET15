package com.vti.entity;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.Formula;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "`user`")
public class User implements Serializable {
    private static final long serialVersionUID = 1L;

    @Column(name = "userID")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private short id;

    @Column(name = "email", nullable = false, unique = true, length = 50, updatable = false)
    @Email
    private String email;

    @Column(name = "`password`", nullable = false, length = 800)
    @Size(min = 6, max = 30, message = "Password must be from 6 to 30 characters!")
    private String password;

    @Column(name = "username", nullable = false, unique = true, length = 50, updatable = false)
    @Size(min = 6, max = 30, message = "username must be from 6 to 30 characters!")
    private String username;

    @Column(name = "firstName", nullable = false, length = 50)
    private String firstName;

    @Column(name = "lastName", nullable = false, length = 50)
    private String lastName;

    @Formula("concat( FirstName ,' ' , LastName)")
    private String fullName;

    @Column(name = "`role`", nullable = false)
    private String role;

    @Column(name = "createDate", nullable = false, updatable = false)
    @Temporal(TemporalType.TIMESTAMP)
    @CreationTimestamp
    private Date createDate;

    @ManyToOne
    @JoinColumn(name = "groupID")
    private Group group;

    @OneToMany(mappedBy = "creator")
    private List<Group> createdGroup;

    public User() {
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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
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

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public Group getGroup() {
        return group;
    }

    public void setGroup(Group group) {
        this.group = group;
    }

    public List<Group> getCreatedGroup() {
        return createdGroup;
    }

    public void setCreatedGroup(List<Group> createdGroup) {
        this.createdGroup = createdGroup;
    }
}
