package com.knoldus;

import twitter4j.Query;
import twitter4j.Status;
import twitter4j.Twitter;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class OperationMethod {
    Twitter twitter;
    List<Status> queryResult = null;

    OperationMethod(Twitter twitter) {
        this.twitter = twitter;
        try {
            Query query = new Query("Holi");
            queryResult = twitter.search(query).getTweets();
        } catch (Exception exception) {
            exception.printStackTrace();
        }
    }

    List<Status> getLatestPost(Integer limit) {

        try {
            return queryResult.subList(0, limit);
        } catch (Exception exception) {
            exception.printStackTrace();
        }
        return new ArrayList<>();
    }

    List<Status> getOldestPost(Integer limit) {
        try {
            List<Status> tempQueryResult=queryResult;
            Collections.reverse(tempQueryResult);
            tempQueryResult.subList(0,limit);

        } catch (Exception exception) {
            exception.printStackTrace();
        }

        return new ArrayList<>();
    }

    List <Integer> NumberOfRetweets(){
        try {
            List<Integer> listOfRetweet = queryResult.stream().map(Status::getRetweetCount).collect(Collectors.toList());
             Collections.sort(listOfRetweet,Collections.reverseOrder());
             return listOfRetweet;
        } catch (Exception exception) {
            exception.printStackTrace();
        }
     return new ArrayList<>();
 }

    List <Integer> NumberOfLikes(){
        try {
            System.out.println(queryResult);
            List<Integer> listOfRetweet = queryResult.stream().map(Status::getFavoriteCount).collect(Collectors.toList());
            Collections.sort(listOfRetweet,Collections.reverseOrder());
            return listOfRetweet;
        } catch (Exception exception) {
            exception.printStackTrace();
        }
        return new ArrayList<>();
    }
}
