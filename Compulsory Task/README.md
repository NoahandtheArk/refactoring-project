// Quick Food - Compulsory Task 2

// Program Description

This Java program implements a food delivery system for Quick Food that allows users to:

1. Capture customer details
2. Capture restaurant details
3. Find the best available driver in the customer's area
4. Generate an invoice for the order

// Files Included

// Core Classes

- **Customer.java** - Customer class with name, location, and contact details
- **Restaurant.java** - Restaurant class with name, location, and contact details
- **QuickFoodApp.java** - Main program that orchestrates the entire process

// Data Files

- **drivers.txt** - Contains driver information (name, area, current load)

// Generated Files

- **invoice.txt** - Generated invoice file for each order

// How to Run

1. **Compile the program:**

   ```bash
   javac *.java
   ```

2. **Run the program:**

   ```bash
   java QuickFoodApp
   ```

3. **Follow the prompts to enter:**
   - Customer name, location, and contact
   - Restaurant name, location, and contact

// Program Features

// Customer and Restaurant Creation

- Creates Customer objects with name, location, and contact information
- Creates Restaurant objects with name, location, and contact information

// Driver Selection Logic

- Reads the drivers.txt file to find available drivers
- Matches driver location with customer location
- Selects the driver with the smallest current load in the customer's area
- Handles empty load values gracefully

// Invoice Generation

- Creates a timestamped invoice in invoice.txt
- Includes customer and restaurant details
- Shows assigned driver if available
- Displays appropriate message if no drivers are available in the area

// Error Handling

- Robust file I/O error handling
- Number format exception handling for driver loads
- Graceful handling of malformed data in drivers.txt

// Sample Output

When a driver is found:

```
*** QUICK FOOD INVOICE ***
Date: 2024-06-22 18:34:00

Customer: John Doe
Location: Cape Town
Contact: 0821234567

Restaurant: Pizza Place
Location: Cape Town
Contact: 0211234567

Driver: Miranda Metcalfe
Thank you for your order!
```

When no driver is available:

```
*** QUICK FOOD INVOICE ***
Date: 2024-06-22 18:34:00

Customer: John Doe
Location: Remote Area
Contact: 0821234567

Restaurant: Pizza Place
Location: Cape Town
Contact: 0211234567

Sorry! Our drivers are too far away from you to be able to deliver to your location.
```

// Requirements Met

✅ Create a Customer class  
✅ Create a Restaurant class  
✅ Capture customer details  
✅ Capture restaurant details  
✅ Read drivers.txt and find best driver  
✅ Handle cases where no driver is available  
✅ Generate invoice.txt file  
✅ Console/terminal-based interface
