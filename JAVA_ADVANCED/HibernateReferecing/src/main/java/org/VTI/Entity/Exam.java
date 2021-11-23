package org.VTI.Entity;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "Exam", catalog = "testingsystem2")
public class Exam implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column (name = "ExamID", nullable = false )
    private short id;

    @Column(name = "code1", length = 10, nullable = false)
    @GeneratedValue (generator = "examCodeGenerator" )
    @GenericGenerator(name = "examCodeGenerator", strategy = "org.VTI.Entity.Generator.ExamCodeGenerator")
    private String code1;


    @Column(name = "code2", length = 10)
    private String code2;


    @Column( name ="Title" , length = 50, nullable = false)
    private String title;

    @Column(name = "Duration", columnDefinition = "tinyint default 45", nullable = false)
    private short duration;

    @Column(name = "CreateDate", nullable = false, updatable = false)
    @Temporal(TemporalType.TIMESTAMP)
    @CreationTimestamp
    private Date createDate;

    public Exam() {
    }

    public String getCode2() {
        return code2;
    }

    public void setCode2(String code2) {
        this.code2 = code2;
    }
    public short getId() {
        return id;
    }

    public void setId(short id) {
        this.id = id;
    }

    public String getCode1() {
        return code1;
    }

    public void setCode1(String code1) {
        this.code1 = code1;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public short getDuration() {
        return duration;
    }

    public void setDuration(short duration) {
        this.duration = duration;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    @Override
    public String toString() {
        return "Exam{" +
                "id=" + id +
                ", code1='" + code1 + '\'' +
                ", title='" + title + '\'' +
                ", duration=" + duration +
                ", createDate=" + createDate +
                '}';
    }
}
