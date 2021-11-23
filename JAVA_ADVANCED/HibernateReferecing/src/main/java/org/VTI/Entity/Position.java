package org.VTI.Entity;

import org.VTI.Entity.Enumerate.PositionName;
import org.VTI.Entity.Enumerate.PositionNameConvert;
import org.VTI.Entity.Enumerate.SalaryNameConvert;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

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

    @OneToMany(mappedBy = "position")
    private List<Account> accounts;

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

    public List<Account> getAccounts() {
        return accounts;
    }

    public void setAccounts(List<Account> accounts) {
        this.accounts = accounts;
    }

    @Override
    public String toString() {
        return "Position{" +
                "id=" + id +
                ", name=" + name +
                '}';
    }
}
