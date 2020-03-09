package com.knoldus;

import twitter4j.Query;
import twitter4j.Status;
import twitter4j.Twitter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
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

    List<Status> getLatestPost(Integer limit, Integer skip) {

        try {System.out.println("here");
            System.out.println(queryResult.subList(0, limit).stream().skip(skip).collect(Collectors.toList()));
            return queryResult.subList(0, limit).stream().skip(skip).collect(Collectors.toList());
        } catch (Exception exception) {
            exception.printStackTrace();
        }
        return new ArrayList<>();
    }

    List<Status> getOldestPost(Integer limit) {
        try {
            List<Status> tempQueryResult = queryResult;
            Collections.reverse(tempQueryResult);
            tempQueryResult.subList(0, limit);

        } catch (Exception exception) {
            exception.printStackTrace();
        }

        return new ArrayList<>();
    }

    List<Integer> NumberOfRetweets() {
        try {
            return queryResult.stream().map(Status::getRetweetCount)
                    .sorted(Collections.reverseOrder())
                    .collect(Collectors.toList());
        } catch (Exception exception) {
            exception.printStackTrace();
        }
        return new ArrayList<>();
    }

    List<Integer> NumberOfLikes() {
        try {
            System.out.println(queryResult);
            List<Integer> listOfRetweet = queryResult.stream().map(Status::getFavoriteCount).sorted(Collections.reverseOrder()).collect(Collectors.toList());
            return listOfRetweet;
        } catch (Exception exception) {
            exception.printStackTrace();
        }
        return new ArrayList<>();
    }

    List<Status> getStatusByDate(Date date) {
        try {
            System.out.println("here4");
            System.out.println(queryResult.stream().filter(myDate -> myDate.getCreatedAt().getDate() == date.getDate()).collect(Collectors.toList()));
            return queryResult.stream().filter(myDate -> myDate.getCreatedAt() == date).collect(Collectors.toList());

        } catch (Exception exception) {
            exception.printStackTrace();
        }
        return new ArrayList<>();


    }

    List<Status> getStatusByTimeInterval(Date date){
        try {
            System.out.println("here4");
            System.out.println(queryResult.stream()
                    .filter(myDate -> (myDate.getCreatedAt().getTime() - date.getTime()) == 900000)
                    .collect(Collectors.toList()));

            return queryResult.stream()
                    .filter(myDate -> (date.getMinutes() -myDate.getCreatedAt().getMinutes()) == 15
                            &&( date.getDay()-myDate.getCreatedAt().getDay() )==0
                            && (date.getHours() - myDate.getCreatedAt().getHours()  )==0)
                    .collect(Collectors.toList());

        } catch (Exception exception) {
            exception.printStackTrace();
        }
        return new ArrayList<>();
    }


}
