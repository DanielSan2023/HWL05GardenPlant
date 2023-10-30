package com.Engeto.Plant;

import java.time.LocalDate;

public class Plant implements Comparable<Plant> {
    private String name;
    private String notes;
    private LocalDate dateOfPlanted;
    private LocalDate dateOfWatering;
    private int frequencyOfWatering;


    public Plant(String name, String notes, LocalDate dateOfPlanted,
                 LocalDate dateOfWatering, int frequencyOfWatering) {
        this.name = name;
        this.notes = notes;
        // Kontrola frekvence zalévání
        try {
            if (frequencyOfWatering <= 0) {
                throw new PlantException("Neplatna frekvence zálivky: " + frequencyOfWatering + "  pouzil som vychodzie nastavenie na 7 dni ");
            }
            this.frequencyOfWatering = frequencyOfWatering;
        } catch (PlantException e) {
            System.err.println("Chyba při vytváření rostliny: " + e.getMessage());
            this.frequencyOfWatering = 7; // Nastavení výchozí frekvence na 7 dní
        }
        // Kontrola datumu zálivky
        try {
            if (dateOfPlanted.isAfter(dateOfWatering)) {
                throw new PlantException("Datum poslední zálivky nemůže být starší než datum zasazení.");
            }
            this.dateOfPlanted = dateOfPlanted;
            this.dateOfWatering = dateOfWatering;
        } catch (PlantException e) {
            System.err.println("Chyba při vytváření rostliny - datum: " + e.getMessage());
            this.dateOfPlanted = LocalDate.now();
            this.dateOfWatering = LocalDate.now();
        }
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

    public LocalDate getDateOfPlanted() {
        return dateOfPlanted;
    }

    public void setDateOfPlanted(LocalDate dateOfPlanted) {
        this.dateOfPlanted = dateOfPlanted;
    }

    public LocalDate getDateOfWatering() {
        return dateOfWatering;
    }

    public void setDateOfWatering(LocalDate dateOfWatering) {
        this.dateOfWatering = dateOfWatering;
    }

    public int getFrequencyOfWatering() {
        return frequencyOfWatering;
    }

    public void setFrequencyOfWatering(int frequencyOfWatering) {
        this.frequencyOfWatering = frequencyOfWatering;
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
