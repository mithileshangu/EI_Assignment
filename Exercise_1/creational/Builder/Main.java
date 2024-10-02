public class Main {
    public static void main(String[] args) {
        MealDirector director = new MealDirector();

        // Creating a traditional Tamil meal
        Meal traditionalMeal = director.createTraditionalMeal();
        traditionalMeal.showDetails();

        System.out.println(); // For better separation of output

        // Creating a festival meal
        Meal festivalMeal = director.createFestivalMeal();
        festivalMeal.showDetails();
    }
}
