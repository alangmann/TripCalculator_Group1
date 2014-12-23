package tripcalculator.gui;

import tripcalculator.beans.Trip;
import tripcalculator.bl.Calculator;
import tripcalculator.route.Route;
import tripcalculator.vehicle.Car;
import tripcalculator.vehicle.Truck;
import tripcalculator.vehicle.Vehicle;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.LinkedList;

public class AddTripDialog extends JDialog {

    private boolean isOk;
    private Trip newTrip = null;


    public AddTripDialog(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        setTitle("Add");
        setSize(400, 300);
        setLocationRelativeTo(parent);
        try {
            init();
        } catch (Exception e) {
            e.printStackTrace();
        }
        //this.rootPane.setDefaultButton(btOk);
    }

    private void init() throws Exception {
        setLayout(new GridLayout(9, 2));
        setMinimumSize(new Dimension(700, 300));


        btgVehicle.add(btCar);
        btgVehicle.add(btTruck);

        btCar.setSelected(true);

        onClickBT(null);

        cbFuelType.addItem("Diesel");
        cbFuelType.addItem("Patrol");

        colorEverything();

        onClickRB(null);

        JPanel panel = new JPanel(new GridLayout(1, 3));
        ButtonGroup bg = new ButtonGroup();
        bg.add(rbCR);
        bg.add(rbHW);
        bg.add(rbGR);
        panel.add(rbCR);
        panel.add(rbHW);
        panel.add(rbGR);

        btCancel.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });
        btAdd.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                onAdd(e);
            }
        });

        btCar.addActionListener(new VehicleAction());
        btTruck.addActionListener(new VehicleAction());

        rbCR.addActionListener(new RbAction());
        rbHW.addActionListener(new RbAction());
        rbGR.addActionListener(new RbAction());

        rbHW.setSelected(true);

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
        add(lbRouteType);
        add(panel);
        add(lbRoute);
        add(cbRoute);
        add(btCancel);
        add(btAdd);
    }


    private void onAdd(ActionEvent e) {
        try{
            Double averageConsumption = Double.parseDouble(tfAverageConsumption.getText().replace(",", "."));
            String fuelType = (String) cbFuelType.getSelectedItem();
            int cargo = (int) Double.parseDouble(tfCargo.getText().replace(",", "."));
            Route route = null;
            for(Route r : Calculator.getInstance().getRoutes())
            {
                if(r.getCbString().equals((String)cbRoute.getSelectedItem()));
                {
                    route = r;
                }
            }
            Vehicle vehicle = null;
            if(btCar.isSelected())
            {
                vehicle = new Car(cargo, fuelType, averageConsumption);
            }
            else
            {
                int axles = (int)Integer.parseInt(tfAxles.getText().replace(",", "."));
                boolean adBlue = cbBlue.isSelected();
                vehicle = new Truck(cargo, fuelType, averageConsumption, adBlue, axles);
            }
            newTrip = new Trip(route, vehicle);
            isOk = true;
            dispose();
        }catch(NumberFormatException ex)
        {
            JOptionPane.showMessageDialog(this, "Average Consumption, Cargo and Axles have to be a NUMBER!", "No Number", JOptionPane.ERROR_MESSAGE);
        }
        catch(Exception ex)
        {

        }
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

        tfAverageConsumption.setFont(new Font("Bradley Hand ITC", Font.PLAIN, 20));
        tfAverageConsumption.setHorizontalAlignment(JTextField.CENTER);

        cbFuelType.setFont(new Font("Bradley Hand ITC", Font.PLAIN, 20));
        ((JLabel)cbFuelType.getRenderer()).setHorizontalAlignment(SwingConstants.CENTER);

        tfCargo.setFont(new Font("Bradley Hand ITC", Font.PLAIN, 20));
        tfCargo.setHorizontalAlignment(JTextField.CENTER);

        tfAxles.setFont(new Font("Bradley Hand ITC", Font.PLAIN, 20));
        tfAxles.setHorizontalAlignment(JTextField.CENTER);

        cbBlue.setHorizontalAlignment(JCheckBox.CENTER);
        cbBlue.setBackground(TripCalculatorGUI.COLOR_LIGHT);

        cbRoute.setFont(new Font("Bradley Hand ITC", Font.PLAIN, 20));
        ((JLabel)cbRoute.getRenderer()).setHorizontalAlignment(SwingConstants.CENTER);

        rbCR.setBackground(TripCalculatorGUI.COLOR_MEDIUM);
        rbCR.setHorizontalAlignment(SwingConstants.CENTER);
        rbCR.setFont(new Font("Bradley Hand ITC", Font.PLAIN, 20));

        rbHW.setBackground(TripCalculatorGUI.COLOR_MEDIUM);
        rbHW.setHorizontalAlignment(SwingConstants.CENTER);
        rbHW.setFont(new Font("Bradley Hand ITC", Font.PLAIN, 20));

        rbGR.setBackground(TripCalculatorGUI.COLOR_MEDIUM);
        rbGR.setHorizontalAlignment(SwingConstants.CENTER);
        rbGR.setFont(new Font("Bradley Hand ITC", Font.PLAIN, 20));
    }

    class RbAction implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                onClickRB(e);
            } catch (Exception e1) {
                e1.printStackTrace();
            }
        }
    }

    public Trip getNewTrip() {
        return newTrip;
    }

    public boolean isOk() {

        return isOk;
    }

    class VehicleAction implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            onClickBT(e);
        }
    }

    private void onClickBT(ActionEvent e) {
        if(btCar.isSelected())
        {
            cbBlue.setSelected(false);
            cbBlue.setEnabled(false);
            tfAxles.setText("");
            tfAxles.setEnabled(false);
        }
        else
        {
            cbBlue.setEnabled(true);
            tfAxles.setEnabled(true);
        }
    }

    private void onClickRB(ActionEvent e) throws Exception {
        cbRoute.removeAllItems();
        LinkedList<Route> routes = Calculator.getInstance().getRoutes();
        if(e == null)
        {
            for(Route route : routes)
            {
                if((route.getType() + "").equalsIgnoreCase("highway")) {
                    cbRoute.addItem(route.getCbString());
                }
            }
        }
        else
        {
            JRadioButton rb = (JRadioButton) e.getSource();
            String text = rb.getText();
            if(!text.equalsIgnoreCase("highway"))
            {
                text += "road";
            }
            for(Route route : routes)
            {
                if((route.getType() + "").equalsIgnoreCase(text)) {
                    cbRoute.addItem(route.getCbString());
                }
            }
        }
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
    private JRadioButton rbCR = new JRadioButton("Country");
    private JRadioButton rbHW = new JRadioButton("Highway");
    private JRadioButton rbGR= new JRadioButton("Gravel");
    private JComboBox<String> cbRoute = new JComboBox<>();
    private MyButton btCancel = new MyButton("Cancel");
    private MyButton btAdd = new MyButton("Add");

    private MyLabel lbAverageConsumption = new MyLabel("Average Consumption");
    private MyLabel lbFuelType = new MyLabel("Fuel Type");
    private MyLabel lbCargo = new MyLabel("Cargo");
    private MyLabel lbAxles = new MyLabel("Axles");
    private MyLabel lbBlue = new MyLabel("Blue");
    private MyLabel lbRouteType = new MyLabel("Route Type");
    private MyLabel lbRoute = new MyLabel("Route");
}
