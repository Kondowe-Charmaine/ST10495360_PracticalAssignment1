/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package trackerapp;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class ClientTest {

    private Client client;
    private CardioWorkout cardioWorkout;
    private StrengthWorkout strengthWorkout;

    @Before
    public void setUp() {
        client = new Client("John Doe", 30);
        cardioWorkout = new CardioWorkout("09/01/2025", 30, 350.5, 3.1, 9.68);
        strengthWorkout = new StrengthWorkout("09/02/2025", 45, 250.0, 185, 8);

        client.addWorkout(cardioWorkout);
        client.addWorkout(strengthWorkout);
    }

    @Test
    public void testAddWorkout() {
        assertEquals(2, client.getWorkouts().size());
        assertTrue(client.getWorkouts().get(0) instanceof CardioWorkout);
        assertTrue(client.getWorkouts().get(1) instanceof StrengthWorkout);
    }

    @Test
    public void testCalculateTotalCaloriesAndDuration() {
        String report = client.generateProgressReport();
        assertTrue(report.contains("Total Duration: 75 minutes"));
        assertTrue(report.contains("Total Calories Burned: 600.50"));
    }

    @Test
    public void testCardioWorkoutDetails() {
        assertTrue(client.getWorkouts().get(0) instanceof CardioWorkout);
        assertEquals("Type: Cardio, Distance: 3.10 miles, Pace: 9.68 min/mile", cardioWorkout.getDetails());
    }

    @Test
    public void testStrengthWorkoutDetails() {
        assertTrue(client.getWorkouts().get(1) instanceof StrengthWorkout);
        assertEquals("Type: Strength, Weight: 185 lbs, Reps: 8", strengthWorkout.getDetails());
    }

    @Test
    public void testClientAge() {
        assertEquals(30, client.getAge());
    }
}
