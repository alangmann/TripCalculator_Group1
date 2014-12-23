import org.junit.Before;
import org.junit.Test;
import tripcalculator.gui.AddTripDialog;
import tripcalculator.gui.TripCalculatorGUI;

import static org.junit.Assert.*;

public class TripCalculatorGUITest {

    private TripCalculatorGUI gui;

    @Before
    public void setUp() throws Exception {
        gui = new TripCalculatorGUI();
    }

    @Test
    public void setVisibleWorks() {
        gui.setVisible(true);
        assertTrue(gui.getWidth() > 0);
    }

    @Test
    public void dialogWorks() {
        AddTripDialog dialog = new AddTripDialog(gui, false);
        dialog.setVisible(true);
        assertTrue(dialog.getWidth() > 0);
    }
}