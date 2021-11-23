package org.VTI.Entity;

import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "`Group`", catalog = "testingsystem2")
public class Group implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "GroupID", nullable = false )
    private short id;

    @Column(name = "GroupName", nullable = false, unique = true, length = 50)
    private String name;

    @Column(name = "CreateDate", nullable = false, updatable = false)
    @Temporal(TemporalType.TIMESTAMP)
    @CreationTimestamp
    private Date createDate;

    @ManyToOne
    @JoinColumn(name = "CreatorID", nullable = false, updatable = false)
    private Account creator;

    @OneToMany(mappedBy = "group", fetch = FetchType.EAGER)
    private List<GroupAccount> accounts;

    public Group() {
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

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public Account getCreator() {
        return creator;
    }

    public void setCreator(Account creator) {
        this.creator = creator;
    }

    public List<GroupAccount> getAccounts() {
        return accounts;
    }

    public void setAccounts(List<GroupAccount> accounts) {
        this.accounts = accounts;
    }

    @Override
    public String toString() {

        System.out.println ("Group{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", createDate=" + createDate +
                ", creator=" + creator.getFullName() +
                '}');
        for (GroupAccount groupAccount : accounts) {
            System.out.println(groupAccount.getAccount().getFullName());
            System.out.println(groupAccount.getJoinDate());
        }
        return "end of Group!";
    }
}
