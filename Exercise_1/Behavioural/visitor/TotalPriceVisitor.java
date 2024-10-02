public class TotalPriceVisitor implements Visitor {
    private double totalPrice = 0.0;

    @Override
    public void visit(Book book) {
        totalPrice += book.getPrice();
    }

    @Override
    public void visit(Electronics electronics) {
        totalPrice += electronics.getPrice();
    }

    public double getTotalPrice() {
        return totalPrice;
    }
}
