package tripcalculator.bl;

import tripcalculator.beans.Trip;
import tripcalculator.route.Route;
import tripcalculator.vehicle.Car;
import tripcalculator.vehicle.Truck;
import tripcalculator.vehicle.Vehicle;

import javax.swing.*;
import javax.swing.table.AbstractTableModel;
import java.io.*;
import java.util.LinkedList;

public class TripModel extends AbstractTableModel{

    private LinkedList<Trip> trips = new LinkedList<>();
    private String[] headings = {"KM", "Slope", "Type", "Fee", "Vehicle", "Fuel type", "Cargo", "Consumption", "Blue", "Axles"};

    public void addTrip(Trip trip)
    {
        if(!trips.contains(trip))
        {
            trips.add(trip);
        }
    }

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

    public void saveData() throws IOException {
        FileWriter fw = new FileWriter(getClass().getResource("trips.csv").getFile());
        BufferedWriter bw = new BufferedWriter(fw);
        for(Trip trip : trips)
        {
            bw.write(trip.toString());
        }
        bw.flush();
        bw.close();
    }

    public void loadDate() throws IOException {
        FileReader fr = new FileReader(getClass().getResource("trips.csv").getFile());
        BufferedReader br = new BufferedReader(fr);
        String line = "";
        while((line = br.readLine()) != null)
        {
            String[] parts = line.split(";");

        }
        br.close();
    }

    public static void main(String[] args) {
        TripModel tm = new TripModel();
        tm.addTrip(new Trip(new Route(5,5,"highway",0), new Car(327, "Diesel", 5)));
        tm.addTrip(new Trip(new Route(17,3,"GRAVELROAD",0), new Car(17, "PATROL", 3)));
        try {
            tm.saveData();
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }
}
