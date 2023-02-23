package com.dgd.huellas.app.api;

import com.dgd.huellas.domain.models.Adoption;
import com.dgd.huellas.domain.models.Animal;
import com.dgd.huellas.domain.models.Partner;
import com.dgd.huellas.domain.models.Person;
import retrofit2.Call;
import retrofit2.http.GET;

import java.util.List;

public interface ApiService {

    @GET("animals.json")
    public Call<List<Animal>> getAnimals();
    @GET("adoptions.json")
    public Call<List<Adoption>> getAdoptions();
    @GET("people.json")
    public Call<List<Person>> getPeople();
    @GET("partners.json")
    public Call<List<Partner>> getPartners();
}
