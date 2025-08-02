// Compulsory Task

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

// Main class which runs the QuickFood delivery application.

public class QuickFoodApp {

  // Main entry point of the application.

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);

    try {
      // Collecting customer details
      System.out.println("*** Customer Details ***");
      System.out.print("Enter customer name: ");
      String customerName = scanner.nextLine();

      System.out.print("Enter customer location: ");
      String customerLocation = scanner.nextLine();

      System.out.print("Enter customer contact: ");
      String customerContact = scanner.nextLine();

      Customer customer = new Customer(customerName, customerLocation, customerContact);

      // Collecting restaurant information
      System.out.println("\n*** Restaurant Details ***");
      System.out.print("Enter restaurant name: ");
      String restaurantName = scanner.nextLine();

      System.out.print("Enter restaurant location: ");
      String restaurantLocation = scanner.nextLine();

      System.out.print("Enter restaurant contact: ");
      String restaurantContact = scanner.nextLine();

      Restaurant restaurant = new Restaurant(restaurantName, restaurantLocation, restaurantContact);

      // Finding the best available driver
      String bestDriver = findBestDriver(customer.getLocation());

      // Generates invoice
      generateInvoice(customer, restaurant, bestDriver);

    } catch (Exception e) {
      System.out.println("An unexpected error occurred: " + e.getMessage());
    } finally {
      scanner.close(); // Ensures that the scanner is always closed
    }
  }

  // Finds the best driver in the customer's area with the least load.

  private static String findBestDriver(String customerArea) {
    String bestDriver = null;
    int minLoad = Integer.MAX_VALUE;

    try (BufferedReader reader = new BufferedReader(new FileReader("drivers.txt"))) {
      String line;

      while ((line = reader.readLine()) != null) {
        String[] parts = line.split(",");
        if (parts.length < 3) {
          continue;
        }

        String driverName = parts[0].trim();
        String driverArea = parts[1].trim();
        String loadStr = parts[2].trim();

        int load = 0;
        try {
          load = Integer.parseInt(loadStr);
        } catch (NumberFormatException e) {
          System.out.println("Warning: Invalid load value for driver " + driverName + ". Defaulting to 0.");
        }

        if (driverArea.equalsIgnoreCase(customerArea) && load < minLoad) {
          minLoad = load;
          bestDriver = driverName;
        }
      }
    } catch (IOException e) {
      System.out.println("Error reading driver file: " + e.getMessage());
    }

    return bestDriver;
  }

  // Generates an invoice and writes it to a file.

  private static void generateInvoice(Customer customer, Restaurant restaurant, String driverName) {
    try (FileWriter writer = new FileWriter("invoice.txt")) {
      LocalDateTime now = LocalDateTime.now();
      DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

      writer.write("*** QUICK FOOD INVOICE ***\n");
      writer.write("Date: " + now.format(formatter) + "\n\n");
      writer.write(customer.toString() + "\n\n");
      writer.write(restaurant.toString() + "\n\n");

      if (driverName != null) {
        writer.write("Driver: " + driverName + "\n");
        writer.write("Thank you for your order!\n");
      } else {
        writer.write("Sorry! Our drivers are too far away to deliver to your location.\n");
      }

      System.out.println("\nInvoice has been generated successfully: invoice.txt");

    } catch (IOException e) {
      System.out.println("Error writing invoice: " + e.getMessage());
    }
  }
}

// References
// I followed the following guidelines to refactor, format and ensured the exception-safe version of the restaurant app
// https://developer.mozilla.org/en-US/docs/Web/JavaScript/Reference/Global_Objects/Object/toString
// https://developer.mozilla.org/en-US/docs/Web/JavaScript/Reference/Global_Objects/Object/toString