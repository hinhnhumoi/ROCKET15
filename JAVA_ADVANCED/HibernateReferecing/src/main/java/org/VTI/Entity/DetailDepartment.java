package org.VTI.Entity;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "`DetailDepartment`", catalog = "testingsystem2")
@PrimaryKeyJoinColumn(name = "DepartmentID")
public class DetailDepartment extends Department implements Serializable {

    @OneToOne (cascade = CascadeType.ALL)
    @JoinColumn(name = "AddressID", referencedColumnName = "AddressID")
    private Address address;

    @Column(name = "EmulationPoint", nullable = false)
    private short emulationPoint;

    public DetailDepartment() {
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public short getEmulationPoint() {
        return emulationPoint;
    }

    public void setEmulationPoint(short emulationPoint) {
        this.emulationPoint = emulationPoint;
    }

    @Override
    public String toString() {
        System.out.println(super.toString());
        return "DetailDepartment{" +
//                "address=" + address.getName() +
                ", emulationPoint=" + emulationPoint +
                '}';
    }
}
