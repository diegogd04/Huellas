package com.dgd.huellas.domain.usecase;

import com.dgd.huellas.data.local.AnimalFileLocalDataSource;
import com.dgd.huellas.domain.models.Animal;

public class RemoveAnimalUseCase {
    private AnimalFileLocalDataSource dataSource = AnimalFileLocalDataSource.getInstance();

    public void execute(Animal animal) {
        dataSource.remove(animal);
    }
}
