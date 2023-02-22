package com.dgd.huellas.data.local;

import com.dgd.huellas.domain.models.Animal;
import com.dgd.huellas.domain.models.Person;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;

public class PersonFileLocalDataSource {

    private static PersonFileLocalDataSource instance = null;

    private String nameFile = "people.txt";

    private Gson gson = new Gson();

    private final Type typePersonList = new TypeToken<ArrayList<Person>>() {
    }.getType();

    private PersonFileLocalDataSource() {
    }

    public void save(Person person) {
        List<Person> people = findAll();
        people.add(person);
        saveToFile(people);
    }

    public void remove(Person person){
        List<Person> people = findAll();
        people.remove(person);
        saveToFile(people);
    }

    public void saveList(List<Person> people) {
        saveToFile(people);
    }

    private void saveToFile(List<Person> people) {
        try {
            FileWriter myWriter = new FileWriter(nameFile);
            myWriter.write(gson.toJson(people));
            myWriter.close();
            System.out.println("Datos guardados correctamente");
        } catch (IOException e) {
            System.out.println("Ha ocurrido un error al guardar la información.");
            e.printStackTrace();
        }
    }


    public Person findById(Integer personId) {
        List<Person> people = findAll();
        for (Person person : people) {
            if (Objects.equals(person.getId(), personId)) {
                return person;
            }
        }
        return null;
    }

    public List<Person> findAll() {
        try {
            File myObj = new File(nameFile);
            Scanner myReader = new Scanner(myObj);
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                myReader.close();
                return gson.fromJson(data, typePersonList);
            }
            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("Ha ocurrido un error al obtener el listado.");
            e.printStackTrace();
        }
        return new ArrayList<Person>();
    }

    public static PersonFileLocalDataSource getInstance() {
        if (instance == null) {
            instance = new PersonFileLocalDataSource();
        }
        return instance;
    }
}
