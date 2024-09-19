package br.ufc.quixada.usoroomdatabase.Services;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface GitHubServices<Repo> {
       @GET("users/{user}/repos")
       Call<List<Repo>> listRepos(@Path("user") String user);
    }