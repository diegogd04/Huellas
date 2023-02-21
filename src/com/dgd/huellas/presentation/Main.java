package com.dgd.huellas.presentation;

import com.dgd.huellas.data.local.CatFileLocalDataSource;
import com.dgd.huellas.data.remote.CatApiRemoteDataSource;
import com.dgd.huellas.domain.models.Cat;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        //CatDataRepository
        CatApiRemoteDataSource remoteDataSource = new CatApiRemoteDataSource();
        List<Cat> cats = remoteDataSource.getCats();

        CatFileLocalDataSource fileLocalDataSource = CatFileLocalDataSource.getInstance();
        fileLocalDataSource.saveList(cats);
    }
}