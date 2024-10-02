public class DiscountVisitor implements Visitor {
    private double discount;

    public DiscountVisitor(double discount) {
        this.discount = discount;
    }

    @Override
    public void visit(Book book) {
        double discountedPrice = book.getPrice() - (book.getPrice() * discount);
        System.out.println("Discounted price of " + book.getTitle() + ": " + discountedPrice);
    }

    @Override
    public void visit(Electronics electronics) {
        double discountedPrice = electronics.getPrice() - (electronics.getPrice() * discount);
        System.out.println("Discounted price of " + electronics.getName() + ": " + discountedPrice);
    }
}
