package org.VTI.Entity;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table (name = "department", catalog = "testingsystem2")
public class Department implements Serializable {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    @Column (name = "DepartmentID", nullable = false )
    private short id;

    @Column(name = "DepartmentName", nullable = false, unique = true, length = 30)
    private String name;


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

    @Override
    public String toString() {
        return "Department " +
                "id= " + id +
                ", name= " + name;
    }
}
