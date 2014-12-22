package tripcalculator.gui;

import com.jgoodies.looks.windows.WindowsLookAndFeel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/**
 * Created by Lukas on 22.12.2014.
 */
public class TripCalculatorGUI extends JFrame {

    public final static Color COLOR_DARK = new Color(47, 117, 181);
    public final static Color COLOR_MEDIUM = new Color(155, 194, 230);
    public final static Color COLOR_LIGHT = new Color(189, 214, 238);

    public TripCalculatorGUI(){
        init();
    }

    private void init() {
        this.setSize(500,500);
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

        new AddTripDialog(this, true);
    }

    public static void main(String[] args) {
        try {
            UIManager.setLookAndFeel(new WindowsLookAndFeel());
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
