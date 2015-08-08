package com.mechanitis.demo.sense.user;

import com.mechanitis.demo.sense.infrastructure.Service;
import com.mechanitis.demo.sense.twitter.TweetParser;

public class UserService implements Runnable {
    private final Service<TwitterUser> service;

    public UserService() {
        // TODO: create a new service that points to the twitter service,
        // and serves its own data at on port 8083 and uri /users/
        service = new Service<>("ws://localhost:8081/tweets/", "/users/", 8083, message -> {
//            System.out.println(" **************************** received message: " + message + "\n ********************************************************************");
            return new TwitterUser(TweetParser.getTwitterHandleFrom(message));
        });
    }

    @Override
    public void run() {
        service.run();
    }

    public void stop() throws Exception {
        service.stop();
    }

    public static void main(String[] args) {
        new UserService().run();
    }
}
