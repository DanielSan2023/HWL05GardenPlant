package com.Engeto.Plant;

import java.io.*;
import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class PlantList {
    private static List<Plant> plants;  //collekcia pre ukladanie kvetin / plant


    public PlantList() {plants = new ArrayList<>();    }//inicializuje prazdny zoznam


    public static void addPlant(Plant plant){  // prida plantu do zoznamu
        plants.add(plant);
    }

    public Plant getPlant(int index) throws IndexOutOfBoundsException {
        if (index >= 0 && index < plants.size()) {
            return plants.get(index);
        } else {
            throw new IndexOutOfBoundsException("Neplatný index: " + index);
        }
    }
    public List<Plant> getPlants() {
        return plants;
    }// vrati zoznam plants

    public void removePlantByName(String name) {//vymaze podla mena planty
        Plant plantToRemove = null;
        for (Plant plant : plants) {
            if (plant.getName().equals(name)) {
                plantToRemove = plant;
                break; // Rostlinu jsme našli,
            }
        }
        if (plantToRemove != null) {
            plants.remove(plantToRemove);
        }
    }
        public void printPlants() {         // vypise na consolu zoznam plants
            for (Plant plant : plants) {
                System.out.println("Názov kvetiny: " + plant.getName());
            }
        }
        public void printPlantsWithWateringInfo() {
            System.out.println("Nazov kvetiny :");
        for (Plant plant : plants) {
            System.out.println(  plant.getWateringInfo());
        }
    }



                            // ulozim zoznam do suboru
    public static void saveToFile(String filename, PlantList plants) throws PlantException {
        try (PrintWriter writer = new PrintWriter(new BufferedWriter(new FileWriter(filename)))) {
            for (Plant plant: plants.getPlants() ) {
                writer.println(plant.getName()+ Settings.fileItemDelimiter() +plant.getNotes() +Settings.fileItemDelimiter()
                        +plant.getFrequencyOfWatering()+Settings.fileItemDelimiter()+plant.getDateOfWatering()
                        +Settings.fileItemDelimiter()+plant.getDateOfPlanted()     );
            }
        } catch (IOException e) {
            throw new PlantException("Chyba při zápisu do souboru '"+filename+"': "+e.getLocalizedMessage());
        }
    }





    public static PlantList  loadPlantsFromFile(String filename) throws PlantException {
        PlantList result = new PlantList();
        int lineNumber = 1;
        try (Scanner scanner = new Scanner(new BufferedReader(new FileReader(filename)))) { // Otevři soubor
            while (scanner.hasNextLine()) { // Dokud je k dispozici další řádek:
                String line = scanner.nextLine(); // Načti řádek ze souboru
                //System.out.println(line);           // Vypiš řádek na obrazovku.
                parseLine(line, result, lineNumber);
                lineNumber++;
            }
        } catch (FileNotFoundException e) {
            throw new PlantException("Nepodařilo se nalézt soubor "+filename+": "+e.getLocalizedMessage());
        }

        return result;
    }
    private static void parseLine(String line, PlantList plantList, int lineNumber) throws PlantException {
        String[] blocks = line.split(Settings.fileItemDelimiter());

        if (blocks.length != 5) {
            throw new PlantException("Nesprávný počet položek na řádku: " + line + "! Počet položek: " + blocks.length + ".");
        }

        String name = blocks[0].trim();
        String notes = blocks[1].trim();

        int frequencyOfWatering = 0;
        try {
            frequencyOfWatering = Integer.parseInt(blocks[2].trim());
        } catch (NumberFormatException e) {
            throw new PlantException("Neplatný formát frekvence zavlažování v souboru.");
        }

        LocalDate dateOfPlanted = null;
        try {
            dateOfPlanted = LocalDate.parse(blocks[4].trim());
        } catch (DateTimeParseException e) {
            throw new PlantException("Chyba: Datum nebyl zadán ve správném formátu: " + blocks[4].trim() +
                    ". Správný formát: 2023-10-26");
        }

        LocalDate dateOfWatering = null;
        try {
            dateOfWatering = LocalDate.parse(blocks[3].trim());
        } catch (DateTimeParseException e) {
            throw new PlantException("Chyba: Datum nebyl zadán ve správném formátu: " + blocks[3].trim() +
                    ". Správný formát: 2023-10-26");
        }

        Plant newPlant =new Plant(name,notes,dateOfPlanted,dateOfWatering,frequencyOfWatering);
        PlantList.addPlant(newPlant);  // Ulož vytvořený objekt do plants
    }







}











