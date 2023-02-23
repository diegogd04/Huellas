package com.dgd.huellas.domain.usecase;

import com.dgd.huellas.data.local.AnimalFileLocalDataSource;
import com.dgd.huellas.domain.models.Animal;

import java.util.List;

public class GetAnimalsUseCase {
    private AnimalFileLocalDataSource dataSource = AnimalFileLocalDataSource.getInstance();

    public List<Animal> execute() {
        return dataSource.findAll();
    }
}
