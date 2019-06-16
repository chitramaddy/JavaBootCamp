package com.company;

import java.util.Scanner;

public class ConverterApplication {

    public static void main(String[] args) {


        String daySwitch;
        String monthSwitch;
        String dayIf;
        String monthIf;

        ConverterSwitch converterSwitch = new ConverterSwitch();
        ConverterIf converterIf = new ConverterIf();

        System.out.println("ConverterSwtich Month result: ");
        monthSwitch = converterSwitch.convertMonth(2);
        System.out.println(monthSwitch);
        System.out.println("--------------------------------------------");

        System.out.println("ConverterSwtich Month result: ");
        monthSwitch = converterSwitch.convertMonth(0);
        System.out.println(monthSwitch);
        System.out.println("--------------------------------------------");

        System.out.println("ConverterSwtich Day result: ");
        daySwitch = converterSwitch.convertDay(2);
        System.out.println(daySwitch);
        System.out.println("--------------------------------------------");

        System.out.println("ConverterSwtich Day result: ");
        daySwitch = converterSwitch.convertDay(0);
        System.out.println(daySwitch);
        System.out.println("--------------------------------------------");

        System.out.println("ConverterIf Day result: ");
        dayIf = converterIf.convertDay(5);
        System.out.println(dayIf);
        System.out.println("--------------------------------------------");

        System.out.println("ConverterIf Day result: ");
        dayIf = converterIf.convertDay(12);
        System.out.println(dayIf);
        System.out.println("--------------------------------------------");

        System.out.println("ConverterIf month result: ");
        monthIf = converterIf.convertMonth(17);
        System.out.println(monthIf);
        System.out.println("--------------------------------------------");

        System.out.println("ConverterIf Month result: ");
        monthIf = converterIf.convertMonth(6);
        System.out.println(monthIf);
        System.out.println("--------------------------------------------");
    }
    }