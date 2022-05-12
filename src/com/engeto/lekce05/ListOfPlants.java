package com.engeto.lekce05;

import java.io.*;
import java.lang.invoke.StringConcatException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ListOfPlants {


    private List<Plant> plantList = new ArrayList<>(); // vytvoření kolekce

    public static ListOfPlants importPlants (String filename, String delimiter) throws PlantException {
        String nextLine = "";
        String[] items = new String[1];
        String name;
        String notes;
        int frequencyOfWatering;
        LocalDate planted;
        LocalDate watering;
        int lineNumber = 0;


        ListOfPlants result = new ListOfPlants();


        try (Scanner scanner = new Scanner(new BufferedReader(new FileReader(filename)))) {
            while (scanner.hasNextLine()) {
                lineNumber++;
                nextLine = scanner.nextLine();
                System.out.println(nextLine); // kontrola

                // rozdělení na objekty
                items = nextLine.split(delimiter);
                name = items[0];
                notes = items[1];
                planted = LocalDate.parse(items[2]);
                watering = LocalDate.parse(items[3]);
                frequencyOfWatering = Integer.parseInt(items[4]);

                result.addPlant(new Plant(name, notes, planted, watering, frequencyOfWatering));

            }

        } catch (StringIndexOutOfBoundsException ex) {
            throw new PlantException("Špatně zadaný název: " + items[0] + " na řádku číslo: " + lineNumber + "\n" + ex.getLocalizedMessage());

        }
        catch (FileNotFoundException ex) {
            throw new PlantException("File: " + filename + " has not been found ... " + ex.getLocalizedMessage());
        }
        return result;
    }

    public void writeToFile(String filename, String delimiter){
        try(BufferedWriter writer = new BufferedWriter(new FileWriter(filename))){
            for(Plant plant : plantList){
                writer.write(plant.getName() +
                        delimiter +
                        plant.getNotes() + delimiter +
                        plant.getPlanted() + delimiter +
                        plant.getWatering() + delimiter +
                        plant.getFrequencyOfWatering() + "\n");

            }
        } catch (Exception ex){
            ex.printStackTrace();
        }
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
