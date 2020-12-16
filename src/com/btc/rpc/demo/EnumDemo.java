package com.btc.rpc.demo;

public class EnumDemo {
    public static void main(String[] args) {
        printweekDay(WEEK.THURSDAY);
    }

    public static void printweekDay(WEEK week) {
        switch (week) {
            case MONDAY:
                System.out.println("这是一个星期的第一天");
                break;
            case TUESDAY:
                break;
            case WEDNESDAY:
                System.out.println("这是一个星期的第三天");
                   break;
            case THURSDAY:
                System.out.println("这是一个星期的第四天");
                break;
            case FRIDAY:
                System.out.println("这是一个星期的第五天");
                break;
            case SATURDAY:
                System.out.println("这是一个星期的第六天");
                break;
            case SUNDAY:
                System.out.println("这是一个星期的第七天");
                break;
        }
    }
}
