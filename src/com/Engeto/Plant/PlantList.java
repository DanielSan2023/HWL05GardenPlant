package com.Engeto.Plant;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class PlantList {
    private List<Plant> plants;//collekcia pre ukladanie plant


    public PlantList() {plants = new ArrayList<>();    }//inicializuje prazdny zoznam


    public void addPlant(Plant plant){  // prida plantu do zoznamu
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




    public void loadPlantsFromFile(String filename) throws PlantException {
        try (Scanner scanner = new Scanner(new BufferedReader(new FileReader(filename))) {
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                String[] parts = line.split(",");
                if (parts.length >= 4) {
                    String name = parts[0];
                    String notes = parts[1];
                    LocalDate planted = LocalDate.parse(parts[2]); // Předpokládáme, že datum je ve správném formátu
                    int frequencyOfWatering = Integer.parseInt(parts[3]);

                    // Vytvoření nové rostliny a přidání do seznamu
                    plants.add(new Plant(name, notes, planted, frequencyOfWatering));
                } else {
                    throw new PlantException("Chybný formát dat ve souboru.");
                }
            }
        } catch (FileNotFoundException e) {
            throw new PlantException("Chyba při čtení souboru: " + e.getMessage());
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
    }










