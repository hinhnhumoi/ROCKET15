package org.VTI.Entity;

import javax.persistence.*;

@Entity
@Table(name = "`CategoryQuestion`", catalog = "testingsystem2")
public class CategoryQuestion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "CategoryID", nullable = false )
    private short id;

    @Column(name = "CategoryName", nullable = false, unique = true, length = 50)
    private String name;

    public CategoryQuestion() {
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

    @Override
    public String toString() {
        return "CategoryQuestion{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
