/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package trackerapp;

public abstract class Workout {
    
    // These are our variables, called "fields." They are private to protect them.
    private String date;
    private int durationMinutes;
    private double caloriesBurned;

    // This is the constructor. It's a special method that runs when we create a new Workout.
    public Workout(String date, int durationMinutes, double caloriesBurned) {
        this.date = date;
        this.durationMinutes = durationMinutes;
        this.caloriesBurned = caloriesBurned;
    }

    
    //GETTERS
    // They are public so other parts of the program can access the data safely.
    public String getDate() {
        return date;
    }

    public int getDurationMinutes() {
        return durationMinutes;
    }

    public double getCaloriesBurned() {
        return caloriesBurned;
    }

    
    // SETTERS
    // They are also public and provide a controlled way to update the data.
    public void setDate(String newDate) {
        // We use "this.date" to refer to the class's variable.
        this.date = newDate;
    }

    public void setDurationMinutes(int newDuration) {
        // We can add rules here to make sure the data is valid.
        // For example, a workout duration should not be negative.
        if (newDuration >= 0) {
            this.durationMinutes = newDuration;
        }
    }

    public void setCaloriesBurned(double newCalories) {
        this.caloriesBurned = newCalories;
    }

    // This is an abstract method. Any class that inherits from this one MUST create this method.
    public abstract String getDetails();

    // The toString() method helps us print a clear description of the object.
    @Override
    public String toString() {
        return "Date: " + date + ", Duration: " + durationMinutes + " mins, Calories Burned: " + caloriesBurned;
    }
}