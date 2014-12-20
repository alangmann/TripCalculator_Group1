package tripcalculator.gui;

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
        new TripCalculatorGUI();
    }

    public JRadioButton btCar = new JRadioButton("tripcalculator.vehicle.Car");
    public JRadioButton btTruck = new JRadioButton("tripcalculator.vehicle.Truck");
}
