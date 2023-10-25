import com.Engeto.Plant.Plant;
import com.Engeto.Plant.PlantException;

import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        Plant plant1 = null,plant2 = null,plant3=null,plant4=null;

        try {
        plant1 = new Plant("Růže", "Krásná červená růže", LocalDate.of(2023, 5, 15), LocalDate.of(2023, 5, 20), -1);
        plant2 = new Plant("Tulipán", LocalDate.of(2023, 5, 15),2);
        plant3 = new Plant("Fikus");
        plant4 = new Plant("Cerna Růže", "Krásná čierna růže", LocalDate.of(2023, 7, 15), LocalDate.of(2023, 5, 19), 4);
        } catch (PlantException e) {
            
        }
         

        // Výpis informací o zálivce
        System.out.println(plant1.getWateringInfo());
        System.out.println(plant2.getWateringInfo());
        System.out.println(plant3.getWateringInfo());
        System.out.println(plant4.getWateringInfo());

    }

    }
