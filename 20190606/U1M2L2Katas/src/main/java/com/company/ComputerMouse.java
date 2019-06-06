package com.company;

public class ComputerMouse {

    private String manufacturer;
    private String model;
    private int xPosition;
    private int yPosition;
    private int[] lastClickedLocation;

    public ComputerMouse (String manufacturer, String model, int xPosition, int yPosition, int[] lastClickedLocation){
        this.manufacturer = manufacturer;
        this.model = model;
        this.xPosition = xPosition;
        this.yPosition = yPosition;
        this.lastClickedLocation = lastClickedLocation;

    }

    public void setManufacturer(String manufacturer){
        this.manufacturer = manufacturer;
    }

    public String getManufacturer(){
        return this.manufacturer;
    }

    public void setModel(String model){
        this.model = model;
    }

    public String getModel(){
        return this.model;
    }

    public void setxPosition(int xPosition){
        this.xPosition = xPosition;
    }

    public int getxPosition(){
        return this.xPosition;
    }

    public void setyPosition(int yPosition){
        this.yPosition = yPosition;
    }

    public int getyPosition(){
        return this.yPosition;
    }

    public void setLastClickedLocation(int xPosition, int yPosition){
        this.xPosition = xPosition;
        this.yPosition = yPosition;
    }

    public int[] getLastClickedLocation(){

            return this.lastClickedLocation;

    }

    public void move(int deltaX, int deltaY){
        this.xPosition += deltaX;
        this.yPosition += deltaY;
    }

    public void click(int i){
        while(i!=0){
            System.out.println("Click");
            i--;
        }
    }


}
