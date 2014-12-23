import org.junit.Before;
import org.junit.Test;
import tripcalculator.bl.TripTableRenderer;

import javax.swing.*;

import static org.junit.Assert.*;

public class TripTableRendererTest {

    private TripTableRenderer renderer;

    @Before
    public void setUp() throws Exception {
        renderer = new TripTableRenderer();
    }

    @Test
    public void getComponentReturnsLabel () {
        assertTrue(renderer.getTableCellRendererComponent(new JTable(), new Object(), true, true, 0, 0) instanceof JLabel);
    }

    @Test
    public void getUnselectedComponentReturnsLabel () {
        assertTrue(renderer.getTableCellRendererComponent(new JTable(), new Object(), false, false, 0, 0) instanceof JLabel);
    }
}