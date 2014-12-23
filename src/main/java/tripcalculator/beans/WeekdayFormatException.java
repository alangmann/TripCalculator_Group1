package tripcalculator.beans;

public class WeekdayFormatException extends Exception {
    @Override
    public String getMessage() {
        return "invalid weekday";
    }
}
