package org.VTI.Entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table (name = "department", catalog = "testingsystem2")
@Inheritance(strategy = InheritanceType.JOINED)
public class Department implements Serializable {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    @Column (name = "DepartmentID", nullable = false )
    private short id;

    @Column(name = "DepartmentName", nullable = false, unique = true, length = 30)
    private String name;

    @OneToMany(mappedBy = "department")
    private List<Account> accounts;


    public Department() {
    }

    public int getId() {
        return id;
    }

    public void setId(short id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Account> getAccounts() {
        return accounts;
    }

    public void setAccounts(List<Account> accounts) {
        this.accounts = accounts;
    }

    @Override
    public String toString() {
        return "Department " +
                "id= " + id +
                ", name= " + name;
    }
}
