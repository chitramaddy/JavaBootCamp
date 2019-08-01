package com.company.U1M4SummativeMadhanChitra.model;

import javax.validation.constraints.Min;
import javax.validation.constraints.Positive;

public class Student {

    private int id;
    private String firstName;
    private String lastName;
    @Min(value=0, message = "add a min msg" )
    private int classCount;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getClassCount() {
        return classCount;
    }

    public void setClassCount(int classCount) {
        this.classCount = classCount;
    }
}
