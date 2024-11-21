import java.util.Scanner;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        Scanner obj = new Scanner(System.in);
        ArrayList<Double> Prices = new ArrayList<Double>();
        double sum = 0;

        while (true) {
            //try {
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
                    System.out.println("Enter the ticket price: ");
                    double price = obj.nextDouble();

                    Prices.add(price);
                }
                else if (number == 2) {
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

                    Prices.set(id - 1, price);
                    System.out.println("Ticket Price has been changed to " + price);
                }
                else if (number == 3) {
                    System.out.println("Ticket Prices:");

                    int u = 0;
                    for (int i = 0; i < Prices.size(); i++) {
                        u++;
                        System.out.println(u + ". " + Prices.get(i));
                    }

                    System.out.println("Enter the ticket id number: ");
                    int id = obj.nextInt();
                    Prices.remove(id - 1);
                    System.out.println("The ticket price has been deleted");
                }
                else if (number == 4) {
                    System.out.println("Ticket Prices:");

                    for (int i = 0; i < Prices.size(); i++) {
                        System.out.println(Prices.get(i) + "€");
                    }
                } else if (number == 5) {
                    for (Double num : Prices) {
                        sum += num;
                    }
                    System.out.println("Total sales: " + sum);

                }else if (number == 6) {
                    double average = sum / Prices.size();
                    System.out.println("Average: " + average);

                }else if (number == 7) {
                    double max = Prices.getFirst();
                    // loop to find maximum value from ArrayList
                    for (int i = 1; i < Prices.size(); i++) {
                        if (max < Prices.get(i))
                            max = Prices.get(i);
                    }
                    System.out.println("Maximum ticket price is : " + max);

                }else if (number == 8) {
                    double min = Prices.getFirst();
                    // loop to find minimum value from ArrayList
                    for (int i = 1; i < Prices.size(); i++) {
                        if (min > Prices.get(i))
                            min = Prices.get(i);
                    }
                    System.out.println("Minimum ticket price is : " + min);
                }
                else if (number == 9) {
                    System.out.println("Thank you have a great day! \nExiting...");
                    obj.close();
                    System.exit(0);
                }
        }
    }
}
