package com.apexinfo.livecloud.server.plugins.project.common.login.user.bean;

import java.util.Date;

public class Employee {
    private Integer id;

    private String fNo;

    private String fName;

    private Integer fDept;

    private Integer fSex;

    private Date fBirthday;

    private String fIdentityNum;

    private String fPhone;

    private Date fEntryTime;

    public Employee() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getfNo() {
        return fNo;
    }

    public void setfNo(String fNo) {
        this.fNo = fNo;
    }

    public String getfName() {
        return fName;
    }

    public void setfName(String fName) {
        this.fName = fName;
    }

    public Integer getfDept() {
        return fDept;
    }

    public void setfDept(Integer fDept) {
        this.fDept = fDept;
    }

    public Integer getfSex() {
        return fSex;
    }

    public void setfSex(Integer fSex) {
        this.fSex = fSex;
    }

    public Date getfBirthday() {
        return fBirthday;
    }

    public void setfBirthday(Date fBirthday) {
        this.fBirthday = fBirthday;
    }

    public String getfIdentityNum() {
        return fIdentityNum;
    }

    public void setfIdentityNum(String fIdentityNum) {
        this.fIdentityNum = fIdentityNum;
    }

    public String getfPhone() {
        return fPhone;
    }

    public void setfPhone(String fPhone) {
        this.fPhone = fPhone;
    }

    public Date getfEntryTime() {
        return fEntryTime;
    }

    public void setfEntryTime(Date fEntryTime) {
        this.fEntryTime = fEntryTime;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", fNo='" + fNo + '\'' +
                ", fName='" + fName + '\'' +
                ", fDept=" + fDept +
                ", fSex=" + fSex +
                ", fBirthday=" + fBirthday +
                ", fIdentityNum='" + fIdentityNum + '\'' +
                ", fPhone='" + fPhone + '\'' +
                ", fEntryTime=" + fEntryTime +
                '}';
    }
}
