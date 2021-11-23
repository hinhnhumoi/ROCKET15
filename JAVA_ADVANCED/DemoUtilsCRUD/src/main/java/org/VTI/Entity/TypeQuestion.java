package org.VTI.Entity;

import org.VTI.Entity.Enumerate.PositionName;
import org.VTI.Entity.Enumerate.SalaryNameConvert;
import org.VTI.Entity.Enumerate.TypeName;
import org.VTI.Entity.Enumerate.TypeNameConvert;

import javax.persistence.*;

@Entity
@Table(name = "TypeQuestion", catalog = "testingsystem2")
public class TypeQuestion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "TypeID", nullable = false )
    private short id;

    @Column(name = "TypeName", nullable = false, unique = true)
    @Convert(converter = TypeNameConvert.class)
    private TypeName name;

    public TypeQuestion() {
    }

    public short getId() {
        return id;
    }

    public void setId(short id) {
        this.id = id;
    }

    public TypeName getName() {
        return name;
    }

    public void setName(TypeName name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "TypeQuestion{" +
                "id=" + id +
                ", name=" + name +
                '}';
    }
}
