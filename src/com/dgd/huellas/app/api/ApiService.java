package com.dgd.huellas.app.api;

import com.dgd.huellas.domain.models.Cat;
import retrofit2.Call;
import retrofit2.http.GET;

import java.util.List;

public interface ApiService {

    @GET("cats.json")
    public Call<List<Cat>> getCats();
}
