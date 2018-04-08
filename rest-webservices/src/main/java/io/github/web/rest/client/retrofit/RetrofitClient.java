package io.github.web.rest.client.retrofit;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import io.github.web.rest.service.Player;
import io.github.web.rest.service.Team;
import okhttp3.ResponseBody;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.jackson.JacksonConverterFactory;

public class RetrofitClient {

    private static final Logger log = LoggerFactory
            .getLogger(RetrofitClient.class);

    public static void main(String[] args) throws Exception {
        // REST client
        String serviceUrl = "http://localhost:8080";
        Retrofit retrofit = new Retrofit.Builder()
                .addConverterFactory(JacksonConverterFactory.create())
                .baseUrl(serviceUrl).build();
        TeamsClient teamsClient = retrofit.create(TeamsClient.class);

        // GET
        Response<Team> getResponse = teamsClient.getTeamByPath(0).execute();
        int getResponseCode = getResponse.code();
        Team getResponseBody = getResponse.body();
        log.info("GET response: {} {}", getResponseCode, getResponseBody);

        // POST
        List<Player> players = new ArrayList<>();
        players.add(new Player("M.A.", "Barracus"));
        players.add(new Player("Murdock", "Crazy"));
        Team aTeam = new Team("A Team", players);
        Response<ResponseBody> postResponse = teamsClient.addTeam(aTeam)
                .execute();
        int postResponseCode = postResponse.code();
        log.info("POST response: code {}", postResponseCode);
    }

}
