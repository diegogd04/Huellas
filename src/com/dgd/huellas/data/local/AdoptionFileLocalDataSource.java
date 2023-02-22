package com.dgd.huellas.data.local;

import com.dgd.huellas.domain.models.Adoption;
import com.dgd.huellas.domain.models.Animal;
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

public class AdoptionFileLocalDataSource {

    private static AdoptionFileLocalDataSource instance = null;

    private String nameFile = "adoptions.txt";

    private Gson gson = new Gson();

    private final Type typeAdoptionList = new TypeToken<ArrayList<Adoption>>() {
    }.getType();

    private AdoptionFileLocalDataSource() {
    }

    public void save(Adoption adoption) {
        List<Adoption> adoptions = findAll();
        adoptions.add(adoption);
        saveToFile(adoptions);
    }

    public void saveList(List<Adoption> adoptions) {
        saveToFile(adoptions);
    }

    private void saveToFile(List<Adoption> adoptions) {
        try {
            FileWriter myWriter = new FileWriter(nameFile);
            myWriter.write(gson.toJson(adoptions));
            myWriter.close();
            System.out.println("Datos guardados correctamente");
        } catch (IOException e) {
            System.out.println("Ha ocurrido un error al guardar la información.");
            e.printStackTrace();
        }
    }


    public Adoption findById(Integer adoptionId) {
        List<Adoption> adoptions = findAll();
        for (Adoption adoption : adoptions) {
            if (Objects.equals(adoption.getId(), adoptionId)) {
                return adoption;
            }
        }
        return null;
    }

    public List<Adoption> findAll() {
        try {
            File myObj = new File(nameFile);
            Scanner myReader = new Scanner(myObj);
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                myReader.close();
                return gson.fromJson(data, typeAdoptionList);
            }
            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("Ha ocurrido un error al obtener el listado.");
            e.printStackTrace();
        }
        return new ArrayList<Adoption>();
    }

    public static AdoptionFileLocalDataSource getInstance() {
        if (instance == null) {
            instance = new AdoptionFileLocalDataSource();
        }
        return instance;
    }
}
