package io.github.web.rest.client.jackson;

import java.net.HttpURLConnection;
import java.net.URL;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.github.web.rest.service.Team;

public class JacksonClient {

    public static void main(String[] args) throws Exception {
        // Http request
        URL url = new URL("http://localhost:8080/team/0");
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.connect();

        // Configure Jackson parser
        ObjectMapper mapper = new ObjectMapper();

        // Parse response
        Team team = mapper.readValue(conn.getInputStream(), Team.class);

        // Use response
        System.out.println(team);
    }

}
