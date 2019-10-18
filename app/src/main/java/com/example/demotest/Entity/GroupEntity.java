package com.example.demotest.Entity;

import java.util.Date;

public class GroupEntity {
    private Integer groupId;
    private String groupName;
    private Integer targetAmount;
    // private Date desiredDate;

    public GroupEntity(Integer groupId, String groupName, Integer targetAmount) {
        this.groupId = groupId;
        this.groupName = groupName;
        this.targetAmount = targetAmount;
    }

    public Integer getGroupId() {
        return groupId;
    }

    public void setGroupId(Integer groupId) {
        this.groupId = groupId;
    }

    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }

    public Integer getTargetAmount() {
        return targetAmount;
    }

    public void setTargetAmount(Integer targetAmount) {
        this.targetAmount = targetAmount;
    }

    @Override
    public String toString() {
        return getGroupId() + "," + getGroupName() + "," + getTargetAmount();
    }

//    public Date getDesiredDate() {
//        return desiredDate;
//    }
//
//    public void setDesiredDate(Date desiredDate) {
//        this.desiredDate = desiredDate;
//    }
}
