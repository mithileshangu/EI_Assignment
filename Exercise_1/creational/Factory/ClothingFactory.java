public class ClothingFactory {
    public Clothing createClothing(String clothingType) {
        if (clothingType.equalsIgnoreCase("TSHIRT")) {
            return new TShirt();
        } else if (clothingType.equalsIgnoreCase("DRESS")) {
            return new Dress();
        } else if (clothingType.equalsIgnoreCase("JACKET")) {
            return new Jacket();
        }
        return null;
    }
}
