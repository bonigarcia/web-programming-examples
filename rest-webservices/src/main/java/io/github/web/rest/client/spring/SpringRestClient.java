package io.github.web.rest.client.spring;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.client.RestTemplate;

import io.github.web.rest.client.jackson.JacksonClient;
import io.github.web.rest.service.Team;

public class SpringRestClient {

    private static final Logger log = LoggerFactory
            .getLogger(JacksonClient.class);

    public static void main(String[] args) throws Exception {
        RestTemplate restTemplate = new RestTemplate();
        String url = "http://localhost:8080/team/1";
        Team team = restTemplate.getForObject(url, Team.class);
        log.info("Response {}", team);
    }

}
