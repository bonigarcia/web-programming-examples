package io.github.web.rest.client.spring;

import org.springframework.web.client.RestTemplate;

import io.github.web.rest.service.Team;

public class SpringRestClient {

    public static void main(String[] args) throws Exception {
        RestTemplate restTemplate = new RestTemplate();
        String url = "http://localhost:8080/team/1";
        Team team = restTemplate.getForObject(url, Team.class);
        System.out.println(team);
    }

}
