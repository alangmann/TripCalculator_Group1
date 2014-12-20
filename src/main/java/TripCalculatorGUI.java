import javax.swing.*;
import java.awt.*;

/**
 * Created by Lukas on 20.12.2014.
 */
public class TripCalculatorGUI extends JFrame {

    public TripCalculatorGUI()
    {
        super("TripCalculator");

        init();
    }

    private void init() {
        this.setLayout(new GridLayout(5,1));
        this.setSize(500,500);

        JPanel pnRB = new JPanel(new GridLayout(1,2));
        pnRB.add(btCar);
        pnRB.add(btTruck);

        this.getContentPane().add(pnRB);
        this.setVisible(true);
    }

    public static void main(String[] args) {
        new TripCalculatorGUI();
    }

    public JRadioButton btCar = new JRadioButton("Car");
    public JRadioButton btTruck = new JRadioButton("Truck");
}
