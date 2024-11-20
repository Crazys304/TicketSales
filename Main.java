import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner obj = new Scanner(System.in);
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

        }
    }
}
