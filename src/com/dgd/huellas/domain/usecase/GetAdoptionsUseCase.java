package com.dgd.huellas.domain.usecase;

import com.dgd.huellas.data.local.AdoptionFileLocalDataSource;
import com.dgd.huellas.domain.models.Adoption;

import java.util.List;

public class GetAdoptionsUseCase {
    private AdoptionFileLocalDataSource dataSource = AdoptionFileLocalDataSource.getInstance();

    public List<Adoption> execute() {
        return dataSource.findAll();
    }
}
