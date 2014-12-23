package tripcalculator.gui;

import tripcalculator.fuel.FuelTypes;

import javax.swing.*;
import javax.swing.text.NumberFormatter;
import java.awt.*;
import java.text.NumberFormat;

public class AddTripDialog extends JDialog {

    public AddTripDialog(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        setTitle("Add");
        setSize(400, 300);
        setLocationRelativeTo(parent);
        init();
        //this.rootPane.setDefaultButton(btOk);
    }

    private void init() {
        setLayout(new GridLayout(6, 2));
        setMinimumSize(new Dimension(400, 300));

        btgVehicle.add(btCar);
        btgVehicle.add(btTruck);

        btCar.setSelected(true);

        cbFuelType.addItem("Diesel");
        cbFuelType.addItem("Patrol");

        colorEverything();

        add(btCar);
        add(btTruck);
        add(lbAverageConsumption);
        add(tfAverageConsumption);
        add(lbFuelType);
        add(cbFuelType);
        add(lbCargo);
        add(tfCargo);
        add(lbAxles);
        add(tfAxles);
        add(lbBlue);
        add(cbBlue);
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        int shortSide = btCar.getWidth() < btCar.getHeight() ? btCar.getWidth() : btCar.getHeight();
        shortSide *= 0.5;
        if(shortSide != 0){
            btCar.setIcon(new ImageIcon(new ImageIcon(getClass().getResource("car.png")).getImage().getScaledInstance(shortSide,shortSide,Image.SCALE_SMOOTH)));
            btTruck.setIcon(new ImageIcon(new ImageIcon(getClass().getResource("truck.png")).getImage().getScaledInstance(shortSide,shortSide,Image.SCALE_SMOOTH)));
        }
    }

    private void colorEverything()
    {
        this.setBackground(TripCalculatorGUI.COLOR_LIGHT);

        btCar.setOpaque(true);
        btCar.setContentAreaFilled(true);
        btCar.setBackground(TripCalculatorGUI.COLOR_DARK);
        btCar.setForeground(Color.white);

        btTruck.setOpaque(true);
        btTruck.setContentAreaFilled(true);
        btTruck.setBackground(TripCalculatorGUI.COLOR_DARK);
        btTruck.setForeground(Color.white);

        tfAverageConsumption.setFont(new Font("Arial", Font.PLAIN, 20));
        tfAverageConsumption.setHorizontalAlignment(JTextField.CENTER);

        cbFuelType.setFont(new Font("Arial", Font.PLAIN, 20));
        ((JLabel)cbFuelType.getRenderer()).setHorizontalAlignment(SwingConstants.CENTER);

        tfCargo.setFont(new Font("Arial", Font.PLAIN, 20));
        tfCargo.setHorizontalAlignment(JTextField.CENTER);

        tfAxles.setFont(new Font("Arial", Font.PLAIN, 20));
        tfAxles.setHorizontalAlignment(JTextField.CENTER);

        cbBlue.setHorizontalAlignment(JCheckBox.CENTER);
        cbBlue.setBackground(TripCalculatorGUI.COLOR_LIGHT);

    }

    private Container pane = this.getContentPane();
    private ButtonGroup btgVehicle = new ButtonGroup();
    private JToggleButton btCar = new JToggleButton();
    private JToggleButton btTruck = new JToggleButton();
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
