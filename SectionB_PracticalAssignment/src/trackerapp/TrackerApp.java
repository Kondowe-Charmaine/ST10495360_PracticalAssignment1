/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package trackerapp;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TrackerApp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // List to store multiple clients
        List<Client> clients = new ArrayList<>();
        boolean isRunning = true; // Control variable for main menu loop

        // Main menu loop
        while (isRunning) {
            System.out.println("\n--- Health and Wellness Tracker ---");
            System.out.println("1. Add new client");
            System.out.println("2. Log a workout for a client");
            System.out.println("3. Generate a progress report for a client");
            System.out.println("4. Exit");
            System.out.print("Please select an option: ");
            String choice = scanner.nextLine();

            if (choice.equals("1")) {
                // ------------------- Add New Client -------------------
                System.out.print("Enter client's name: ");
                String clientName = scanner.nextLine();

                // Validate client age input
                int clientAge = -1;
                while (clientAge < 0) {
                    System.out.print("Enter client's age: ");
                    String ageInput = scanner.nextLine();
                    if (ageInput.matches("\\d+")) {
                        clientAge = Integer.parseInt(ageInput);
                        if (clientAge < 0) System.out.println("Age cannot be negative. Try again.");
                    } else {
                        System.out.println("Invalid input. Enter a valid number.");
                    }
                }

                // Add the new client to the list
                clients.add(new Client(clientName, clientAge));
                System.out.println("✅ Client added successfully!");

            } else if (choice.equals("2")) {
                // ------------------- Log Workout -------------------
                if (clients.isEmpty()) {
                    System.out.println("⚠️ No clients available. Add a client first.");
                } else {
                    // Select client to log workout for
                    System.out.println("Select a client:");
                    for (int i = 0; i < clients.size(); i++) {
                        System.out.println((i + 1) + ". " + clients.get(i).getName());
                    }
                    int clientIndex = -1;
                    while (clientIndex < 0) {
                        System.out.print("Enter client number: ");
                        String input = scanner.nextLine();
                        if (input.matches("\\d+")) {
                            int index = Integer.parseInt(input) - 1;
                            if (index >= 0 && index < clients.size()) clientIndex = index;
                            else System.out.println("Invalid client number. Try again.");
                        } else {
                            System.out.println("Invalid input. Enter a number.");
                        }
                    }
                    Client client = clients.get(clientIndex);

                    // Prompt for workout type
                    System.out.print("Is it Cardio (C) or Strength (S)? ");
                    String type = scanner.nextLine().toUpperCase();

                    // Prompt for workout date
                    System.out.print("Enter workout date (MM/DD/YYYY): ");
                    String date = scanner.nextLine();

                    // Prompt for duration with validation
                    int duration = -1;
                    while (duration < 0) {
                        System.out.print("Enter duration in minutes: ");
                        String input = scanner.nextLine();
                        if (input.matches("\\d+")) duration = Integer.parseInt(input);
                        else System.out.println("Invalid input. Enter a number.");
                    }

                    // Prompt for calories burned with validation
                    double calories = -1;
                    while (calories < 0) {
                        System.out.print("Enter estimated calories burned: ");
                        String input = scanner.nextLine();
                        if (input.matches("\\d+(\\.\\d+)?")) calories = Double.parseDouble(input);
                        else System.out.println("Invalid input. Enter a number.");
                    }

                    // ------------------- Cardio Workout -------------------
                    if (type.equals("C")) {
                        double distance = -1;
                        while (distance < 0) {
                            System.out.print("Enter distance in miles: ");
                            String input = scanner.nextLine();
                            if (input.matches("\\d+(\\.\\d+)?")) distance = Double.parseDouble(input);
                            else System.out.println("Invalid input. Enter a number.");
                        }

                        double pace = -1;
                        while (pace < 0) {
                            System.out.print("Enter pace (minutes per mile): ");
                            String input = scanner.nextLine();
                            if (input.matches("\\d+(\\.\\d+)?")) pace = Double.parseDouble(input);
                            else System.out.println("Invalid input. Enter a number.");
                        }

                        // Add cardio workout to the client
                        client.addWorkout(new CardioWorkout(date, duration, calories, distance, pace));

                    // ------------------- Strength Workout -------------------
                    } else if (type.equals("S")) {
                        int weight = -1;
                        while (weight < 0) {
                            System.out.print("Enter weight lifted (lbs): ");
                            String input = scanner.nextLine();
                            if (input.matches("\\d+")) weight = Integer.parseInt(input);
                            else System.out.println("Invalid input. Enter a number.");
                        }

                        int reps = -1;
                        while (reps < 0) {
                            System.out.print("Enter number of reps: ");
                            String input = scanner.nextLine();
                            if (input.matches("\\d+")) reps = Integer.parseInt(input);
                            else System.out.println("Invalid input. Enter a number.");
                        }

                        // Add strength workout to the client
                        client.addWorkout(new StrengthWorkout(date, duration, calories, weight, reps));

                    } else {
                        System.out.println("Invalid workout type. Please choose C or S.");
                    }

                    // ------------------- Towel Logic -------------------
                    System.out.print("Is this your first workout? (Y/N): ");
                    String firstTimer = scanner.nextLine().toUpperCase();

                    if (firstTimer.equals("Y")) {
                        System.out.println("🎁 Congratulations! You get free towels for today's workout!");
                    } else if (firstTimer.equals("N")) {
                        System.out.println("⚠️ Towels cost R100 for returning clients.");
                        System.out.print("Enter 1 to pay R100 for a towel, or 0 to skip: ");
                        String payChoice = scanner.nextLine();
                        if (payChoice.equals("1")) System.out.println("💰 Payment successful! You received a towel. Enjoy!");
                        else System.out.println("❌ You chose not to pay. No towel provided.");
                    } else {
                        System.out.println("Invalid input. Assuming returning client. Towels cost R100.");
                    }

                    System.out.println("✅ Workout logged successfully!");
                }

            // ------------------- Generate Progress Report -------------------
            } else if (choice.equals("3")) {
                if (clients.isEmpty()) {
                    System.out.println("⚠️ No clients available. Add a client first.");
                } else {
                    // Select client for report
                    System.out.println("Select a client:");
                    for (int i = 0; i < clients.size(); i++) {
                        System.out.println((i + 1) + ". " + clients.get(i).getName());
                    }
                    int clientIndex = -1;
                    while (clientIndex < 0) {
                        System.out.print("Enter client number: ");
                        String input = scanner.nextLine();
                        if (input.matches("\\d+")) {
                            int index = Integer.parseInt(input) - 1;
                            if (index >= 0 && index < clients.size()) clientIndex = index;
                            else System.out.println("Invalid client number. Try again.");
                        } else {
                            System.out.println("Invalid input. Enter a number.");
                        }
                    }

                    Client client = clients.get(clientIndex);
                    System.out.println(client.generateProgressReport());
                }

            // ------------------- Exit -------------------
            } else if (choice.equals("4")) {
                isRunning = false;
                System.out.println("Exiting application. Goodbye!");

            } else {
                // Invalid menu option
                System.out.println("Invalid option. Please try again.");
            }
        }

        // Close scanner to release resources
        scanner.close();
    }
}
