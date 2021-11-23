package org.VTI.Entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import java.io.Serializable;

@Entity
@Table(name = "Manager", catalog = "testingsystem2")
@PrimaryKeyJoinColumn(name = "AccountID")
public class Manager extends Account implements Serializable {

    @Column(name = "ManagementNumberOfYear", nullable = false )
    private short ManagementNumberOfYear;

    public Manager() {
    }

    public short getManagementNumberOfYear() {
        return ManagementNumberOfYear;
    }

    public void setManagementNumberOfYear(short managementNumberOfYear) {
        ManagementNumberOfYear = managementNumberOfYear;
    }
}
