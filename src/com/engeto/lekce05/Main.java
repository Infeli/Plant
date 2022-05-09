package com.engeto.lekce05;

import java.time.LocalDate;

public class Main {

    public static final String FILENAME = "kvetiny.txt";
    public static final String DELIMITER = "\t";

    public static void main(String[] args) {

        ListOfPlants plants = null;
        try{
            plants = ListOfPlants.importFromFile(FILENAME, DELIMITER);

        }catch (PlantException ex){
            System.out.println("Loading error: \n" + FILENAME + "\n" + ex.getLocalizedMessage());
        }

        Plant p1 = new Plant("Fialka", "Bez popisu", LocalDate.of(2022, 05, 9), LocalDate.of(2022, 05, 15), 3);

        p1.getWateringInfo();
    }
}
