package com.company;

public class ConverterSwitch implements Converter{

    public String convertMonth(int monthNumber){
        String month = "";

        switch(monthNumber){
            case 1:
                month = "January";
                break;

            case 2:
                month = "February";
                break;

            case 3:
                month = "March";
                break;

            case 4:
               month = "April";
                break;

            case 5:
                month = "May";
                break;

            case 6:
                month = "June";
                break;

            case 7:
                month = "July";
                break;

            case 8:
                month = "August";
                break;

            case 9:
                month = "September";
                break;

            case 10:
                month = "October";
                break;

            case 11:
                month = "November";
                break;

            case 12:
                month = "December";
                break;

                default:
                    System.out.println("That is not a valid entry.");
        }
        return month;
    }


    public String convertDay(int dayNumber){
        String day = "";

        switch(dayNumber){
            case 1:
                day = "Sunday";
                break;
            case 2:
                day = "Monday";
                break;
            case 3:
                day = "Tuesday";
                break;
            case 4:
                day = "Wednesday";
                break;
            case 5:
                day = "Thrusday";
                break;
            case 6:
                day = "Friday";
                break;
            case 7:
                day = "Saturday";
                break;
                default:
                    System.out.println("That is not a valid entry");
        }
        return day;
    }

}
