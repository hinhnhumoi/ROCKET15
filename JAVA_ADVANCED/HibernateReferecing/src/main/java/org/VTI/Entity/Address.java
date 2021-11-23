package org.VTI.Entity;


import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "`Address`", catalog = "testingsystem2")
public class Address implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column (name = "AddressID", nullable = false )
    private short id;

    @Column(name = "AddressName", nullable = false, unique = true, length = 100)
    private String name;

    @OneToOne (mappedBy = "address")
    private DetailDepartment detailDepartment;

    public Address() {
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

    public DetailDepartment getDetailDepartment() {
        return detailDepartment;
    }

    public void setDetailDepartment(DetailDepartment detailDepartment) {
        this.detailDepartment = detailDepartment;
    }

    @Override
    public String toString() {
        return "Address{" +
                "id=" + id +
                " detail Department: " + detailDepartment.getName() +
                ", name='" + name + '\'' +
                '}';
    }
}
