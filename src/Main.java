import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the name of your Tamagotchi: ");
        String name = scanner.nextLine();
        Tamagotchi tamagotchi = new Tamagotchi(name);

        boolean running = true;

        while (running) {
            System.out.println("\nWhat do you want to do?");
            System.out.println("Type 'feed' to feed your Tamagotchi.");
            System.out.println("Type 'play' to play with your Tamagotchi.");
            System.out.println("Type 'status' to check your Tamagotchi's status.");
            System.out.println("Type 'quit' to exit.");

            String input = scanner.nextLine();

            if (input.equalsIgnoreCase("feed")) {
                tamagotchi.feed();
            } else if (input.equalsIgnoreCase("play")) {
                tamagotchi.play();
            } else if (input.equalsIgnoreCase("status")) {
                tamagotchi.checkStatus();
            } else if (input.equalsIgnoreCase("quit")) {
                running = false;
                System.out.println("Goodbye!");
            } else {
                System.out.println("Invalid input. Try again.");
            }
        }
    }
}
