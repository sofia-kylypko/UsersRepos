package com.test.usersrepos;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface Api {
    @GET("users/{user}/repos")
    Call<List<Repo>> getRepo(@Path("user") String user);

}
