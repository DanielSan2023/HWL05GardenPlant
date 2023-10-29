public class WateringDateComparator implements Comparator<Plant> {
    @Override
    public int compare(Plant plant1, Plant plant2) {
        return plant1.getDateOfWatering().compareTo(plant2.getDateOfWatering());
    }

}
