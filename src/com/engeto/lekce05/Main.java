package com.engeto.lekce05;

import java.nio.file.Files;
import java.nio.file.Path;
import java.time.LocalDate;
import java.util.logging.Logger;

public class Main {

    public static final String FILENAME = "kvetiny.txt";
    public static final String DELIMITER = "\t";
    public static final String COPY = "kvetiny-copy.txt";

    static Logger logger =Logger.getLogger("com.engeto.lekce05");

    public static void main(String[] args) {

        ListOfPlants plants = null;

        try{
            plants = ListOfPlants.importPlants(FILENAME, DELIMITER);
        }catch (PlantException ex){
            logger.warning("Loading error: " + FILENAME + "\n" + ex.getLocalizedMessage());
        }

        // Vytvoření 2 nových květin
        Plant p1 = new Plant("Pampeliška", " ", LocalDate.of(2022, 05, 10),LocalDate.of(2022, 05, 11), 5);
        Plant p2 = new Plant("Tulipán", " bez poznámky", LocalDate.of(2022, 05, 10),LocalDate.of(2022, 05, 11), 5);

        // přidání do kolekce
        plants.addPlant(p1);
        plants.addPlant(p2);

        // odebrání květiny 2 z kolekce
        plants.removePlant(p2);

        // zápis do kolekce
        plants.writeToFile(FILENAME, DELIMITER);

        // Vytvoření kopie

        try {
            Files.copy(Path.of(FILENAME), Path.of(COPY));
        }catch (Exception ex){
            logger.warning("Error" + ex.getMessage());
        }

    }
}
