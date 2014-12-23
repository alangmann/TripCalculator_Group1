package tripcalculator.gui;

import tripcalculator.beans.WeekdayFormatException;
import tripcalculator.bl.TripModel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;

public class TripCalculatorGUI extends JFrame {

    public final static Color COLOR_DARK = new Color(47, 117, 181);
    public final static Color COLOR_MEDIUM = new Color(155, 194, 230);
    public final static Color COLOR_LIGHT = new Color(189, 214, 238);

    private TripModel tm = new TripModel();

    public TripCalculatorGUI(){
        try {
            tm.loadData();
            tbTrip.updateUI();
        } catch (IOException | WeekdayFormatException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
        init();
    }

    private void init() {
        this.setSize(500, 500);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.setLayout(new BorderLayout());

        meAdd.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                onAdd();
            }
        });

        tbTrip.setModel(tm);

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
    }

    public static void main(String[] args) {
        new TripCalculatorGUI().setVisible(true);
    }

    private JMenuBar menuBar = new JMenuBar();
    private JMenu meAdd = new JMenu("Add");
    private JMenu meFile = new JMenu("File");
    private JMenuItem miOpen = new JMenuItem("Open");
    private JMenuItem miSave = new JMenuItem("Save");
    private JTable tbTrip = new JTable();
}
