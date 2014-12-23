package tripcalculator.gui;

import tripcalculator.beans.Trip;
import tripcalculator.bl.TripCalculator;
import tripcalculator.bl.TripModel;
import tripcalculator.bl.TripTableRenderer;
import tripcalculator.route.Route;
import tripcalculator.vehicle.Car;
import tripcalculator.vehicle.Truck;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.IOException;

public class TripCalculatorGUI extends JFrame {

    public final static Color COLOR_DARK = new Color(47, 117, 181);
    public final static Color COLOR_MEDIUM = new Color(155, 194, 230);
    public final static Color COLOR_LIGHT = new Color(189, 214, 238);

    private TripModel tm = new TripModel();

    public TripCalculatorGUI(){
        try {
            tm.loadDate();
            tbTrip.updateUI();
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        } catch (Exception e) {
            e.printStackTrace();
        }
        init();
    }

    private void init() {
        this.setSize(500, 500);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(new BorderLayout());
        this.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                try {
                    tm.saveData();
                } catch (IOException e1) {
                }
                finally {
                    dispose();
                }
            }
        });

        meAdd.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                onAdd();
            }
        });

        tbTrip.setModel(tm);
        tbTrip.setDefaultRenderer(Object.class, new TripTableRenderer());

        menuBar.setBackground(COLOR_DARK);

        meFile.setBackground(COLOR_DARK);
        meFile.setForeground(Color.white);
        meFile.setFont(new Font("Agency FB", Font.PLAIN, 25));

        meAdd.setBackground(COLOR_DARK);
        meAdd.setForeground(Color.white);
        meAdd.setFont(new Font("Agency FB", Font.PLAIN, 25));

        miOpen.setBackground(COLOR_MEDIUM);
        miOpen.setForeground(Color.black);
        miOpen.setFont(new Font("Agency FB", Font.PLAIN, 20));

        miSave.setBackground(COLOR_MEDIUM);
        miSave.setForeground(Color.black);
        miSave.setFont(new Font("Agency FB", Font.PLAIN, 20));

        menuBar.add(meFile);
        menuBar.add(meAdd);
        meFile.add(miOpen);
        meFile.add(miSave);

        this.setJMenuBar(menuBar);
        this.getContentPane().add(new JScrollPane(tbTrip));
    }

    private void onAdd() {
        AddTripDialog dialog = new AddTripDialog(this, true);
        dialog.setVisible(true);
        if(dialog.isOk())
        {
            tm.addTrip(dialog.getNewTrip());
        }
    }

    public static void main(String[] args) {
        new TripCalculatorGUI().setVisible(true);
    }

    private JMenuBar menuBar = new JMenuBar();
    private JMenu meAdd = new JMenu("Add");;
    private JMenu meFile = new JMenu("File");
    private JMenuItem miOpen = new JMenuItem("Open");
    private JMenuItem miSave = new JMenuItem("Save");
    private JTable tbTrip = new JTable();
}
