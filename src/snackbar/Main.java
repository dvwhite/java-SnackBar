package snackbar;

// class imports
import snackbar.Snack;
import snackbar.Customer;
import snackbar.VendingMachine;

import java.lang.invoke.TypeDescriptor.OfField;
// Java imports
import java.text.DecimalFormat;

public class Main {
  private static DecimalFormat df = new DecimalFormat("$#,##0.00");

  public static String findVendingMachine(int id, VendingMachine[] machines) {
    // Vars
    VendingMachine machine;

    // Iterate through looking for a machine with an id of id
    for (int i = 0; i < machines.length; i++) {
      machine = machines[i];
      if (machine.getId() == id) {
        return machine.getName();
      }
    }
    // None found
    return "None";
  }

  public static void main(String[] args) {
    // Variables
    int maxCustomerId = 0;
    int maxSnackId = 0;
    int maxVendingId = 0;
    String machineName;

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

    VendingMachine[] vendingMachines = new VendingMachine[3];
    vendingMachines[0] = foodVending;
    vendingMachines[1] = drinkVending;
    vendingMachines[2] = officeVending;

    // Vending machine snacks
    Snack chips = new Snack(maxSnackId, "Chips", 36, 1.75, foodVending.getId());
    Snack chocolateBar = new Snack(maxSnackId, "Chocolate bar", 36, 1.00, foodVending.getId());
    Snack pretzel = new Snack(maxSnackId, "Pretzel", 30, 2.00, foodVending.getId());
    Snack soda = new Snack(maxSnackId, "Soda", 24, 2.50, drinkVending.getId());
    Snack water = new Snack(maxSnackId, "Water", 20, 2.75, drinkVending.getId());

    // Customer purchases
    customer1.buySnack(soda.getCost(), 3);
    soda.buy(3);
    System.out.println(customer1.getName() + " cash on hand " + df.format(customer1.getCashOnHand()));
    System.out.println("Quantity of " + soda.getName() + " is " + soda.getQuantity());

    // Blank line
    System.out.println("");

    customer1.buySnack(pretzel.getCost(), 1);
    pretzel.buy(1);
    System.out.println(customer1.getName() + " cash on hand " + df.format(customer1.getCashOnHand()));
    System.out.println("Quantity of " + pretzel.getName() + " is " + pretzel.getQuantity());

    // Blank line
    System.out.println("");

    customer2.buySnack(soda.getCost(), 2);
    soda.buy(2);
    System.out.println(customer2.getName() + " cash on hand " + df.format(customer2.getCashOnHand()));
    System.out.println("Quantity of " + soda.getName() + " is " + soda.getQuantity());

    // Blank line
    System.out.println("");

    customer1.addCashOnHand(10);
    System.out.println(customer1.getName() + " cash on hand " + df.format(customer1.getCashOnHand()));

    // Blank line
    System.out.println("");

    customer1.buySnack(chocolateBar.getCost(), 1);
    chocolateBar.buy(1);
    System.out.println(customer1.getName() + " cash on hand " + df.format(customer1.getCashOnHand()));
    System.out.println("Quantity of " + chocolateBar.getName() + " is " + chocolateBar.getQuantity());

    // Blank line
    System.out.println("");

    pretzel.addQuantity(12);
    System.out.println("Quantity of " + pretzel.getName() + " is " + pretzel.getQuantity());

    // Blank line
    System.out.println("");

    customer2.buySnack(pretzel.getCost(), 3);
    pretzel.buy(3);
    System.out.println(customer2.getName() + " cash on hand " + df.format(customer2.getCashOnHand()));
    System.out.println("Quantity of " + pretzel.getName() + " is " + pretzel.getQuantity());

    // Blank line
    System.out.println("Stretch Goals");

    // Blank line
    System.out.println("");

    // Vendine machines
    System.out.println("Snack: " + chips.getName());
    machineName = findVendingMachine(chips.getVendineMachineId(), vendingMachines);
    System.out.println("Vending Machine: " + machineName);
    System.out.println("Quantity: " + chips.getQuantity());
    System.out.println("Total Cost: " + df.format(chips.getTotalCost(chips.getQuantity())));

    System.out.println("");

    System.out.println("Snack: " + chocolateBar.getName());
    machineName = findVendingMachine(chocolateBar.getVendineMachineId(), vendingMachines);
    System.out.println("Vending Machine: " + machineName);
    System.out.println("Quantity: " + chocolateBar.getQuantity());
    System.out.println("Total Cost: " + df.format(chocolateBar.getTotalCost(chocolateBar.getQuantity())));

    System.out.println("");

    System.out.println("Snack: " + pretzel.getName());
    machineName = findVendingMachine(pretzel.getVendineMachineId(), vendingMachines);
    System.out.println("Vending Machine: " + machineName);
    System.out.println("Quantity: " + pretzel.getQuantity());
    System.out.println("Total Cost: " + df.format(pretzel.getTotalCost(pretzel.getQuantity())));

    System.out.println("");

    System.out.println("Snack: " + soda.getName());
    machineName = findVendingMachine(soda.getVendineMachineId(), vendingMachines);
    System.out.println("Vending Machine: " + machineName);
    System.out.println("Quantity: " + soda.getQuantity());
    System.out.println("Total Cost: " + df.format(soda.getTotalCost(soda.getQuantity())));

    System.out.println("");

    System.out.println("Snack: " + water.getName());
    machineName = findVendingMachine(water.getVendineMachineId(), vendingMachines);
    System.out.println("Vending Machine: " + machineName);
    System.out.println("Quantity: " + water.getQuantity());
    System.out.println("Total Cost: " + df.format(water.getTotalCost(water.getQuantity())));
  }
}