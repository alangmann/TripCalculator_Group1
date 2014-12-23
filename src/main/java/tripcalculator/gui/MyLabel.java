package tripcalculator.gui;

import javax.swing.*;
import java.awt.*;

/**
 * Created by Lukas on 22.12.2014.
 */
public class MyLabel extends JLabel{
    public MyLabel(String text) {
        super(text);
        init();
    }

    private void init() {
        this.setOpaque(true);
        this.setBackground(TripCalculatorGUI.COLOR_DARK);
        this.setForeground(Color.white);
        this.setFont(new Font("Agency FB", Font.BOLD, 25));
        this.setHorizontalAlignment(JLabel.CENTER);
    }
}
