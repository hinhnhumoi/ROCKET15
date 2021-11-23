package org.VTI.Entity;

import org.VTI.Entity.Enumerate.PositionNameConvert;
import org.VTI.Entity.Enumerate.SalaryName;
import org.VTI.Entity.Enumerate.SalaryNameConvert;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "Salary", catalog = "testingsystem2")
public class Salary implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column (name = "SalaryID", nullable = false )
    private int id;

    @Column(name = "SalaryName", nullable = false, unique = true)
    @Convert(converter = SalaryNameConvert.class)
    private SalaryName salary;

    @OneToMany(mappedBy = "salary")
    private List<Account> accounts;

    public Salary() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public SalaryName getSalary() {
        return salary;
    }

    public void setSalary(SalaryName salary) {
        this.salary = salary;
    }

    public List<Account> getAccounts() {
        return accounts;
    }

    public void setAccounts(List<Account> accounts) {
        this.accounts = accounts;
    }

    @Override
    public String toString() {
        return "Salary{" +
                "id=" + id +
                ", salary=" + salary.getValue()+
                '}';
    }
}
