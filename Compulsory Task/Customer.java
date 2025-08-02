// Compulsory Task
// Represents a customer in the food delivery system.

public class Customer {

  // Customer's personal details
  private String name;
  private String location;
  private String contact;

  // Constructs a Customer with the specified name, location, and contact info.
  // @param name - full name of the customer.
  // @para location - customer delivery location
  // @param contact - customer contact details

  public Customer(String name, String location, String contact) {
    this.name = name;
    this.location = location;
    this.contact = contact;
  }

  // Returns the customer name.

  public String getName() {
    return name;
  }

  // Returns the customer location.

  public String getLocation() {
    return location;
  }

  // Returns the customer contact details.

  public String getContact() {
    return contact;
  }

  // Returns a formatted string with the customer information.

  @Override
  public String toString() {
    return "Customer: " + name + "\nLocation: " + location + "\nContact: " + contact;
  }
}

// References
// I followed the following guidelines to refactor, format and ensured the exception-safe version of the restaurant app
// https://developer.mozilla.org/en-US/docs/Web/JavaScript/Reference/Global_Objects/Object/toString
// https://developer.mozilla.org/en-US/docs/Web/JavaScript/Reference/Global_Objects/Object/toString