# Pomodoro Timer CLI

The Pomodoro Timer CLI is a command-line interface program designed to help users manage their study or work sessions using the Pomodoro technique. The Pomodoro technique is a time management method that involves breaking work into focused intervals called "pomodoros," followed by short rest periods.

## Usage

Upon running the program, you will be guided through the following steps:

1. **Welcome Message:** A welcome message and program information will be displayed.
2. **Enter Times:** You will be prompted to enter the start and end times for your study or work session. Please use the format "HH:mm" (e.g., 09:00 for 9:00 AM).
3. **Statistics Calculation:** The program will calculate and display Pomodoro statistics, including start and end times, total time, number of study and rest sessions, total study and rest time, and extra minutes.
4. **Thank You:** After displaying the statistics, a thank-you message will appear, and the program will close.

## Features

- **Input Validation:** The program validates user input to ensure that the entered times are in the correct format ("HH:mm"). If the input format is incorrect, an error message will be shown.

- **Handling Invalid Time Range:** The program checks whether the start time is after the end time. If this condition is met, the program will display an error message and prompt the user to enter valid times.

- **Dynamic Session Tracking:** Utilizing the Pomodoro technique, the program dynamically calculates study and rest sessions based on the entered time range.

- **Clean and Modular Design:** The code is organized in a structured manner. The PomodoroCLI class manages the user interface, while the Pomodoro class handles the Pomodoro technique and statistics calculation.

## How It Works

1. The user enters the start and end times for their study or work session.

2. The program calculates the total session time and tracks study and rest sessions using the Pomodoro technique.

3. The calculated statistics are displayed, indicating the number of sessions, total study time, total rest time, and extra minutes.

4. The program offers an intuitive interface for effectively managing study and rest sessions.

## Thank You

Thank you for using the Pomodoro Timer CLI to enhance your productivity and time management skills. We hope this program assists you in maintaining focus and organization during your study or work sessions.
