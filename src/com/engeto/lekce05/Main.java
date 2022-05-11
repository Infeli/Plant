package com.engeto.lekce05;

import java.io.IOException;
import java.time.LocalDate;

public class Main {

    public static final String FILENAME = "kvetiny.txt";
    public static final String DELIMITER = "\t";

    public static void main(String[] args) {

        ListOfPlants plants = null;

        try{
            plants = ListOfPlants.importPlants(FILENAME, DELIMITER);
        }catch (PlantException ex){
            System.out.println("Loading error: " + FILENAME + "\n" + ex.getLocalizedMessage());
        }





    }
}
