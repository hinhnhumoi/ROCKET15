package org.VTI.Entity;

import org.VTI.Entity.Enumerate.PositionName;
import org.VTI.Entity.Enumerate.PositionNameConvert;
import org.VTI.Entity.Enumerate.SalaryNameConvert;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "Position", catalog = "testingsystem2")
public class Position implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column (name = "PositionID", nullable = false )
    private short id;

    @Column(name = "PositionName", nullable = false, unique = true)
    @Convert(converter = PositionNameConvert.class)
    private PositionName name;

    public Position() {
    }

    public short getId() {
        return id;
    }

    public void setId(short id) {
        this.id = id;
    }

    public PositionName getName() {
        return name;
    }

    public void setName(PositionName name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Position{" +
                "id=" + id +
                ", name=" + name +
                '}';
    }
}
