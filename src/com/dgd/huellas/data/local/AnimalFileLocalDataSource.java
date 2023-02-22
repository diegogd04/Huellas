package com.dgd.huellas.data.local;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.dgd.huellas.domain.models.Animal;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;

public class AnimalFileLocalDataSource {

    private static AnimalFileLocalDataSource instance = null;

    private String nameFile = "animals.txt";

    private Gson gson = new Gson();

    private final Type typeAnimalList = new TypeToken<ArrayList<Animal>>() {
    }.getType();

    private AnimalFileLocalDataSource() {
    }

    public void save(Animal animal) {
        List<Animal> animals = findAll();
        animals.add(animal);
        saveToFile(animals);
    }

    public void remove(Animal animal){
        List<Animal> animals = findAll();
        animals.remove(animal);
        saveToFile(animals);
    }

    public void saveList(List<Animal> animals) {
        saveToFile(animals);
    }

    private void saveToFile(List<Animal> animals) {
        try {
            FileWriter myWriter = new FileWriter(nameFile);
            myWriter.write(gson.toJson(animals));
            myWriter.close();
            System.out.println("Datos guardados correctamente");
        } catch (IOException e) {
            System.out.println("Ha ocurrido un error al guardar la información.");
            e.printStackTrace();
        }
    }


    public Animal findById(Integer animalId) {
        List<Animal> animals = findAll();
        for (Animal animal : animals) {
            if (Objects.equals(animal.getId(), animalId)) {
                return animal;
            }
        }
        return null;
    }

    public List<Animal> findAll() {
        try {
            File myObj = new File(nameFile);
            Scanner myReader = new Scanner(myObj);
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                myReader.close();
                return gson.fromJson(data, typeAnimalList);
            }
            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("Ha ocurrido un error al obtener el listado.");
            e.printStackTrace();
        }
        return new ArrayList<Animal>();
    }

    public static AnimalFileLocalDataSource getInstance() {
        if (instance == null) {
            instance = new AnimalFileLocalDataSource();
        }
        return instance;
    }
}
