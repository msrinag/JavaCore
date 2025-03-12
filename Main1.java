import java.util.ArrayList;

 class Main1 {
    public static void main(String[] args) {
       
        // adding products
        Product product1 = new Product("shirt", 1000, 10);
        Product product2 = new Product("laptop", 50000, 20);

        // create customer
        Customer customer1 = new Customer("srinag", "msri@gmail.com");

        //adding itemes to cart
        customer1.addToCart(product1, 2);
        customer1.addToCart(product2, 3);

        // seeing cart items 
        customer1.viewCart();

        // placing order
        Order order1 = new Order(customer1);
        order1.placeOrder();
    }
}
 class Customer {
    private String name;
    private ArrayList<Cartitem> cart;
   // private String email;

    public Customer(String name, String email) { 
        this.name = name;
        this.cart = new ArrayList<>();
        //this.email=email;
    }

    public void addToCart(Product product, int quantity) {
        if (product.getQuantity() >= quantity) {
            cart.add(new Cartitem(product, quantity));
            product.updateQuantity(quantity);
            System.out.println(quantity + " of " + product.getName() + " added to cart.");
        } else {
            System.out.println("Not enough stock for " + product.getName() + ".");
        }
    }

    public void viewCart() {
        if (cart.isEmpty()) {
            System.out.println("Your cart is empty.");
        } else {
            for (Cartitem item : cart) {
                System.out.println(item.getProduct().getName() + " x " + item.getQuantity());
            }
        }
    }

    public ArrayList<Cartitem> getCart() {
        return cart;
    }

    public String getName() {
        return name;
    }
}

 class Cartitem {
    private Product product;
    private int quantity;

    public Cartitem(Product product, int quantity) {
        this.product = product;
        this.quantity = quantity;
    }

    public Product getProduct() {
        return product;
    }

    public int getQuantity() {
        return quantity;
    }
}

 class Order {
    private Customer customer;
    private double total;

    public Order(Customer customer) {
        this.customer = customer;
        this.total = 0;
    }

    public double calculateTotal() {
        for (Cartitem item : customer.getCart()) {
            total += item.getProduct().getPrice() * item.getQuantity();
        }
        return total;
    }

    public void placeOrder() {
        total = calculateTotal();
        System.out.println("Order placed by " + customer.getName() + " for a total of RS:" + total);
        customer.getCart().clear();  // Empty the cart 
    }
}

 class Product {
    private String name;
    private double price;
    private int quantity;

    public Product(String name, double price, int quantity) {
        this.name = name;
        this.price = price;
        this.quantity = quantity;
    }

    public void updateQuantity(int quantity) {
        this.quantity -= quantity;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public int getQuantity() {
        return quantity;
    }
}
