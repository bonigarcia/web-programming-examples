package io.github.web.rest.client.retrofit;

import java.util.ArrayList;
import java.util.List;

import retrofit.RestAdapter;

import io.github.web.rest.service.Player;
import io.github.web.rest.service.Team;

public class RetrofitClient {

    public static void main(String[] args) throws Exception {
        // GET
        RestAdapter adapter = new RestAdapter.Builder()
                .setEndpoint("http://localhost:8080").build();
        TeamsService service = adapter.create(TeamsService.class);
        Team team = service.getTeam(0);
        System.out.println(team);

        // POST
        List<Player> players = new ArrayList<Player>();
        players.add(new Player("M.A.", "Barracus"));
        players.add(new Player("Murdock", "Crazy"));
        Team aTeam = new Team("A Team", players);
        boolean created = service.addTeam(aTeam);
        System.out.println("Created: " + created);

    }

}
