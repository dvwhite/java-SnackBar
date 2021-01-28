package snackbar;

// class imports
import snackbar.Snack;
import snackbar.Customer;
import snackbar.VendingMachine;

public class Main {
  public static void main(String[] args) {
    // Variables
    int maxCustomerId = 0;
    int maxSnackId = 0;
    int maxVendingId = 0;

    // Customers
    Customer customer1 = new Customer(maxCustomerId, "Jane", 45.25);
    maxCustomerId++;

    Customer customer2 = new Customer(maxCustomerId, "Bob", 33.14);
    maxCustomerId++;

    // Vending machines
    VendingMachine foodVending = new VendingMachine(maxVendingId, "Food");
    maxVendingId++;

    VendingMachine drinkVending = new VendingMachine(maxVendingId, "Drink");
    maxVendingId++;

    VendingMachine officeVending = new VendingMachine(maxVendingId, "Office");
    maxVendingId++;

    // Vending machine snacks
    Snack chips = new Snack(maxSnackId, "Chips", 36, 1.75, foodVending.getId());
    Snack chocolateBar = new Snack(maxSnackId, "Chocolate bar", 36, 1.00, foodVending.getId());
    Snack pretzel = new Snack(maxSnackId, "Pretzel", 30, 2.00, foodVending.getId());
    Snack soda = new Snack(maxSnackId, "Soda", 24, 2.50, drinkVending.getId());
    Snack water = new Snack(maxSnackId, "Water", 20, 2.75, drinkVending.getId());

    // Customer purchases
    customer1.buySnack(soda.getCost(), 3);
    soda.buy(3);
    System.out.println(customer1.getName() + " cash on hand " + customer1.getCashOnHand());
    System.out.println("Quantity of " + soda.getName() + " is " + soda.getQuantity());

    // Blank line
    System.out.println("");

    customer1.buySnack(pretzel.getCost(), 1);
    pretzel.buy(1);
    System.out.println(customer1.getName() + " cash on hand " + customer1.getCashOnHand());
    System.out.println("Quantity of " + pretzel.getName() + " is " + pretzel.getQuantity());

    // Blank line
    System.out.println("");

    customer2.buySnack(soda.getCost(), 2);
    soda.buy(2);
    System.out.println(customer2.getName() + " cash on hand " + customer2.getCashOnHand());
    System.out.println("Quantity of " + soda.getName() + " is " + soda.getQuantity());

    // Blank line
    System.out.println("");

    customer1.addCashOnHand(10);
    System.out.println(customer1.getName() + " cash on hand " + customer1.getCashOnHand());

  }
}