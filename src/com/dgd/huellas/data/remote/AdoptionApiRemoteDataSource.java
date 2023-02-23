package com.dgd.huellas.data.remote;

import com.dgd.huellas.app.api.ApiClient;
import com.dgd.huellas.domain.models.Adoption;
import retrofit2.Response;

import java.io.IOException;
import java.util.List;

public class AdoptionApiRemoteDataSource {

    private ApiClient apiClient = new ApiClient();

    public List<Adoption> getAdoptions() {
        try {
            Response<List<Adoption>> responseAdoptions = apiClient.apiService.getAdoptions().execute();
            if (responseAdoptions.isSuccessful()) {
                return responseAdoptions.body();
            } else {
                throw new RuntimeException();
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}
