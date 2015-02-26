package tripcalculator.gui;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.*;
import org.springframework.stereotype.Component;
import tripcalculator.beans.WeekdayFormatException;
import tripcalculator.bl.TripModel;
import tripcalculator.bl.TripTableRenderer;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.IOException;

@Component("TripCalculatorGUI")
public class TripCalculatorGUI extends JFrame {

    public final static Color COLOR_DARK = new Color(47, 117, 181);
    public final static Color COLOR_MEDIUM = new Color(155, 194, 230);
    public final static Color COLOR_LIGHT = new Color(189, 214, 238);

    @Resource(name = "TripModel")
    private TripModel tm;

    @PostConstruct
    public void setup(){
        try {
            tm.loadData(null);
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
        this.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                try {
                    tm.saveData();
                } catch (IOException e1) {
                    JOptionPane.showMessageDialog(null, "Saving failed...");
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
        meFile.setFont(new Font("Helvetica", Font.PLAIN, 25));

        meAdd.setBackground(COLOR_DARK);
        meAdd.setForeground(Color.white);
        meAdd.setFont(new Font("Helvetica", Font.PLAIN, 25));

        miOpen.setBackground(COLOR_MEDIUM);
        miOpen.setForeground(Color.black);
        miOpen.setFont(new Font("Helvetica", Font.PLAIN, 20));

        miSave.setBackground(COLOR_MEDIUM);
        miSave.setForeground(Color.black);
        miSave.setFont(new Font("Helvetica", Font.PLAIN, 20));

        menuBar.add(meFile);
        menuBar.add(meAdd);
        meFile.add(miOpen);
        meFile.add(miSave);

        miOpen.addActionListener(e -> {
            JFileChooser chooser = new JFileChooser();
            chooser.showOpenDialog(null);
            try {
                tm.loadData(chooser.getSelectedFile());
            } catch (IOException e1) {
                JOptionPane.showMessageDialog(null, "Failed to load file.");
            } catch (WeekdayFormatException e1) {
                JOptionPane.showMessageDialog(null, "Wrong weekday format.");
            }
        });

        miSave.addActionListener(e -> {
            JFileChooser chooser = new JFileChooser();
            chooser.showSaveDialog(null);
            try {
                tm.saveData(chooser.getSelectedFile());
            } catch (IOException e1) {
                JOptionPane.showMessageDialog(null, "Failed to save file.");
            }
        });

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
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("spring/spring-di-sample-annotation-context.xml");
        context.getBean("TripCalculatorGUI", JFrame.class).setVisible(true);
    }

    private JMenuBar menuBar = new JMenuBar();
    private JMenu meAdd = new JMenu("Add");
    private JMenu meFile = new JMenu("File");
    private JMenuItem miOpen = new JMenuItem("Open");
    private JMenuItem miSave = new JMenuItem("Save");
    private JTable tbTrip = new JTable();
}
