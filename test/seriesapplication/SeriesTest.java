/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package seriesapplication;

import org.junit.Assert;
import org.junit.Test;
import  org.junit.jupiter.api.BeforeEach;

public class SeriesTest {

    public Series series;

    @Test
    public void TestSearchSeries() {
        Series series = new Series();//initialize 
        series.addSeries(1, "Blacklist", 12, 55); 

        Series result = series.searchSeries(1);
        Assert.assertNotNull(result);
        Assert.assertEquals("Blacklist", result.getName());
    }

    @Test
    public void TestSearchSeries_SeriesNotFound() {
        Series series = new Series(); //initialize

        Series result = series.searchSeries(99);
        Assert.assertNull(result);
    }

    @Test
    public void TestUpdateSeries() {
        Series series = new Series();//initialize 
        series.addSeries(1, "Blacklist", 12, 55); 

        boolean updated = series.updateSeries(1, "Landmark point", 18, 70);
        Assert.assertTrue(updated);

        Series result = series.searchSeries(1);
        Assert.assertNotNull(result);
        Assert.assertEquals("Landmark point", result.getName());
    }

    @Test
    public void TestDeleteSeries() {
        Series series = new Series();//initialize 
        series.addSeries(1, "Landmark point", 18, 70);

        boolean deleted = series.deleteSeries(1);
        Assert.assertTrue(deleted);
    }

    @Test
    public void TestDeleteSeries_SeriesNotFound() {
        Series series = new Series(); //initialize

        boolean deleted = series.deleteSeries(99);
        Assert.assertFalse(deleted);
    }

    @Test
    public void TestSeriesAgeRestriction_AgeValid() {
        Series series = new Series(); //initialize

        Assert.assertTrue(series.isAgeRestrictionValid(12));
        Assert.assertTrue(series.isAgeRestrictionValid(18));
        Assert.assertTrue(series.isAgeRestrictionValid(2));
    }

    @Test
    public void TestSeriesAgeRestriction_SeriesAgeInValid() {
        Series series = new Series(); //initialize

        Assert.assertFalse(series.isAgeRestrictionValid(1));
        Assert.assertFalse(series.isAgeRestrictionValid(25));
    }
}