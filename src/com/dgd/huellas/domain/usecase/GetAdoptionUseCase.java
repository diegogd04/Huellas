package com.dgd.huellas.domain.usecase;

import com.dgd.huellas.data.local.AdoptionFileLocalDataSource;
import com.dgd.huellas.domain.models.Adoption;

public class GetAdoptionUseCase {
    private AdoptionFileLocalDataSource dataSource = AdoptionFileLocalDataSource.getInstance();

    public Adoption execute(Integer id){
        return dataSource.findById(id);
    }
}
