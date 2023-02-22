package com.dgd.huellas.domain.usecase;

import com.dgd.huellas.data.local.PersonFileLocalDataSource;
import com.dgd.huellas.domain.models.Person;

public class GetPersonUseCase {
    private PersonFileLocalDataSource dataSource = PersonFileLocalDataSource.getInstance();

    public Person execute(Integer id){
        return dataSource.findById(id);
    }
}
