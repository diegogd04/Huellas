package com.dgd.huellas.domain.usecase;

import com.dgd.huellas.data.local.AdoptionFileLocalDataSource;
import com.dgd.huellas.domain.models.Adoption;
import com.dgd.huellas.domain.models.Animal;

public class AddAdoption {
    private AdoptionFileLocalDataSource dataSource = AdoptionFileLocalDataSource.getInstance();

    public void execute(Adoption adoption) {
        dataSource.save(adoption);
    }
}
