import com.Engeto.Plant.Plant;
import com.Engeto.Plant.PlantException;
import com.Engeto.Plant.PlantList;

import java.time.LocalDate;

public class Main {
    public static void main(String[] args)  {
        Plant plant1 = null,plant2 = null,plant3=null,plant4=null,plant5=null;

        try {
      plant1 = new Plant("Růže", "Krásná červená růže", LocalDate.of(2023, 5, 15),
              LocalDate.of(2023, 5, 20), 5);
        plant2 = new Plant("Tulipán", "", LocalDate.of(2023, 5, 15),2);
        plant3 = new Plant("Fikus","Bonsai");
//       plant4 = new Plant("Cerna Růže", "Krásná čierna růže", LocalDate.of(2023,
//                7, 15), LocalDate.of(2023, 5, 19), 4);
            plant5 = new Plant("Kaktus");
        } catch (PlantException e) {
            System.err.println("Chyba vytvaraní kvetiny: "+e.getLocalizedMessage());
        }
            







//        // Výpis informací o zálivce
//        System.out.println(plant1.getWateringInfo());
//        System.out.println(plant2.getWateringInfo());
//        System.out.println(plant3.getWateringInfo());
//        System.out.println(plant4.getWateringInfo());


        //ukladanie plant do plants listu
        PlantList plants = new PlantList();
        plants.addPlant(plant2);
        plants.addPlant(plant3);
        System.out.println(plants.getPlant(0));;

        plants.addPlant(plant5);
        System.out.println(plants.getPlant(1));;
        System.out.println(plant2.getWateringInfo());;
        System.out.println(plant5.getWateringInfo());




        // vypis zoznamu plants
        plants.printPlants();
        // vymazanie kvetiny
        plants.removePlantByName("Tulipán");

        //nacitanie kvetin zo suboru : "Kvetiny.txt"
        plants = makeLoadFromFile("Kvetiny.txt");


        plants.printPlantsWithWateringInfo();
            //ulozenie zoznamu do suboru :"NewKvetiny.txt"
        try {
            PlantList.saveToFile("NewKvetiny.txt", plants);
        } catch (PlantException e) {
            System.err.println("Chyba pri zapise do souboru : "+e.getLocalizedMessage());
        }


        // print info o zalevce kvetin
        plants.printPlantsWithWateringInfo();

        plants.addPlant(plant1);
        plants.addPlant(plant2);
        plants.removePlantByName("Tulipán");   //Odstrani zo zoznamu Tulipan

        makeSavePlantsToFile(plants,"NewKvetiny2.txt");
        plants = makeLoadFromFile("NewKvetiny2.txt");

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
        System.out.println("Citanie zo suboru: ");
        PlantList plants = null;
        try {
            plants = PlantList.loadPlantsFromFile(filename);
        } catch (PlantException e) {
            System.err.println("Chyba pri cteni ze souboru : "+e.getLocalizedMessage());
        }return plants;

    }

}






