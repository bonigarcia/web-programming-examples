package io.github.web.rest.client.retrofit;

import java.util.List;

import io.github.web.rest.service.Team;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface TeamsClient {

    @GET("/teams")
    Call<List<Team>> getTeams();

    @GET("/team/{index}")
    Call<Team> getTeamByPath(@Path("index") int index);

    @GET("/team")
    Call<Team> getTeamByQuery(@Query("index") int index);

    @POST("/teams")
    Call<Integer> addTeam(@Body Team team);

}
