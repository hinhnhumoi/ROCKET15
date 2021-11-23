package org.VTI.entity;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table (name = "Testing_Category", catalog = "TestingSystem")
public class TestingCategory implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false )
    private short id;

    @Column(name = "name", nullable = false, unique = true, length = 50)
    private String name;

    public TestingCategory() {
    }

    public short getId() {
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
}
