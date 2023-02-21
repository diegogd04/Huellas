package com.dgd.huellas.data.remote;

import com.dgd.huellas.app.api.ApiClient;
import com.dgd.huellas.domain.models.Animal;
import retrofit2.Response;

import java.io.IOException;
import java.util.List;

public class AnimalApiRemoteDataSource {

    private ApiClient apiClient = new ApiClient();

    public List<Animal> getAnimals() {
        try {
            Response<List<Animal>> responseAnimals = apiClient.apiService.getAnimals().execute();
            if (responseAnimals.isSuccessful()) {
                return responseAnimals.body();
            } else {
                throw new RuntimeException();
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}
