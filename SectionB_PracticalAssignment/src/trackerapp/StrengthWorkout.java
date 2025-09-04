/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package trackerapp;

// StrengthWorkout also inherits from Workout.
public class StrengthWorkout extends Workout {
    
    // These are the unique variables for a strength workout.
    private int weightLifted;
    private int reps;

    // The constructor calls the parent's constructor, then sets its unique variables.
    public StrengthWorkout(String date, int durationMinutes, double caloriesBurned, int weightLifted, int reps) {
        super(date, durationMinutes, caloriesBurned);
        this.weightLifted = weightLifted;
        this.reps = reps;
    }

    // Getters and setters for the unique variables.
    public int getWeightLifted() {
        return weightLifted;
    }

    public void setWeightLifted(int newWeight) {
        this.weightLifted = newWeight;
    }
    
    public int getReps() {
        return reps;
    }

    public void setReps(int newReps) {
        this.reps = newReps;
    }

    // This method is required by the parent class.
    @Override
    public String getDetails() {
        return "Type: Strength, Weight: " + weightLifted + " lbs, Reps: " + reps;
    }
}