import org.junit.Test;
import tripcalculator.gui.MyLabel;

import static org.junit.Assert.*;

public class MyLabelTest {

    @Test
    public void createWorks() {
        assertTrue(new MyLabel("test").getText().equals("test"));
    }

}