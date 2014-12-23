package tripcalculator.gui;

import javax.swing.*;
import java.awt.*;

public class MyLabel extends JLabel{
    public MyLabel(String text) {
        super(text);
        init();
    }

    private void init() {
        this.setOpaque(true);
        this.setBackground(TripCalculatorGUI.COLOR_DARK);
        this.setForeground(Color.white);
        this.setFont(new Font("Helvetica", Font.BOLD, 25));
        this.setHorizontalAlignment(JLabel.CENTER);
    }
}
