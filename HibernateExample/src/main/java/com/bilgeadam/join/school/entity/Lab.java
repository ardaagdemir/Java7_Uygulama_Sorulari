package com.bilgeadam.join.school.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Lab {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int labId;
    private String lokasyon;

    public Lab() {
    }

    public Lab(String lokasyon) {
        this.lokasyon = lokasyon;
    }

    public int getLabId() {
        return labId;
    }

    public void setLabId(int labId) {
        this.labId = labId;
    }

    public String getLokasyon() {
        return lokasyon;
    }

    public void setLokasyon(String lokasyon) {
        this.lokasyon = lokasyon;
    }

    @Override
    public String toString() {
        return "Lab{" +
                "labId=" + labId +
                ", lokasyon='" + lokasyon + '\'' +
                '}';
    }
}
