package com.bilgeadam.join.school.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class MacAddress {

    @Id
    private int labId;

    private String ip;

    public MacAddress() {
    }

    public int getLabId() {
        return labId;
    }

    public void setLabId(int labId) {
        this.labId = labId;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }
}
