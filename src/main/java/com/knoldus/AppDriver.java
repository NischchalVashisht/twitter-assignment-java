package com.knoldus;

import twitter4j.Twitter;

import java.util.Date;

public class AppDriver {
    public static void main(String[] args) throws Exception {
        Twitter twitter= new Connection().start();// run the Twitter client
        OperationMethod operationMethod=new OperationMethod(twitter);
         System.out.println(operationMethod.getLatestPost(5,1));
        System.out.println("2");

        System.out.println(operationMethod.getOldestPost(2));
        System.out.println("3");

        System.out.println(operationMethod.NumberOfRetweets());
        System.out.println("4");

        System.out.println(operationMethod.getStatusByDate(new Date()));
        System.out.println("5");
        System.out.println(operationMethod.getStatusByTimeInterval(new Date()));
        System.out.println(new Date().getMinutes());
    }
}
