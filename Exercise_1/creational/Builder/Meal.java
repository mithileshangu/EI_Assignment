public class Meal {
    private String rice;        // Type of rice (e.g., steamed rice, lemon rice)
    private String curry;       // Main curry dish (e.g., sambar, kootu)
    private String sideDish;    // Side dish (e.g., papad, pickle)
    private String dessert;      // Dessert (e.g., payasam)

    public Meal(String rice, String curry, String sideDish, String dessert) {
        this.rice = rice;
        this.curry = curry;
        this.sideDish = sideDish;
        this.dessert = dessert;
    }

    public void showDetails() {
        System.out.println("Tamil Meal Includes:");
        System.out.println("Rice: " + rice);
        System.out.println("Curry: " + curry);
        System.out.println("Side Dish: " + sideDish);
        System.out.println("Dessert: " + dessert);
    }
}
