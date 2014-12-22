package tripcalculator.gui;

import com.jgoodies.looks.windows.WindowsLookAndFeel;
import tripcalculator.fuel.FuelTypes;

import javax.swing.*;
import javax.swing.text.NumberFormatter;
import java.awt.*;
import java.text.NumberFormat;

public class TripCalculatorGUI extends JFrame {

    public final static Color COLOR_DARK = new Color(47, 117, 181);
    public final static Color COLOR_MEDIUM = new Color(155, 194, 230);
    public final static Color COLOR_LIGHT = new Color(189, 214, 238);

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

        cbFuelType.addItem("Diesel");
        cbFuelType.addItem("Patrol");

        colorEverything();

        pane.add(btCar);
        pane.add(btTruck);
        pane.add(lbAverageConsumption);
        pane.add(tfAverageConsumption);
        pane.add(lbFuelType);
        pane.add(cbFuelType);
        pane.add(lbCargo);
        pane.add(tfCargo);
        pane.add(lbAxles);
        pane.add(tfAxles);
        setVisible(true);
        pane.add(lbBlue);
        pane.add(cbBlue);

        int shortSide = btCar.getWidth() < btCar.getHeight() ? btCar.getWidth() : btCar.getHeight();
        shortSide *= 0.5;
        btCar.setIcon(new ImageIcon(new ImageIcon(getClass().getResource("car.png")).getImage().getScaledInstance(shortSide,shortSide,Image.SCALE_SMOOTH)));
        btTruck.setIcon(new ImageIcon(new ImageIcon(getClass().getResource("truck.png")).getImage().getScaledInstance(shortSide,shortSide,Image.SCALE_SMOOTH)));
    }

    private void colorEverything()
    {
        this.setBackground(COLOR_LIGHT);

        btCar.setOpaque(true);
        btCar.setContentAreaFilled(true);
        btCar.setBackground(COLOR_MEDIUM);
        btCar.setForeground(Color.white);


        btTruck.setOpaque(true);
        btTruck.setContentAreaFilled(true);
        btTruck.setBackground(COLOR_MEDIUM);
        btTruck.setForeground(Color.white);
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

    private MyLabel lbAverageConsumption = new MyLabel("Average Consumption");
    private MyLabel lbFuelType = new MyLabel("Fuel Type");
    private MyLabel lbCargo = new MyLabel("Cargo");
    private MyLabel lbAxles = new MyLabel("Axles");
    private MyLabel lbBlue = new MyLabel("Blue");
}
