package com.dgd.huellas.presentation;

import com.dgd.huellas.data.local.AnimalFileLocalDataSource;
import com.dgd.huellas.data.remote.AnimalApiRemoteDataSource;
import com.dgd.huellas.domain.models.*;
import com.dgd.huellas.domain.usecase.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Main main = new Main();

        Scanner sc = new Scanner(System.in);

        int opcion;
        boolean salir = false;

        do {
            System.out.println("PROTECTORA HUELLAS");
            System.out.println("------------------");
            System.out.println("1. Añadir un gato.");
            System.out.println("2. Eliminar un gato.");
            System.out.println("3. Listar gatos.");
            System.out.println("4. Añadir persona.");
            System.out.println("5. Crear una nueva adopción.");
            System.out.println("6. Listar adopciones realizadas.");
            System.out.println("7. Salir");
            System.out.println();
            System.out.print("Introduce el número de la opción que desea realizar -> ");
            opcion = sc.nextInt();

            switch (opcion){
                case 1:
                    System.out.println("AÑADIR UN GATO");
                    System.out.println("--------------");
                    main.AddCat();
                    break;
                case 2:
                    System.out.println("ELIMINAR UN GATO");
                    System.out.println("----------------");
                    main.RemoveCat();
                    break;
                case 3:
                    System.out.println("LISTAR GATOS");
                    System.out.println("------------");
                    main.GetCats();
                    break;
                case 4:
                    System.out.println("AÑADIR PERSONA");
                    System.out.println("--------------");
                    main.AddPerson();
                    break;
                case 5:
                    System.out.println("CREAR UNA NUEVA ADOPCIÓN");
                    System.out.println("------------------------");
                    main.AddAdopcion();
                    break;
                case 6:
                    System.out.println("LISTAR ADOPCIONES REALIZADAS");
                    System.out.println("----------------------------");
                    main.GetAdoptions();
                    break;
                case 7:
                    salir = true;
                    break;
            }
        } while (!salir);
    }

    public void AddCat() {
        Scanner sc = new Scanner(System.in);

        Animal animal = new Animal();
        Cat cat = new Cat();

        int id;
        String name, birthdate, sex;
        Boolean virus;

        System.out.print("Introduce el identificador -> ");
        animal.setId(id = sc.nextInt());
        System.out.print("Introduce el nombre -> ");
        animal.setName(name = sc.nextLine());
        System.out.print("Introduce la fecha de nacimiento -> ");
        animal.setBirthdate(birthdate = sc.nextLine());
        System.out.print("Introduce el sexo -> ");
        animal.setSex(sex = sc.nextLine());
        System.out.print("Introduce si tiene el virus de la leucemia felina -> ");
        cat.setVirus(virus = sc.nextBoolean());

        AddAnimalUseCase addAnimalUseCase = new AddAnimalUseCase();
        addAnimalUseCase.execute(animal);
    }
    public void RemoveCat() {
        Scanner sc = new Scanner(System.in);

        Animal animal = new Animal();

        int id;

        System.out.print("Introduce el identificador -> ");
        id = sc.nextInt();

        if (animal.getId() == id){
            RemoveAnimalUseCase removeAnimalUseCase = new RemoveAnimalUseCase();
            removeAnimalUseCase.execute(animal);
        }
    }
    public void GetCats() {
        Animal animal = new Animal();

        GetAnimalsUseCase getAnimalsUseCase = new GetAnimalsUseCase();
        getAnimalsUseCase.execute(animal);
    }
    public void AddPerson() {
        Scanner sc = new Scanner(System.in);

        Person person = new Person();

        int id;
        String name, surnames, dni, birthdate, address;

        System.out.print("Introduce el identificador -> ");
        person.setId(id = sc.nextInt());
        System.out.print("Introduce el nombre -> ");
        person.setName(name = sc.nextLine());
        System.out.print("Introduce los apellidos -> ");
        person.setSurnames(surnames = sc.nextLine());
        System.out.print("Introduce el dni -> ");
        person.setDni(dni = sc.nextLine());
        System.out.print("Introduce la fecha de nacimiento -> ");
        person.setBirthday(birthdate = sc.nextLine());
        System.out.print("Introduce tu dirección -> ");
        person.setAddress(address = sc.nextLine());

        AddPersonUseCase addPersonUseCase = new AddPersonUseCase();
        addPersonUseCase.execute(person);
    }
    public void AddAdopcion() {
        Scanner sc = new Scanner(System.in);

        Adoption adoption = new Adoption();
        Person person = new Person();
        Animal animal = new Animal();

        int id, personAdoptar, animalAdoptar;;
        String adoptionDate;

        System.out.print("Introduce el identificador -> ");
        adoption.setId(id = sc.nextInt());
        System.out.print("Introduce la fecha de adopción -> ");
        adoption.setAdoptionDate(adoptionDate = sc.nextLine());
        System.out.print("Introduce el identificador de la persona que adopta -> ");
        personAdoptar = sc.nextInt();
        if (personAdoptar == person.getId()){
            adoption.setPerson(person);
        }
        System.out.print("Introduce el identificador del animal que se adopta -> ");
        animalAdoptar = sc.nextInt();
        if (animalAdoptar == animal.getId()){
            adoption.setAnimal(animal);
        }

        AddAdoptionUseCase addAdoptionUseCase = new AddAdoptionUseCase();
        addAdoptionUseCase.execute(adoption);
    }
    public void GetAdoptions() {
        Adoption adoption = new Adoption();

        GetAdoptionsUseCase getAdoptionsUseCase = new GetAdoptionsUseCase();
        getAdoptionsUseCase.execute(adoption);
    }
}