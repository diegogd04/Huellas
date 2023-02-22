package com.dgd.huellas.domain.usecase;

import com.dgd.huellas.data.local.PersonFileLocalDataSource;
import com.dgd.huellas.domain.models.Person;

public class RemovePersonUseCase {
    private PersonFileLocalDataSource dataSource = PersonFileLocalDataSource.getInstance();

    public void execute(Person person){
        dataSource.remove(person);
    }
}
