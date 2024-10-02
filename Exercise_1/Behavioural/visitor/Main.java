import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Main {
    private ShoppingCart cart;
    private JTextArea displayArea;
    private JTextField titleField, priceField, discountField;

    public Main() {
        cart = new ShoppingCart();
        initialize();
    }

    private void initialize() {
        JFrame frame = new JFrame("Shopping Cart");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 300);
        frame.setLayout(new BorderLayout());

        JPanel inputPanel = new JPanel();
        inputPanel.setLayout(new FlowLayout());

        titleField = new JTextField(10);
        priceField = new JTextField(10);
        discountField = new JTextField(10);
        JButton addBookButton = new JButton("Add Book");
        JButton addElectronicsButton = new JButton("Add Electronics");
        JButton calculateTotalButton = new JButton("Calculate Total Price");
        JButton applyDiscountButton = new JButton("Apply Discount");

        inputPanel.add(new JLabel("Title:"));
        inputPanel.add(titleField);
        inputPanel.add(new JLabel("Price:"));
        inputPanel.add(priceField);
        inputPanel.add(addBookButton);
        inputPanel.add(addElectronicsButton);
        inputPanel.add(new JLabel("Discount (%):"));
        inputPanel.add(discountField);
        inputPanel.add(applyDiscountButton);
        inputPanel.add(calculateTotalButton);

        displayArea = new JTextArea();
        displayArea.setEditable(false);
        displayArea.setLineWrap(true);
        displayArea.setWrapStyleWord(true);

        addBookButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String title = titleField.getText();
                double price = Double.parseDouble(priceField.getText());
                cart.addItem(new Book(title, price));
                displayArea.append("Added Book: " + title + " - $" + price + "\n");
                titleField.setText("");
                priceField.setText("");
            }
        });

        addElectronicsButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String name = titleField.getText();
                double price = Double.parseDouble(priceField.getText());
                cart.addItem(new Electronics(name, price));
                displayArea.append("Added Electronics: " + name + " - $" + price + "\n");
                titleField.setText("");
                priceField.setText("");
            }
        });

        calculateTotalButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                TotalPriceVisitor visitor = new TotalPriceVisitor();
                cart.accept(visitor);
                displayArea.append("Total Price: $" + visitor.getTotalPrice() + "\n");
            }
        });

        applyDiscountButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                double discount = Double.parseDouble(discountField.getText()) / 100;
                DiscountVisitor discountVisitor = new DiscountVisitor(discount);
                cart.accept(discountVisitor);
            }
        });

        frame.add(inputPanel, BorderLayout.NORTH);
        frame.add(new JScrollPane(displayArea), BorderLayout.CENTER);
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new Main());
    }
}
