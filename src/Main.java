import com.Engeto.Plant.Plant;
import com.Engeto.Plant.PlantException;
import com.Engeto.Plant.PlantList;

import java.time.LocalDate;

public class Main {
    public static void main(String[] args)  {
        Plant plant1 = null,plant2 = null,plant3=null,plant4=null,plant5=null;

        try {
//      plant1 = new Plant("Růže", "Krásná červená růže", LocalDate.of(2023, 5,
//               15), LocalDate.of(2023, 5, 20), -1);
        plant2 = new Plant("Tulipán", "", LocalDate.of(2023, 5, 15),2);
//        plant3 = new Plant("Fikus");
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
        System.out.println(plants.getPlant(0));;

        plants.addPlant(plant5);
        System.out.println(plants.getPlant(1));;
        System.out.println(plant2.getWateringInfo());;
        System.out.println(plant5.getWateringInfo());

        // vypis zoznamu plants
        plants.printPlants();
        // vymazanie kvetiny
        plants.removePlantByName("Tulipán");
        //nacitanie kvetin zo suboru : "NewPlants.txt"
        try {
            plants = PlantList.loadPlantsFromFile("NewPlants.txt");
        } catch (PlantException e) {
            System.err.println("Chyba pri cteni ze souboru : "+e.getLocalizedMessage());
        }
        System.out.println("Citanie zo suboru: ");
        plants.printPlants();

        //ulozenie zoznamu do suboru :"NewListPlants.txt"
        try {
            PlantList.saveToFile("NewListPlants.txt", plants);
        } catch (PlantException e) {
            System.err.println("Chyba pri zapise do souboru : "+e.getLocalizedMessage());
        }
    }





    }
