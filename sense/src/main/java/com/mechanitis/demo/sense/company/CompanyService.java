package com.mechanitis.demo.sense.company;

import com.mechanitis.demo.sense.infrastructure.Service;
import com.mechanitis.demo.sense.mood.MoodyMessage;

import javax.websocket.DeploymentException;
import java.io.IOException;
import java.util.Set;

public class CompanyService implements Runnable {
    private final Service<CompanyMessage> service;

    public CompanyService() {
        // TODO: create a new service that connects to twitter,
        // and serves stuff at port 8082 and uri /moods/
        service = new Service<>("ws://localhost:8081/tweets/", "/companies/", 8082, CompanyExtractor::extractCompany);
    }

    @Override
    public void run() {
        service.run();
    }

    public void stop() throws Exception {
        service.stop();
    }

    public static void main(String[] args) throws IOException, DeploymentException {
        new CompanyService().run();
    }
}
