package tripcalculator.gui;

import com.jgoodies.looks.windows.WindowsLookAndFeel;
import tripcalculator.fuel.FuelTypes;

import javax.swing.*;
import java.awt.*;

public class TripCalculatorGUI extends JFrame {

    public TripCalculatorGUI()
    {
        super("TripCalculator");
        init();
    }

    private void init() {
        setLayout(new GridLayout(6, 2));
        setSize(300, 500);
        setMinimumSize(new Dimension(200, 400));
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        btgVehicle.add(btCar);
        btgVehicle.add(btTruck);

        btCar.setSelected(true);

        pane.add(btCar);
        pane.add(btTruck);
        pane.add(new JLabel("Average Consumption"));
        pane.add(tfAverageConsumption);
        pane.add(new JLabel("Fuel Type"));
        pane.add(cbFuelType);
        pane.add(new JLabel("Cargo"));
        pane.add(tfCargo);
        pane.add(new JLabel("Axles"));
        pane.add(tfAxles);
        setVisible(true);
        pane.add(new JLabel("Blue"));
        pane.add(cbBlue);

        int shortSide = btCar.getWidth() < btCar.getHeight() ? btCar.getWidth() : btCar.getHeight();
        shortSide *= 0.5;
        btCar.setIcon(new ImageIcon(new ImageIcon(getClass().getResource("car.png")).getImage().getScaledInstance(shortSide,shortSide,Image.SCALE_SMOOTH)));
        btTruck.setIcon(new ImageIcon(new ImageIcon(getClass().getResource("truck.png")).getImage().getScaledInstance(shortSide,shortSide,Image.SCALE_SMOOTH)));
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
    private ButtonGroup btgVehicle = new ButtonGroup();
    private JToggleButton btCar = new JToggleButton("Car");
    private JToggleButton btTruck = new JToggleButton("Truck");
    private JTextField tfAverageConsumption = new JTextField();
    private JComboBox<String> cbFuelType = new JComboBox<>();
    private JTextField tfCargo = new JTextField();
    private JTextField tfAxles = new JTextField();
    private JCheckBox cbBlue = new JCheckBox();
}
