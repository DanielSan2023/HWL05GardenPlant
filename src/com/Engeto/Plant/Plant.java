package com.Engeto.Plant;

import java.time.LocalDate;

public class Plant implements Comparable<Plant> {
    private String name;
    private String notes;
    private LocalDate dateOfPlanted;
    private LocalDate dateOfWatering;
    private int frequencyOfWatering;


    public Plant(String name, String notes, LocalDate dateOfPlanted, LocalDate dateOfWatering, int frequencyOfWatering) throws PlantException {
        this.name = name;
        this.notes = notes;
        setFrequencyOfWatering(frequencyOfWatering);
        setDateOfPlantedAndWatering(dateOfPlanted, dateOfWatering);
    }



    public Plant(String name, String notes, LocalDate planted, int frequencyOfWatering) throws PlantException {
        this(name, "", planted, LocalDate.now(), frequencyOfWatering); }

    public Plant(String name) throws PlantException {
        this(name, "", LocalDate.now(),LocalDate.now(), 7); }


    public Plant(String name, String notes) throws PlantException {
        this(name, notes, LocalDate.now(),LocalDate.now(), 7);
    }
    public Plant() {
    }




//region Get a Set
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



    public int getFrequencyOfWatering() {
        return frequencyOfWatering;
    }

    public void setFrequencyOfWatering(int frequencyOfWatering) throws PlantException {
        if (frequencyOfWatering <= 0) {
            throw new PlantException("Neplatná frekvence zálivky: " + frequencyOfWatering + ". Použita výchozí hodnota 7 dní.");
        }
        this.frequencyOfWatering = frequencyOfWatering;
    }

    public LocalDate getDateOfPlanted() {
        return dateOfPlanted;
    }

    public LocalDate getDateOfWatering() {
        return dateOfWatering;
    }

    public void setDateOfPlanted(LocalDate dateOfPlanted) throws PlantException {
        setDateOfPlantedAndWatering(dateOfPlanted, this.dateOfWatering);
    }

    public void setDateOfWatering(LocalDate dateOfWatering) throws PlantException {
        setDateOfPlantedAndWatering(this.dateOfPlanted, dateOfWatering);
    }

    private void setDateOfPlantedAndWatering(LocalDate dateOfPlanted, LocalDate dateOfWatering) throws PlantException {
        if (dateOfPlanted.isAfter(dateOfWatering)) {
            throw new PlantException("Datum poslední zálivky nemůže být starší než datum zasazení.");
        }
        this.dateOfPlanted = dateOfPlanted;
        this.dateOfWatering = dateOfWatering;
    }

    //endregion Get a Set

    public String getWateringInfoText() {
        LocalDate nextWateringDate = dateOfWatering.plusDays(frequencyOfWatering);
        return "Název: " + name + "\nDatum poslední zálivky: " + dateOfWatering + "\nDoporučené datum další zálivky: " + nextWateringDate;
    }

    public String getWateringInfo() {
        LocalDate nextWateringDate = dateOfWatering.plusDays(frequencyOfWatering);
        return  name + "\t" + dateOfWatering + "\t" + nextWateringDate;
    }

    @Override
    public String toString() {
        return "Plant{" +
                "name='" + name + '\'' +
                ", notes='" + notes + '\'' +
                ", dateOfPlanted=" + dateOfPlanted +
                ", dateOfWatering=" + dateOfWatering +
                ", frequencyOfWatering=" + frequencyOfWatering +
                '}';


             }

    @Override
    public int compareTo(Plant plant) {
        return this.name.compareTo(plant.getName());
    }

}
