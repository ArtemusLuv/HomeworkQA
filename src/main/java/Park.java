// Task 3
public class Park {
    private String nameOfPark;
    Attraction attraction;
    public Park(String nameOfPark, String nameOfAttraction, int workTime, int cost) {
        this.nameOfPark = nameOfPark;
        attraction = new Attraction(nameOfAttraction, workTime, cost);
    }

    public void getInfoAboutPark() {
        System.out.println("\nName of park is " + nameOfPark);
        attraction.getInfoAboutAttraction();
    }

    private class Attraction {
        private String nameOfAttraction;
        private int workTime;
        private int cost;
        private Attraction(String nameOfAttraction, int workTime, int cost) {
            this.nameOfAttraction = nameOfAttraction;
            this.workTime = workTime;
            this.cost = cost;
        }
        private void getInfoAboutAttraction() {
            System.out.println("Attraction '" + nameOfAttraction + "' " + "costs " + cost + " rubles and work around " + workTime + " minutes.");
        }
    }

}
