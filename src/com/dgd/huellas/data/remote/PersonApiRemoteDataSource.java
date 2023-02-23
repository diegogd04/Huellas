package com.dgd.huellas.data.remote;

import com.dgd.huellas.app.api.ApiClient;
import com.dgd.huellas.domain.models.Person;
import retrofit2.Response;

import java.io.IOException;
import java.util.List;

public class PersonApiRemoteDataSource {

    private ApiClient apiClient = new ApiClient();

    public List<Person> getPeople() {
        try {
            Response<List<Person>> responsePeople = apiClient.apiService.getPeople().execute();
            if (responsePeople.isSuccessful()) {
                return responsePeople.body();
            } else {
                throw new RuntimeException();
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}
