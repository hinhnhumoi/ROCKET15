package org.VTI.Entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import java.io.Serializable;

@Entity
@Table(name = "`Employee`", catalog = "testingsystem2")
@PrimaryKeyJoinColumn(name = "AccountID")
public class Employee extends Account implements Serializable {

    @Column(name = "WorkingNumberOfYear", nullable = false )
    private short workingNumberOfYear;

    public Employee() {
    }

    public short getWorkingNumberOfYear() {
        return workingNumberOfYear;
    }

    public void setWorkingNumberOfYear(short workingNumberOfYear) {
        this.workingNumberOfYear = workingNumberOfYear;
    }

    @Override
    public String toString() {
        System.out.println(super.toString());
        return "Employee{" +
                "workingNumberOfYear=" + workingNumberOfYear +
                '}';
    }
}
