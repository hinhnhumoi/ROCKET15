package org.VTI.entity;

import javax.persistence.*;
import java.io.Serializable;


@Entity
@Table(name = "address", catalog = "TestingSystem")
public class Address implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false )
    private int id;

    @OneToOne(mappedBy = "address")
    private Users users;

    @Column (name = "street", nullable = false)
    private String street;

    @Column (name = "city", nullable = false)
    private String city;



    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }
}
