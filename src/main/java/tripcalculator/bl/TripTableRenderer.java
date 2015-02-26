package tripcalculator.bl;

import org.springframework.stereotype.Service;
import tripcalculator.gui.TripCalculatorGUI;

import javax.swing.*;
import javax.swing.border.LineBorder;
import javax.swing.table.TableCellRenderer;
import java.awt.*;

@Service("TripTableRenderer")
public class TripTableRenderer implements TableCellRenderer {

    @Override
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
        JLabel label = new JLabel();
        label.setOpaque(true);
        label.setFont(new Font("Arial", Font.PLAIN, 15));
        label.setHorizontalAlignment(JLabel.CENTER);
        label.setText(value.toString());
        label.setForeground(Color.black);
        if (isSelected) {
            label.setBackground(TripCalculatorGUI.COLOR_MEDIUM);
            if (hasFocus) {
                label.setForeground(Color.white);
                label.setBackground(TripCalculatorGUI.COLOR_DARK);
            }
        }
        else
        {
            label.setBackground(TripCalculatorGUI.COLOR_LIGHT);
        }
        return label;
    }
}
