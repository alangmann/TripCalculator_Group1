package tripcalculator.gui;

import com.jgoodies.looks.windows.WindowsLookAndFeel;

import javax.swing.*;
import java.awt.*;

public class TripCalculatorGUI extends JFrame {

    public TripCalculatorGUI()
    {
        super("TripCalculator");
        init();
    }

    private void init() {
        setLayout(new GridLayout(5, 1));
        setSize(500, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel pnRB = new JPanel(new GridLayout(1,2));
        pnRB.add(btCar);
        pnRB.add(btTruck);

        pane.add(pnRB);
        setVisible(true);
    }

    public static void main(String[] args) {
        try {
            UIManager.setLookAndFeel(new WindowsLookAndFeel());
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Failed to load Windows Look and Feel...", "LaF Error", JOptionPane.ERROR_MESSAGE);
        }
        new TripCalculatorGUI();
    }

    private Container pane = getContentPane();
    private JToggleButton btCar = new JToggleButton("Car");
    private JToggleButton btTruck = new JToggleButton("Truck");
}
