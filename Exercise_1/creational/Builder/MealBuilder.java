public class MealBuilder {
    private String rice;
    private String curry;
    private String sideDish;
    private String dessert;

    public MealBuilder setRice(String rice) {
        this.rice = rice;
        return this;
    }

    public MealBuilder setCurry(String curry) {
        this.curry = curry;
        return this;
    }

    public MealBuilder setSideDish(String sideDish) {
        this.sideDish = sideDish;
        return this;
    }

    public MealBuilder setDessert(String dessert) {
        this.dessert = dessert;
        return this;
    }

    public Meal build() {
        return new Meal(rice, curry, sideDish, dessert);
    }
}
