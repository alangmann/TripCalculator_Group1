import org.junit.Test;
import tripcalculator.gui.MyToggleButton;

import static org.junit.Assert.*;

public class MyToggleButtonTest {

    @Test
    public void createWorks() {
        assertTrue((new MyToggleButton("test")).getText().equals("test"));
    }
}