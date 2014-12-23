package tripcalculator.gui;

import tripcalculator.beans.Trip;
import tripcalculator.bl.TripModel;
import tripcalculator.route.Route;
import tripcalculator.vehicle.Car;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;

/**
 * Created by Lukas on 22.12.2014.
 */
public class TripCalculatorGUI extends JFrame {

    public final static Color COLOR_DARK = new Color(47, 117, 181);
    public final static Color COLOR_MEDIUM = new Color(155, 194, 230);
    public final static Color COLOR_LIGHT = new Color(189, 214, 238);

    public TripCalculatorGUI(){
        init();

        TripModel tm = new TripModel();
        tm.addTrip(new Trip(new Route(5,5,"highway",0), new Car(327, "Diesel", 5)));
        tm.addTrip(new Trip(new Route(17,3,"GRAVELROAD",0), new Car(17, "PATROL", 3)));
        try {
            tm.saveData();
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }

    private void init() {
        this.setSize(500, 500);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(new BorderLayout());

        meAdd.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                onAdd();
            }
        });



        menuBar.add(meFile);
        menuBar.add(meAdd);
        meFile.add(miOpen);
        meFile.add(miSave);

        this.setJMenuBar(menuBar);
    }

    private void onAdd() {
        AddTripDialog dialog = new AddTripDialog(this, true);
        dialog.setVisible(true);
    }

    public static void main(String[] args) {
        try {
            //UIManager.setLookAndFeel(new WindowsLookAndFeel());
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Failed to load Windows Look and Feel...", "LaF Error", JOptionPane.ERROR_MESSAGE);
        }
        new TripCalculatorGUI().setVisible(true);
    }

    private JMenuBar menuBar = new JMenuBar();
    private JMenu meAdd = new JMenu("Add");;
    private JMenu meFile = new JMenu("File");
    private JMenuItem miOpen = new JMenuItem("Open");
    private JMenuItem miSave = new JMenuItem("Save");
    private JTable tbTrip = new JTable();
}
