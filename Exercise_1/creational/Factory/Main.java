public class Main {
    public static void main(String[] args) {
        ClothingFactory clothingFactory = new ClothingFactory();
        
        // Creating a T-Shirt
        Clothing tShirt = clothingFactory.createClothing("TSHIRT");
        tShirt.wear(); // Output: Wearing a T-Shirt

        // Creating a Dress
        Clothing dress = clothingFactory.createClothing("DRESS");
        dress.wear(); // Output: Wearing a Dress

        // Creating a Jacket
        Clothing jacket = clothingFactory.createClothing("JACKET");
        jacket.wear(); // Output: Wearing a Jacket
    }
}
