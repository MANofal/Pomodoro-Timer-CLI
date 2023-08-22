package src.main.java.com.manofal.pomodoro;

import java.time.LocalTime;
import java.time.format.DateTimeParseException;
import java.util.Scanner;

public class PomodoroTimerCLI {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("\nWelcome to the Pomodoro Timer CLI!");
        System.out.println("===================================");

        PomodoroTimer pomodoro = readPomodoroTime(scanner);

        System.out.println("\nCalculating Pomodoro statistics...\n");

        pomodoro.printStatistics();

        System.out.println("\nThank you for using the Pomodoro Timer CLI!");

        scanner.close();
    }

    private static PomodoroTimer readPomodoroTime(Scanner scanner) {
        PomodoroTimer pomodoro = null;
        boolean validInput = false;

        while (!validInput) {
            LocalTime startTime = null;
            LocalTime endTime = null;

            while (!validInput) {
                try {
                    System.out.print("Enter start time (HH:mm): ");
                    startTime = LocalTime.parse(scanner.next());
                    validInput = true;
                } catch (DateTimeParseException e) {
                    System.out.println("Invalid input format. Please use the HH:mm format.");
                }
            }

            validInput = false;

            while (!validInput) {
                try {
                    System.out.print("Enter end time (HH:mm): ");
                    endTime = LocalTime.parse(scanner.next());
                    validInput = true;
                } catch (DateTimeParseException e) {
                    System.out.println("Invalid input format. Please use the HH:mm format.");
                }
            }

            validInput = false;

            try {
                pomodoro = new PomodoroTimer(startTime, endTime);
                validInput = true;
            } catch (IllegalArgumentException e) {
                System.out.println("The start time is after the end time. Please enter valid times.");
            }
        }

        return pomodoro;
    }
}
