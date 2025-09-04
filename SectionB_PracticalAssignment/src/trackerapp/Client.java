/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package trackerapp;

import java.util.ArrayList;
import java.util.List;

public class Client {
    private String name;      // Store client's name
    private int age;          // Store client's age
    private List<Workout> workouts; // List to store all workouts for this client

    // Constructor
    // Initializes a new client with a name, age, and empty workout list
    public Client(String name, int age) {
        this.name = name;
        this.age = age;
        this.workouts = new ArrayList<>();
    }

    //Getters 

    // Returns the client's name (used in TrackerApp for display)
    public String getName() {
        return name;
    }

    // Returns the client's age
    public int getAge() {
        return age;
    }

    // Returns the list of workouts for this client
    public List<Workout> getWorkouts() {
        return workouts;
    }

    // Methods

    // Add a new workout to the client's list
    public void addWorkout(Workout workout) {
        workouts.add(workout);
    }

    // Generate a progress report for the client
    public String generateProgressReport() {
        // If no workouts, return a friendly message
        if (workouts.isEmpty()) {
            return "No workout data available for " + name + ".";
        }

        // Calculate total duration and calories
        int totalDuration = 0;
        double totalCalories = 0;
        for (Workout w : workouts) {
            totalDuration += w.getDurationMinutes();
            totalCalories += w.getCaloriesBurned();
        }

        // Return formatted progress report
        return "Progress report for " + name + ":\n"
                + "Total Duration: " + totalDuration + " minutes\n"
                + "Total Calories Burned: " + String.format("%.2f", totalCalories);
    }
}
