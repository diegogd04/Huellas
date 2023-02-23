package com.dgd.huellas.app.api;

import com.dgd.huellas.domain.models.Adoption;
import com.dgd.huellas.domain.models.Animal;
import retrofit2.Call;
import retrofit2.http.GET;

import java.util.List;

public interface ApiService {

    @GET("animals.json")
    public Call<List<Animal>> getAnimals();
    @GET("adoptions.json")
    public Call<List<Adoption>> getAdoptions();
}
