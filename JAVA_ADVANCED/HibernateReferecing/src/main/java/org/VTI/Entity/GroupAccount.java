package org.VTI.Entity;

import org.VTI.Entity.PrimaryKey.GroupAccountKey;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
public class GroupAccount implements Serializable {

    @EmbeddedId
    private GroupAccountKey id;

    @ManyToOne
    @MapsId("groupId")
    @JoinColumn(name = "AccountID")
    private Account account;

    @ManyToOne
    @MapsId("AccountId")
    @JoinColumn(name= "GroupID")
    private Group group;

    @Column(name = "JoinDate", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    @CreationTimestamp
    private Date joinDate;

    public GroupAccount() {
    }

    public GroupAccountKey getId() {
        return id;
    }

    public void setId(GroupAccountKey id) {
        this.id = id;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    public Group getGroup() {
        return group;
    }

    public void setGroup(Group group) {
        this.group = group;
    }

    public Date getJoinDate() {
        return joinDate;
    }

    public void setJoinDate(Date joinDate) {
        this.joinDate = joinDate;
    }
}
