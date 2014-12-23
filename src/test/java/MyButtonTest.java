import org.junit.Test;
import tripcalculator.gui.MyButton;

import static org.junit.Assert.*;

public class MyButtonTest {

    @Test
    public void createWorks() {
        assertTrue(new MyButton("test").getText().equals("test"));
    }

}