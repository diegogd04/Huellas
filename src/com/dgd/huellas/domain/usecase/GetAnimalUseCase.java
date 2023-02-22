package com.dgd.huellas.domain.usecase;

import com.dgd.huellas.data.local.AnimalFileLocalDataSource;
import com.dgd.huellas.domain.models.Animal;

public class GetAnimalUseCase {
    private AnimalFileLocalDataSource dataSource = AnimalFileLocalDataSource.getInstance();

    public Animal execute(Integer id){
        return dataSource.findById(id);
    }
}
