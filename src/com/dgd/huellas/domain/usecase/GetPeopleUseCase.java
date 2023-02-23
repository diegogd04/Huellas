package com.dgd.huellas.domain.usecase;

import com.dgd.huellas.data.local.PersonFileLocalDataSource;
import com.dgd.huellas.domain.models.Person;

import java.util.List;

public class GetPeopleUseCase {
    private PersonFileLocalDataSource dataSource = PersonFileLocalDataSource.getInstance();

    public List<Person> execute() {
        return dataSource.findAll();
    }
}
