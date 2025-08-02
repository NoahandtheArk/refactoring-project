// Compulsory Task
// Represents a restaurant in the food delivery system.

public class Restaurant {

  // Restaurant's details
  private String name;
  private String location;
  private String contact;

  // Constructs a Restaurant with the specified name, location, and contact info.

  // @param name - restaurant name
  // @param location - location of the restaurant
  // @param contact - contact number of the restaurant

  public Restaurant(String name, String location, String contact) {
    this.name = name;
    this.location = location;
    this.contact = contact;
  }

  // Returns the restaurant's name.

  public String getName() {
    return name;
  }

  // Returns the restaurant's location.

  public String getLocation() {
    return location;
  }

  // Returns the restaurant's contact information.

  public String getContact() {
    return contact;
  }

  // Returns a formatted string with the restaurant's details.

  @Override
  public String toString() {
    return "Restaurant: " + name + "\nLocation: " + location + "\nContact: " + contact;
  }
}

// References
// I followed the following guidelines to refactor, format and ensured the exception-safe version of the restaurant app
// https://developer.mozilla.org/en-US/docs/Web/JavaScript/Reference/Global_Objects/Object/toString
// https://developer.mozilla.org/en-US/docs/Web/JavaScript/Reference/Global_Objects/Object/toString