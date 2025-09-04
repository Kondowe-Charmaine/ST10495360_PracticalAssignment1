/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package trackerapp;

// CardioWorkout inherits from Workout, so it gets all of Workout's features.
public class CardioWorkout extends Workout {
    
    // These are the unique variables for a cardio workout.
    private double distanceMiles;
    private double paceMinutesPerMile;

    // The constructor calls super() to pass information to the parent class, then sets its own variables.
    public CardioWorkout(String date, int durationMinutes, double caloriesBurned, double distanceMiles, double paceMinutesPerMile) {
        super(date, durationMinutes, caloriesBurned);
        this.distanceMiles = distanceMiles;
        this.paceMinutesPerMile = paceMinutesPerMile;
    }

    // Getters and setters for the unique variables.
    public double getDistanceMiles() {
        return distanceMiles;
    }

    public void setDistanceMiles(double newDistance) {
        this.distanceMiles = newDistance;
    }
    
    public double getPaceMinutesPerMile() {
        return paceMinutesPerMile;
    }

    public void setPaceMinutesPerMile(double newPace) {
        this.paceMinutesPerMile = newPace;
    }

    // This method is required by the parent class.
    @Override
    public String getDetails() {
        return String.format("Type: Cardio, Distance: %.2f miles, Pace: %.2f min/mile", distanceMiles, paceMinutesPerMile);
    }
}