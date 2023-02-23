package com.dgd.huellas.data.local;

import com.dgd.huellas.domain.models.Partner;
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

public class PartnerFileLocalDataSource {

    private static PartnerFileLocalDataSource instance = null;

    private String nameFile = "partners.txt";

    private Gson gson = new Gson();

    private final Type typePartnerList = new TypeToken<ArrayList<Partner>>() {
    }.getType();

    private PartnerFileLocalDataSource() {
    }

    public void save(Partner partner) {
        List<Partner> partners = findAll();
        partners.add(partner);
        saveToFile(partners);
    }

    public void remove(Partner partner){
        List<Partner> partners = findAll();
        partners.remove(partner);
        saveToFile(partners);
    }

    public void saveList(List<Partner> partners) {
        saveToFile(partners);
    }

    private void saveToFile(List<Partner> animals) {
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


    public Partner findById(Integer partnerId) {
        List<Partner> partners = findAll();
        for (Partner partner : partners) {
            if (Objects.equals(partner.getId(), partnerId)) {
                return partner;
            }
        }
        return null;
    }

    public List<Partner> findAll() {
        try {
            File myObj = new File(nameFile);
            Scanner myReader = new Scanner(myObj);
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                myReader.close();
                return gson.fromJson(data, typePartnerList);
            }
            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("Ha ocurrido un error al obtener el listado.");
            e.printStackTrace();
        }
        return new ArrayList<Partner>();
    }

    public static PartnerFileLocalDataSource getInstance() {
        if (instance == null) {
            instance = new PartnerFileLocalDataSource();
        }
        return instance;
    }
}
