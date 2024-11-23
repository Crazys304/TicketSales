import java.util.Scanner;
import java.util.ArrayList;
import java.util.InputMismatchException;

class InvalidMenuInputException extends Exception { // Custom exception for main menu input
    public InvalidMenuInputException() {
        super("Invalid option. Input numbers between 1 and 10");
    }
}

class NegativePriceException extends Exception { // Custom exception for negative price
    public NegativePriceException() {
        super("The Price cannot be negative");
    }
}

public class Main {
    // Checks if menu input is between 1 and 10
    public static void InvalidMenuInput(int number) throws InvalidMenuInputException {
        if (number < 1 || number > 10) {
            throw new InvalidMenuInputException();
        }
    }
    // Checks if inputed ticket price is not negative
    public static void NegativePrice(double price) throws NegativePriceException {
        if (price < 0.0) {
            throw new NegativePriceException();
        }
    }

    public static void main(String[] args) {
        Scanner obj = new Scanner(System.in);
        ArrayList<Double> Prices = new ArrayList<Double>(); // List to store ticket prices
        double sum = 0;

        while (true) {
            try {
                System.out.println(
                        "----------------------------------" +
                                "\n|  Ticket sales management system  |" +
                                "\n----------------------------------" +
                                "\n|1. Add ticket price             |" +
                                "\n|2. Update ticket price          |" +
                                "\n|3. Delete ticket price          |" +
                                "\n|4. List ticket prices           |" +
                                "\n|5. Calculate total sales        |" +
                                "\n|6. Calculate average price      |" +
                                "\n|7. Find maximum price           |" +
                                "\n|8. Find minimum price           |" +
                                "\n|9. Print total ticket count     |" +
                                "\n|10. Exit                        |" +
                                "\n----------------------------------" +
                                "\nEnter command (1 to 10): "
                );

                int number = obj.nextInt();
                obj.nextLine();

                if (number == 1) {
                    try {
                        System.out.println("Enter the ticket price: ");
                        double price = obj.nextDouble();

                        NegativePrice(price); // Checks if price is negative
                        Prices.add(price); // adds valid price to the array

                    } catch (NegativePriceException e) {
                        System.out.println(e.getMessage()); // Displays negative price exception
                    } catch (InputMismatchException e) {
                        System.out.println("Invalid input.");
                    }
                } else if (number == 2) {
                    if (Prices.isEmpty()) { // If there are no tickets, returns to menu
                        System.out.println("No ticket prices available.");
                        continue;
                    }
                    try {
                        System.out.println("Ticket Prices:");
                        // Displays all the ticket prices with respective indexes
                        int u = 0;
                        for (int i = 0; i < Prices.size(); i++) {
                            u++;
                            System.out.println(u + ". " + Prices.get(i) + "€");
                        }

                        System.out.println("Enter the ticket id number: ");
                        int id = obj.nextInt();
                        // Checks if id is valid
                        if (id < 1 || id > Prices.size()) {
                            System.out.println("Invalid input.");
                        } else {
                            System.out.println("Enter the ticket price: ");
                            double price = obj.nextDouble();
                            
                            NegativePrice(price); // Checks if new price is not negative

                            Prices.set(id - 1, price); // Updates the price
                            System.out.println("Ticket Price has been changed to " + price);
                        }

                    } catch (NegativePriceException e) {
                        System.out.println(e.getMessage()); // Displays negative price exception
                    } catch (InputMismatchException e) {
                        System.out.println("Invalid input.");
                    }
                } else if (number == 3) {
                    if (Prices.isEmpty()) {
                        System.out.println("No ticket prices available.");
                        continue;
                    }
                    try{
                        System.out.println("Ticket Prices:");
                        // Displays all the ticket prices with respective indexes
                        int u = 0;
                        for (int i = 0; i < Prices.size(); i++) {
                            u++;
                            System.out.println(u + ". " + Prices.get(i));
                        }

                        System.out.println("Enter the ticket id number: ");
                        int id = obj.nextInt();
                        // Checks if id is valid
                        if (id < 1 || id > Prices.size()) {
                            System.out.println("Invalid input.");
                        } else {
                            Prices.remove(id - 1); // Removes the selected price
                            System.out.println("The ticket price has been deleted");

                        }
                    } catch (InputMismatchException e) {
                        System.out.println("Invalid input. Try again");
                    }
                } else if (number == 4) {
                    if (Prices.isEmpty()) {
                        System.out.println("No ticket prices available.");
                        continue;
                    }
                    System.out.println("Ticket Prices:");
                    // Prints out all ticket prices
                    for (int i = 0; i < Prices.size(); i++) {
                        System.out.println(Prices.get(i) + "€");
                    }
                } else if (number == 5) {
                    if (Prices.isEmpty()) {
                        System.out.println("No ticket prices available.");
                        continue;
                    }
                    for (Double num : Prices) { // Loop through all ticket prices in the 'Prices' list
                        sum += num; // Adds each ticket price to the 'sum' variable
                    }
                    System.out.println("Total sales: " + sum);

                } else if (number == 6) {
                    if (Prices.isEmpty()) {
                        System.out.println("No ticket prices available.");
                        continue;
                    }
                    double average = sum / Prices.size(); // Divides the total sum by the number of prices in array
                    System.out.println("Average: " + average);

                } else if (number == 7) {
                    if (Prices.isEmpty()) {
                        System.out.println("No ticket prices available.");
                        continue;
                    }
                    double max = Prices.getFirst();
                    // loop to find the maximum value from the array
                    for (int i = 1; i < Prices.size(); i++) {
                        if (max < Prices.get(i))
                            max = Prices.get(i);
                    }
                    System.out.println("Maximum ticket price is : " + max);

                } else if (number == 8) {
                    if (Prices.isEmpty()) {
                        System.out.println("No ticket prices available.");
                        continue;
                    }
                    double min = Prices.getFirst();
                    // loop to find the minimum value from the array
                    for (int i = 1; i < Prices.size(); i++) {
                        if (min > Prices.get(i))
                            min = Prices.get(i);
                    }
                    System.out.println("Minimum ticket price is : " + min);
                } else if (number == 9) {
                    if (Prices.isEmpty()) {
                        System.out.println("No ticket prices available.");
                        continue;
                    }
                    // Prints out total ticket count in array
                    System.out.println("Total ticket count is " + Prices.size());

                } else if (number == 10) {
                    System.out.println("Thank you have a great day! \nExiting...");
                    obj.close();
                    System.exit(0);
                } else {
                    try {
                        InvalidMenuInput(number); // Checks menu input number
                    } catch (InvalidMenuInputException e) {
                        System.out.println(e.getMessage());
                    }
                }
            } catch (InputMismatchException e) { // Checks menu option input
                System.out.println("Invalid input. \n");
                obj.nextLine();
            }
        }
    }
}
