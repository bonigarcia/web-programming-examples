package io.github.web.rest.client.retrofit;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import io.github.web.rest.service.Player;
import io.github.web.rest.service.Team;
import retrofit.RestAdapter;

public class RetrofitClient {

    private static final Logger log = LoggerFactory
            .getLogger(RetrofitClient.class);

    public static void main(String[] args) throws Exception {
        // GET
        RestAdapter adapter = new RestAdapter.Builder()
                .setEndpoint("http://localhost:8080").build();
        TeamsService service = adapter.create(TeamsService.class);
        Team team = service.getTeam(0);
        log.info("Response {}", team);

        // POST
        List<Player> players = new ArrayList<Player>();
        players.add(new Player("M.A.", "Barracus"));
        players.add(new Player("Murdock", "Crazy"));
        Team aTeam = new Team("A Team", players);
        boolean created = service.addTeam(aTeam);
        log.info("Created {}", created);
    }

}
