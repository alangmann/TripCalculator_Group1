package tripcalculator.gui;

import javax.swing.*;
import java.awt.*;

public class MyToggleButton extends JToggleButton{
    String text;

    public MyToggleButton(String text) {
        super(text);
        this.text = text;
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        if (this.isSelected()) {
            int w = getWidth();
            int h = getHeight();
            g.setColor(TripCalculatorGUI.COLOR_MEDIUM);
            g.fillRect(0, 0, w, h);
        }
    }
}
