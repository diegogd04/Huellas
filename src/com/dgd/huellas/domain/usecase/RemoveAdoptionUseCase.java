package com.dgd.huellas.domain.usecase;

import com.dgd.huellas.data.local.AdoptionFileLocalDataSource;
import com.dgd.huellas.domain.models.Adoption;

public class RemoveAdoptionUseCase {
    private AdoptionFileLocalDataSource dataSource = AdoptionFileLocalDataSource.getInstance();

    public void execute(Adoption adoption){
        dataSource.remove(adoption);
    }
}
