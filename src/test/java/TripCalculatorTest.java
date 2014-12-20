import org.junit.Test;
import static org.junit.Assert.assertTrue;

public class TripCalculatorTest {

    @Test
    public void loadRoutesWorks() {
        assertTrue(TripCalculator.getInstance().getRoutes().size() > 0);
    }


}