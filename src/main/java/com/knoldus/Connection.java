package com.knoldus;

import java.io.IOException;
import twitter4j.Twitter;
import twitter4j.TwitterException;
import twitter4j.TwitterFactory;
import twitter4j.conf.ConfigurationBuilder;

public class Connection {
    private final static String CONSUMER_KEY = "e6uS4phTxImI68qlA6h4V3zwR";
    private final static String CONSUMER_KEY_SECRET = "M8b4Q3sudgU9mNZgJx1onUlqQYi5h5YCK1GVacjAc8yHDAohFc";
    private final static String ACCESS_TOKEN="160922224-AKOoOasbqi3huqT7uyq4Og0Oqlucn8rKeD9IcUvU";
    private final static String ACCESS_TOKEN_SECRET="7HgIJUmjOX2AZThvVp7RPWsZwOrW1ffpvkEpjeBSQynnH";

    public Twitter start() throws TwitterException, IOException {

        ConfigurationBuilder builder = new ConfigurationBuilder();
        builder.setOAuthAccessToken(ACCESS_TOKEN);
        builder.setOAuthAccessTokenSecret(ACCESS_TOKEN_SECRET);
        builder.setOAuthConsumerKey(CONSUMER_KEY);
        builder.setOAuthConsumerSecret(CONSUMER_KEY_SECRET);
        TwitterFactory twitterFactory = new TwitterFactory(builder.build());
        Twitter twitter = twitterFactory.getInstance();
        System.out.println(twitter);
        return twitter;

    }


}