package com.dgd.huellas.presentation;

import com.dgd.huellas.data.local.AnimalFileLocalDataSource;
import com.dgd.huellas.data.remote.AnimalApiRemoteDataSource;
import com.dgd.huellas.domain.models.Animal;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        //CatDataRepository
        AnimalApiRemoteDataSource remoteDataSource = new AnimalApiRemoteDataSource();
        List<Animal> animals = remoteDataSource.getAnimals();

        AnimalFileLocalDataSource fileLocalDataSource = AnimalFileLocalDataSource.getInstance();
        fileLocalDataSource.saveList(animals);
    }
}