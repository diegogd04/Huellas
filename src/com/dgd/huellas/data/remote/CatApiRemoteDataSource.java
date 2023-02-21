package com.dgd.huellas.data.remote;

import com.dgd.huellas.app.api.ApiClient;
import com.dgd.huellas.domain.models.Cat;
import retrofit2.Response;

import java.io.IOException;
import java.util.List;

public class CatApiRemoteDataSource {

    private ApiClient apiClient = new ApiClient();

    public List<Cat> getCats() {
        try {
            Response<List<Cat>> responseCats = apiClient.apiService.getCats().execute();
            if (responseCats.isSuccessful()) {
                return responseCats.body();
            } else {
                throw new RuntimeException();
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}
