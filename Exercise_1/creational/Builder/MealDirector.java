public class MealDirector {
    public Meal createTraditionalMeal() {
        return new MealBuilder()
                .setRice("Steamed Rice")
                .setCurry("Sambar")
                .setSideDish("Papad")
                .setDessert("Payasam")
                .build();
    }

    public Meal createFestivalMeal() {
        return new MealBuilder()
                .setRice("Lemon Rice")
                .setCurry("Kootu")
                .setSideDish("Pickle")
                .setDessert("Gulab Jamun")
                .build();
    }
}
