package io.github.web.rest.client.jackson;

import java.net.URL;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.fasterxml.jackson.databind.ObjectMapper;

import io.github.web.rest.service.Team;

public class JacksonClient {

    private static final Logger log = LoggerFactory
            .getLogger(JacksonClient.class);

    public static void main(String[] args) throws Exception {
        // Create Jackson parser
        ObjectMapper mapper = new ObjectMapper();

        // Make request
        URL url = new URL("http://localhost:8080/team/0");
        Team team = mapper.readValue(url, Team.class);
        log.info("Response {}", team);
    }

}
