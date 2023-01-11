package com.bilgeadam.join.school.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Lab {

    @Id
    private int labId;

    private String lokasyon;

    public Lab() {
    }

    public int getLabId() {
        return labId;
    }


}
