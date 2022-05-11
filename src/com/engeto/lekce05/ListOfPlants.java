package com.engeto.lekce05;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ListOfPlants {


    private List<Plant> plantList = new ArrayList<>(); // vytvoření kolekce

    public static ListOfPlants importPlants (String filename, String delimiter) throws PlantException{

        ListOfPlants result = new ListOfPlants();

        try(Scanner scanner = new Scanner(new BufferedReader(new FileReader(filename)))){
            while (scanner.hasNextLine()){
                String nextLine = scanner.nextLine();
                System.out.println(nextLine); // kontrola

                // rozdělení na objekty
                String[] items = nextLine.split(delimiter);
                String name = items[0];
                String notes = items[1];
                int frequencyOfWatering = Integer.parseInt(items[2]);
                LocalDate planted = LocalDate.parse(items[3]);
                LocalDate watering = LocalDate.parse(items[4]);

                result.addPlant(new Plant(name, notes, planted, watering, frequencyOfWatering));

            }

        }catch (FileNotFoundException ex){
            throw new PlantException("File: " + filename + " has not been found ... " + ex.getLocalizedMessage());
        }
        return result;
    }

    public void addPlant(Plant plant){
        plantList.add(plant);
    }

    public void removePlant(Plant plant){
        plantList.remove(plant);
    }

    public void readPlant(Plant plant){

        plantList.indexOf(plant); //get index
    }
}
