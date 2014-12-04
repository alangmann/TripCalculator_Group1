/**
 * Created by andreas.langmann on 12.11.2014.
 */
public class TripCalculator {

    private static TripCalculator calculator = new TripCalculator();

    private TripCalculator() {

    }

    public static TripCalculator getInstance() {
        return calculator;
    }
}
