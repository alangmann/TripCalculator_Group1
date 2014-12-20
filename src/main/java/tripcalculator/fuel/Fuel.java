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

    public static Fuel getInstance()
    {
        if(instance == null){
            try {
                instance = new Fuel();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return instance;
    }

    private void loadData() throws Exception {
        FileReader fr = new FileReader(getClass().getResource("sprit_db.csv").getFile());
        BufferedReader reader = new BufferedReader(fr);
        String line;
        while((line = reader.readLine()) != null) {
            line = line.replace(",", ".");
            String props[] = line.split(";");
            double[] values =  {Double.parseDouble(props[1]), Double.parseDouble(props[2])};
            fuelMap.put(stringToDay(props[0]), values);
        }
        reader.close();
    }

    private Day stringToDay(String day) throws Exception {
        day = day.toLowerCase();
        if(day.equals("sunday")) {
            return Day.SUNDAY;
        } else if (day.equals("monday")) {
            return Day.MONDAY;
        } else if (day.equals("tuesday")) {
            return Day.TUESDAY;
        } else if (day.equals("wednesday")) {
            return Day.WEDNESDAY;
        } else if (day.equals("thursday")) {
            return Day.THURSDAY;
        } else if (day.equals("friday")) {
            return Day.FRIDAY;
        } else if (day.equals("saturday")) {
            return Day.SATURDAY;
        }
        throw new Exception("invalid day");
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
