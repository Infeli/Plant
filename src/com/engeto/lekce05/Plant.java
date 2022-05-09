package com.engeto.lekce05;

import java.time.LocalDate;

public class Plant {
    private String name;
    private String notes;
    private LocalDate planted;
    private LocalDate watering;
    private int frequencyOfWatering;


    public Plant(String name, String notes, LocalDate planted, LocalDate watering, int frequencyOfWatering){
        this.name = name;
        this.notes = notes;
        this.planted = planted;
        this.watering = watering;
        this.frequencyOfWatering = frequencyOfWatering;
    }

    public Plant(String name, LocalDate planted, int frequencyOfWatering){
        this.name = name;
        this.notes = " ";
        this.planted = planted;
        this.watering = LocalDate.now();
        this.frequencyOfWatering = frequencyOfWatering;
    }

    public Plant(String name){
        this.name = name;
        this.notes = " ";
        this.planted = LocalDate.now();
        this.watering = LocalDate.now();
        this.frequencyOfWatering = 7;

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public LocalDate getPlanted() {
        return planted;
    }

    public void setPlanted(LocalDate planted) {
        this.planted = planted;
    }

    public LocalDate getWatering() {
        return watering;
    }

    public void setWatering(LocalDate watering) throws PlantException{
        if(watering.isBefore(planted)){
            throw new PlantException("You watering date is before you've planted a plant ?!");
        }
        this.watering = watering;
    }

    public int getFrequencyOfWatering(){
        return frequencyOfWatering;
    }

    public void setFrequencyOfWatering(int frequencyOfWatering) throws PlantException{
        if(frequencyOfWatering <= 0){
            throw new PlantException("Frequency of watering must not be zero or a negative number! ");
        }
        this.frequencyOfWatering = frequencyOfWatering;
    }

    public String getWateringInfo(){
        return "Name: " + name +
                "\n last flooded: " + watering +
                "\n next flood: " + watering.plusDays(frequencyOfWatering);
    }
}
