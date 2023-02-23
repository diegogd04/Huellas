package com.dgd.huellas.data.remote;

import com.dgd.huellas.app.api.ApiClient;
import com.dgd.huellas.domain.models.Partner;
import retrofit2.Response;

import java.io.IOException;
import java.util.List;

public class PartnerApiRemoteDataSource {

    private ApiClient apiClient = new ApiClient();

    public List<Partner> getPartners() {
        try {
            Response<List<Partner>> responsePartners = apiClient.apiService.getPartners().execute();
            if (responsePartners.isSuccessful()) {
                return responsePartners.body();
            } else {
                throw new RuntimeException();
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}
