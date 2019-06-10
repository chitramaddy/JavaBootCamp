package com.company;

public class Bathroom{

    private String sink;
    private String bathtub;
    private String fixtures;

    public Bathroom(String sink, String bathtub, String fixtures) {

        this.sink = sink;
        this.fixtures = fixtures;
        this.bathtub = bathtub;
    }

    public String getSink() {
        return sink;
    }

    public void setSink(String sink) {
        this.sink = sink;
    }

    public String getBathtub() {
        return bathtub;
    }

    public void setBathtub(String bathtub) {
        this.bathtub = bathtub;
    }

    public String getFixtures() {
        return fixtures;
    }

    public void setFixtures(String fixtures) {
        this.fixtures = fixtures;
    }

}