package com.knoldus;

import twitter4j.Twitter;

public class AppDriver {
    public static void main(String[] args) throws Exception {
        Twitter twitter= new Connection().start();// run the Twitter client
        OperationMethod operationMethod=new OperationMethod(twitter);
         System.out.println(operationMethod.getLatestPost(2));
        System.out.println(operationMethod.getOldestPost(2));
        System.out.println(operationMethod.NumberOfRetweets());
        System.out.println(operationMethod.NumberOfLikes());

    }
}
