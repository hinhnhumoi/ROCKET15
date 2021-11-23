package org.VTI.Entity.PrimaryKey;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class GroupAccountKey implements Serializable {

    @Column(name = "GroupID")
    private short groupId;

    @Column(name = "AccountID")
    private short AccountId;

    public GroupAccountKey() {
    }

    public short getGroupId() {
        return groupId;
    }

    public void setGroupId(short groupId) {
        this.groupId = groupId;
    }

    public short getAccountId() {
        return AccountId;
    }

    public void setAccountId(short accountId) {
        AccountId = accountId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        GroupAccountKey that = (GroupAccountKey) o;
        return groupId == that.groupId && AccountId == that.AccountId;
    }

    @Override
    public int hashCode() {
        return Objects.hash(groupId, AccountId);
    }
}
