package tripcalculator.bl;

import tripcalculator.beans.Trip;
import tripcalculator.vehicle.Car;
import tripcalculator.vehicle.Truck;
import tripcalculator.vehicle.Vehicle;

import javax.swing.table.AbstractTableModel;
import java.util.LinkedList;

public class TripModel extends AbstractTableModel{

    private LinkedList<Trip> trips = new LinkedList<>();
    private String[] headings = {"KM", "Slope", "Type", "Fee", "Vehicle", "Fuel type", "Cargo", "Consumption", "Blue", "Axles"};

    @Override
    public int getRowCount() {
        return trips.size();
    }

    @Override
    public int getColumnCount() {
        return headings.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Trip trip = trips.get(rowIndex);
        switch(columnIndex)
        {
            case 0: return trip.getRoute().getKm();
            case 1: return trip.getRoute().getSlope();
            case 2: return trip.getRoute().getType();
            case 3: return trip.getRoute().getFee();
            default:
                Vehicle vehicle = trip.getVehicle();
                switch(columnIndex)
                {
                    case 4: return vehicle.whoAmI();
                    case 5: return vehicle.getTypeOfFuel();
                    case 6: return vehicle.getAverageConsumption();
                    case 7: return vehicle.getCargo();
                    default:
                        if(vehicle instanceof Truck)
                        {
                            Truck truck = (Truck) vehicle;
                            switch (columnIndex)
                            {
                                case 8: return truck.isAdBlue() ? "Yes" : "No";
                                case 9: return truck.getAxles();
                                default: return "error";
                            }
                        }
                        else
                        {
                            switch (columnIndex)
                            {
                                case 8: return " - ";
                                case 9: return " - ";
                                default: return "error";
                            }
                        }
                }
        }
    }

    @Override
    public String getColumnName(int column) {
        return headings[column];
    }
}
