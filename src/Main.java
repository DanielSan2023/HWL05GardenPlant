import com.Engeto.Plant.*;

import java.io.BufferedReader;
import java.io.FileReader;
import java.time.LocalDate;
import java.util.Collections;
import java.util.Scanner;

public class Main {
    public static void main(String[] args)  {
        System.out.println("\u001B[33mLekcia 5 - DOMACA ULOHA: Pokojove rastliny  - zadanie si vies precitat v  \u001B[0m" + "\u001B[36mReadmy.txt\u001B[0m");

        Plant plant1 = null,plant2 = null,plant3=null,plant4=null,plant5=null;

        try {
        plant1 = new Plant("Růže", "Krásná červená růže", LocalDate.of(2023, 5, 15),
              LocalDate.of(2023, 5, 20), 0);
        plant2 = new Plant("Tulipán", "", LocalDate.of(2023, 5, 15),2);
        plant3 = new Plant("Fikus","Bonsai");
        plant5 = new Plant("Kaktus");
        } catch (PlantException e) {
            System.err.println("Chyba vytvaraní kvetiny: "+e.getLocalizedMessage());
        }


            // Výpis informací o zálivce
        System.out.println(plant1.getWateringInfoText());
        System.out.println(plant2.getWateringInfo());

        //ukladanie plant do plants listu
        PlantList plants = new PlantList();
        plants.addPlant(plant2);
        plants.addPlant(plant3);
        //vrati plantu zo zoznamu na 1.pozicii
        System.out.println(plants.getPlant(0));;

        plants.addPlant(plant5);
        System.out.println(plants.getPlant(1));;

        // vypis zoznamu plants
        plants.printPlants();

        // vymazanie kvetiny
        plants.removePlantByName("Tulipán");

        //nacitanie kvetin zo suboru : "Kvetiny.txt"
        plants = makeLoadFromFile(Settings.fileNameforLoad());

        // vypisanie kvetin
        plants.printPlantsWithWateringInfo();

        //ulozenie zoznamu do suboru :"NewKvetiny.txt"
        makeSavePlantsToFile(plants,Settings.fileNameforSave());

        // print info o zalevce kvetin
        plants.printPlantsWithWateringInfo();

        plants.addPlant(plant1);
        plants.addPlant(plant2);
        plants.removePlantByName("Tulipán");   //Odstrani zo zoznamu Tulipan

        makeSavePlantsToFile(plants,Settings.getNewFileSaveNameValue());
        plants = makeLoadFromFile(Settings.getNewFileSaveNameValue());
        plants.printPlants();

            //zorad podla nazvu plant/kvetin
        System.out.println("\u001B[32mZoradenie podla nazvu:\u001B[0m");
        Collections.sort(plants.getPlants());
        plants.printPlants();

        // Seřazení rostlin podle datumu poslední zálivky
        System.out.println("\u001B[32mZoradene podla datumu zalievky :\u001B[0m");
        Collections.sort(plants.getPlants(), new WateringDateComparator());
        plants.printPlantsWithWateringInfo();


        //DOPORUČENÉ OVĚŘENÍ NAVÍC  Poškozený soubor 1  : "kvetiny-spatne-datum.txt")
    //    plants = makeLoadFromFile("kvetiny-spatne-datum.txt");

        //DOPORUČENÉ OVĚŘENÍ NAVÍC  Poškozený soubor 1  : "kvetiny-spatne-frekvence.txt")
    //    plants = makeLoadFromFile("kvetiny-spatne-frekvence.txt");




    }

    private static void makeSavePlantsToFile(PlantList plants,String filename) {
        //ulozenie zoznamu do suboru :"NewKvetiny2.txt"
        try {
            PlantList.saveToFile(filename, plants);
        } catch (PlantException e) {
            System.err.println("Chyba pri zapise do souboru : "+e.getLocalizedMessage());
        }
    }

    private static PlantList  makeLoadFromFile(String filename) {   //Opatovne nacitanie suboru
        System.out.println("\u001B[34mCitanie zo suboru: \u001B[0m" + filename);
        PlantList plants = null;
        try {
            plants = PlantList.loadPlantsFromFile(filename);
        } catch (PlantException e) {
            System.err.println("Chyba pri cteni ze souboru : "+e.getLocalizedMessage());
        }return plants;

    }

}






