package tripcalculator.fuel;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.HashMap;

public class Fuel {

    private static Fuel instance;
    private HashMap<Day, double[]> fuelMap = new HashMap<>();

    public Fuel() throws Exception {
        loadData();
    }

    public static Fuel getInstance() throws Exception {
        if (instance == null) {
            instance = new Fuel();
        }
        return instance;
    }

    private void loadData() throws Exception {
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

    private Day stringToDay(String day) throws Exception {
        day = day.toLowerCase();
        switch (day) {
            case "sunday":
                return Day.SUNDAY;
            case "monday":
                return Day.MONDAY;
            case "tuesday":
                return Day.TUESDAY;
            case "wednesday":
                return Day.WEDNESDAY;
            case "thursday":
                return Day.THURSDAY;
            case "friday":
                return Day.FRIDAY;
            case "saturday":
                return Day.SATURDAY;
            default:
                throw new Exception("invalid day");
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
