package com.Engeto.Plant;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class PlantList {
    private List<Plant> plants;//collekcia pre ukladanie plant


    public PlantList() {plants = new ArrayList<>();    }//inicializuje prazdny zoznam


    public static void addPlant(Plant plant){  // prida plantu do zoznamu
        plants.add(plant);
    }

    public Plant getPlant(int index) {
        if (index >= 0 && index < plants.size()) {
            return plants.get(index);
        }
        return null; // Pokud index není platný
    }
    public List<Plant> getPlants() {
        return plants;
    }

    public void removePlantByName(String name) {
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
        public void printPlants() {
            for (Plant plant : plants) {
                System.out.println("Názov kvetiny: " + plant.getName());

            }
        }




//    public void loadPlantsFromFile(String filename) throws PlantException {
//        try (Scanner scanner = new Scanner(new BufferedReader(new FileReader(filename))) {
//        while (scanner.hasNextLine()) {
//                String line = scanner.nextLine();
//                String[] parts = line.split(",");
//                if (parts.length >= 4) {
//                    String name = parts[0];
//                    String notes = parts[1];
//                    LocalDate planted = LocalDate.parse(parts[2]); // Předpokládáme, že datum je ve správném formátu
//                    int frequencyOfWatering = Integer.parseInt(parts[3]);
//
//                    // Vytvoření nové rostliny a přidání do seznamu
//                    plants.add(new Plant(name, notes, planted, frequencyOfWatering));
//                } else {
//                    throw new PlantException("Chybný formát dat ve souboru.");
//                }
//            }
//        } catch (FileNotFoundException ex) {
//            throw new PlantException("Soubor nebyl nalezen: " + ex.getMessage());
//        } catch (IOException e) {
//            throw new PlantException("Chyba při čtení souboru: " + e.getMessage());
//        }
//    }



    public static PlantList loadPlantsFromFile(String filename) throws PlantException {
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
        String[] blocks = line.split(";"); // rozděl řádek na bloky podle oddělovače
        int numOfBlocks = blocks.length;         // Zkontroluj správný počet bloků
        if (numOfBlocks != 4) {
            throw new PlantException(
                    "Nesprávný počet položek na řádku: " + line +
                            "! Počet položek: "+numOfBlocks+".");
        }
        String name = blocks[0].trim();         // Převeď textové položky na objekty
        String notes = blocks[1].trim();
        LocalDate dateOfPlanted = LocalDate.parse(blocks[3].trim());
        int frequencyOfWatering = Integer.parseInt(blocks[2].trim());
        Plant newPlant =new Plant(name,notes,dateOfPlanted,frequencyOfWatering);
        PlantList.addPlant(newPlant);  // Ulož vytvořený objekt do košíku
    }

}










