package io.github.web.rest.client.retrofit;

import java.util.List;

import retrofit.http.Body;
import retrofit.http.GET;
import retrofit.http.POST;
import retrofit.http.Path;

import io.github.web.rest.service.Team;

public interface TeamsService {

	@GET("/teams")
	List<Team> getTeams();

	@GET("/team/{index}")
	Team getTeam(@Path("index") int index);

	@POST("/teams")
	boolean addTeam(@Body Team team);
}
