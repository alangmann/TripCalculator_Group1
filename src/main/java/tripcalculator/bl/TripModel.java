package tripcalculator.bl;

import tripcalculator.beans.Trip;

import javax.swing.table.AbstractTableModel;
import java.util.LinkedList;

public class TripModel extends AbstractTableModel{

    private LinkedList<Trip> trips = new LinkedList<>();

    @Override
    public int getRowCount() {
        return 0;
    }

    @Override
    public int getColumnCount() {
        return 0;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        return null;
    }
}
