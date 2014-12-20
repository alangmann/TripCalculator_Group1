package tripcalculator.gui;

import com.jgoodies.looks.windows.WindowsLookAndFeel;

import javax.swing.*;
import java.awt.*;

public class TripCalculatorGUI extends JFrame {

    public TripCalculatorGUI()
    {
        super("tripcalculator.bl.TripCalculator");

        init();
    }

    private void init() {
        this.setLayout(new GridLayout(5,1));
        this.setSize(500,500);

        JPanel pnRB = new JPanel(new GridLayout(1,2));
        pnRB.add(btCar);
        pnRB.add(btTruck);

        this.getContentPane().add(pnRB);
        this.setVisible(true);
    }

    public static void main(String[] args) {
        try {
            UIManager.setLookAndFeel(new WindowsLookAndFeel());
        } catch (Exception e) { }
        new TripCalculatorGUI();
    }


    private JToggleButton btCar = new JToggleButton("Car");
    private JToggleButton btTruck = new JToggleButton("Truck");
}
