import org.junit.Before;
import org.junit.Test;
import tripcalculator.beans.WeekdayFormatException;
import tripcalculator.fuel.Fuel;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

import static org.junit.Assert.assertTrue;

public class FuelTest {

    private Fuel testFuel;

    @Before
    public void setUp() throws Exception {
        testFuel = Fuel.getInstance();
    }

    @Test
    public void dieselGetsDiesel() throws IOException, WeekdayFormatException {
        createRightFile();
        assertTrue(testFuel.getDiesel(Fuel.Day.MONDAY) > 0);
    }

    @Test
    public void petrolGetsPetrol() throws IOException, WeekdayFormatException {
        createRightFile();
        assertTrue(testFuel.getPetrol(Fuel.Day.MONDAY) > 0);
    }

    @Test(expected = WeekdayFormatException.class)
    public void invalidFileCausesException() throws IOException, WeekdayFormatException {
        createWrongFile();
    }

    private void createWrongFile() throws IOException, WeekdayFormatException {
        FileWriter fw = new FileWriter(testFuel.getClass().getResource("sprit_db.csv").getFile());
        BufferedWriter bw = new BufferedWriter(fw);
        bw.write("invalidWeekDay;1,0;2,0");
        bw.close();
        reassignTestClass();
    }

    private void createRightFile() throws IOException, WeekdayFormatException {
        FileWriter fw = new FileWriter(testFuel.getClass().getResource("sprit_db.csv").getFile());
        BufferedWriter bw = new BufferedWriter(fw);
        bw.write("Monday;1,0;2,0");
        bw.newLine();
        bw.write("Tuesday;1,284;1,402\nWednesday;1,299;1,387\nThursday;1,315;1,379\nFriday;1,301;1,367\nSaturday;1,365;1,413\nSunday;1,365;1,413");
        bw.close();
        reassignTestClass();
    }

    private void reassignTestClass() throws IOException, WeekdayFormatException {
        testFuel = null;
        testFuel = Fuel.getInstance(true);
    }

}
