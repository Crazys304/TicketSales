import java.util.Scanner;
import java.util.ArrayList;
import java.util.InputMismatchException;

class InvalidMenuInputException extends Exception {
    public InvalidMenuInputException() {
        super("Invalid option. Input numbers between 1 and 9");
    }
}

class NegativePriceException extends Exception {
    public NegativePriceException() {
        super("The Price cannot be negative");
    }
}

public class Main {

    public static void InvalidMenuInput(int number) throws InvalidMenuInputException {
        if (number < 1 || number > 9) {
            throw new InvalidMenuInputException();
        }
    }

    public static void NegativePrice(double price) throws NegativePriceException {
        if (price < 0.0) {
            throw new NegativePriceException();
        }
    }

    public static void main(String[] args) {
        Scanner obj = new Scanner(System.in);
        ArrayList<Double> Prices = new ArrayList<Double>();
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
                                "\n|9. Exit                         |" +
                                "\n----------------------------------" +
                                "\nEnter command (1 to 9): "
                );

                int number = obj.nextInt();
                obj.nextLine();

                if (number == 1) {
                    try {
                        System.out.println("Enter the ticket price: ");
                        double price = obj.nextDouble();

                        NegativePrice(price);

                        Prices.add(price);

                    } catch (NegativePriceException e) {
                        System.out.println(e.getMessage());
                    } catch (InputMismatchException e) {
                        System.out.println("Invalid input.");
                    }
                } else if (number == 2) {
                    try {
                        System.out.println("Ticket Prices:");

                        int u = 0;
                        for (int i = 0; i < Prices.size(); i++) {
                            u++;
                            System.out.println(u + ". " + Prices.get(i) + "€");
                        }

                        System.out.println("Enter the ticket id number: ");
                        int id = obj.nextInt();
                        System.out.println("Enter the ticket price: ");
                        double price = obj.nextDouble();

                        NegativePrice(price);

                        Prices.set(id - 1, price);
                        System.out.println("Ticket Price has been changed to " + price);
                    } catch (NegativePriceException e) {
                        System.out.println(e.getMessage());
                    } catch (InputMismatchException e) {
                        System.out.println("Invalid input.");
                    }
                } else if (number == 3) {
                    try{
                        System.out.println("Ticket Prices:");

                        int u = 0;
                        for (int i = 0; i < Prices.size(); i++) {
                            u++;
                            System.out.println(u + ". " + Prices.get(i));
                        }

                        System.out.println("Enter the ticket id number: ");
                        int id = obj.nextInt();
                        if (id < Prices.size() || id > Prices.size()) {
                            System.out.println("Invalid input.");
                        } else {
                            Prices.remove(id - 1);
                            System.out.println("The ticket price has been deleted");

                        }
                    } catch (InputMismatchException e) {
                        System.out.println("Invalid input. Try again");
                    }
                } else if (number == 4) {
                    try {
                        System.out.println("Ticket Prices:");

                        for (int i = 0; i < Prices.size(); i++) {
                            System.out.println(Prices.get(i) + "€");
                        }
                    } catch (InputMismatchException e) {
                        System.out.println("Invalid input.");
                    }
                } else if (number == 5) {
                    try {
                        for (Double num : Prices) {
                            sum += num;
                        }
                        System.out.println("Total sales: " + sum);

                    } catch (InputMismatchException e) {
                        System.out.println("Invalid input.");
                    }
                } else if (number == 6) {
                    try {
                        double average = sum / Prices.size();
                        System.out.println("Average: " + average);

                    } catch (InputMismatchException e) {
                        System.out.println("Invalid input.");
                    }
                } else if (number == 7) {
                    try {
                        double max = Prices.getFirst();
                        // loop to find the maximum value from the array
                        for (int i = 1; i < Prices.size(); i++) {
                            if (max < Prices.get(i))
                                max = Prices.get(i);
                        }
                        System.out.println("Maximum ticket price is : " + max);

                    } catch (InputMismatchException e) {
                        System.out.println("Invalid input.");
                    }
                } else if (number == 8) {
                    try {
                        double min = Prices.getFirst();
                        // loop to find the minimum value from the array
                        for (int i = 1; i < Prices.size(); i++) {
                            if (min > Prices.get(i))
                                min = Prices.get(i);
                        }
                        System.out.println("Minimum ticket price is : " + min);

                    } catch (InputMismatchException e) {
                        System.out.println("Invalid input.");
                    }
                } else if (number == 9) {
                    System.out.println("Thank you have a great day! \nExiting...");
                    obj.close();
                    System.exit(0);
                } else {
                    try {
                        InvalidMenuInput(number);
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
