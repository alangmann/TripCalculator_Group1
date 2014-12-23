package tripcalculator.fuel;

import tripcalculator.beans.WeekdayFormatException;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;

public class Fuel extends FuelTypes {

    private static Fuel instance;
    private HashMap<Day, double[]> fuelMap = new HashMap<>();

    public Fuel() throws IOException, WeekdayFormatException {
        loadData();
    }

    public static Fuel getInstance() throws IOException, WeekdayFormatException {
        if (instance == null) {
            instance = new Fuel();
        }
        return instance;
    }

    public static Fuel getInstance(boolean newInstance) throws IOException, WeekdayFormatException {
        if (instance == null || newInstance) {
            instance = new Fuel();
        }
        return instance;
    }

    private void loadData() throws WeekdayFormatException, IOException {
        FileReader fr = new FileReader(getClass().getResource("sprit_db.csv").getFile());
        BufferedReader reader = new BufferedReader(fr);
        String line;
        while ((line = reader.readLine()) != null) {
            line = line.replace(",", ".");
            String props[] = line.split(";");
            double[] values = {Double.parseDouble(props[1]), Double.parseDouble(props[2])};
            fuelMap.put(stringToDay(props[0]), values);
        }
        reader.close();
    }

    public Day stringToDay(String day) throws WeekdayFormatException {
        day = day.toLowerCase();
        switch (day) {
            case "sunday":
            case "sonntag":
                return Day.SUNDAY;
            case "monday":
            case "montag":
                return Day.MONDAY;
            case "tuesday":
            case "dienstag":
                return Day.TUESDAY;
            case "wednesday":
            case "mittwoch":
                return Day.WEDNESDAY;
            case "thursday":
            case "donnerstag":
                return Day.THURSDAY;
            case "friday":
            case "freitag":
                return Day.FRIDAY;
            case "saturday":
            case "samstag":
                return Day.SATURDAY;
            default:
                throw new WeekdayFormatException();
        }
    }

    public Double getPrice(Day day, FuelType type) {
        if (type == FuelType.DIESEL) {
            return getDiesel(day);
        } else {
            return getPetrol(day);
        }
    }

    public Double getDiesel(Day day) {
        return fuelMap.get(day)[0];
    }

    public Double getPetrol(Day day) {
        return fuelMap.get(day)[1];
    }

    public enum Day {
        SUNDAY, MONDAY, TUESDAY, WEDNESDAY,
        THURSDAY, FRIDAY, SATURDAY
    }
}
