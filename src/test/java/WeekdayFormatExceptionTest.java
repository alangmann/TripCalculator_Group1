import org.junit.Test;
import tripcalculator.beans.WeekdayFormatException;

import static org.junit.Assert.assertTrue;

public class WeekdayFormatExceptionTest {

    @Test
    public void getMessageReturnsMessage() {
        assertTrue(new WeekdayFormatException().getMessage().equals("invalid weekday"));
    }
}
