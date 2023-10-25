package com.Engeto.Plant;

import java.time.LocalDate;

public class Plant {
    private String name;
    private String notes;
    private LocalDate dateOfPlanted;
    private LocalDate dateOfWatering;
    private int frequencyOfWatering;


    public Plant(String name, String notes, LocalDate dateOfPlanted,
                 LocalDate dateOfWatering, int frequencyOfWatering) throws PlantException {
        this.name = name;
        this.notes = notes;
        this.dateOfWatering = dateOfWatering;
        try {    // testujeme ci tam nie je 0 alebo zaporne cislo
            if (frequencyOfWatering <= 0) {
                throw new PlantException("Neplatna frekvence zálivky: " + frequencyOfWatering);
            }
            this.frequencyOfWatering = frequencyOfWatering;
        } catch (PlantException e) {
            System.err.println("Chyba pri vytvárení rostliny: " + e.getMessage());
            int basicFrequency = 7;
            this.frequencyOfWatering = 7; // Nastavení výchozí frekvence na 8dni
            System.out.println("vychodzie pocet zalievky je " + basicFrequency);
        }
        try {
            if (dateOfPlanted.isAfter(dateOfWatering)) {
                throw new PlantException("Datum poslední zálivky nemůže být starší než datum zasazení.");
            }
        } catch (PlantException e) {
            System.err.println("Chyba pri vytvárení rostliny - datum: " + e.getMessage());
            this.dateOfPlanted = LocalDate.now();
        }
    }

    public Plant(String name,  LocalDate planted,int frequencyOfWatering) throws PlantException {
        this(name, "", planted, LocalDate.now(),
                frequencyOfWatering);       }

    public Plant(String name) throws PlantException {
        this(name, "", LocalDate.now(),
                LocalDate.now(), 7);
    }




    // Metoda pro výpis informací o rostlině
    public void printPlantInfo() {
        System.out.println("Název: " + name);
        System.out.println("Poznámky: " + notes);
        System.out.println("Datum zasazení: " + dateOfPlanted);
        System.out.println("Datum poslední zálivky: " + dateOfWatering);
        System.out.println("Frekvence zálivky (dny): " + frequencyOfWatering);
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

    public String getWateringInfo() {
        LocalDate nextWateringDate = dateOfWatering.plusDays(frequencyOfWatering);
        return "Název: " + name + "\nDatum poslední zálivky: " + dateOfWatering + "\nDoporučené datum další zálivky: " + nextWateringDate;
    }







}
