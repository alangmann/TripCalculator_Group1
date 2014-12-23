package tripcalculator.bl;

import tripcalculator.beans.Trip;
import tripcalculator.beans.WeekdayFormatException;
import tripcalculator.route.Route;
import tripcalculator.vehicle.Car;
import tripcalculator.vehicle.Truck;
import tripcalculator.vehicle.Vehicle;

import javax.swing.table.AbstractTableModel;
import java.io.*;
import java.util.LinkedList;

public class TripModel extends AbstractTableModel {

    private final String filePath = System.getProperty("user.dir") + File.separator + "src" + File.separator + "main" + File.separator + "resources" + File.separator + "tripcalculator" + File.separator + "bl" + File.separator +  "trips.csv";
    private LinkedList<Trip> trips = new LinkedList<>();
    private String[] headings = {"KM", "Slope", "Type", "Fee", "Vehicle", "Fuel type", "Cargo", "Consumption", "Blue", "Axles"};

    public void addTrip(Trip trip) {
        if (!trips.contains(trip)) {
            trips.add(trip);
            this.fireTableRowsInserted(0, trips.size() - 1);
        }
    }

    public LinkedList<Trip> getTrips() {
        return trips;
    }

    public String[] getHeadings() {
        return headings;
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
        switch (columnIndex) {
            case 0:
                return trip.getRoute().getKm();
            case 1:
                return trip.getRoute().getSlope();
            case 2:
                return trip.getRoute().getType();
            case 3:
                return trip.getRoute().getFee();
            default:
                Vehicle vehicle = trip.getVehicle();
                switch (columnIndex) {
                    case 4:
                        return vehicle.whoAmI();
                    case 5:
                        return vehicle.getTypeOfFuel();
                    case 6:
                        return vehicle.getAverageConsumption();
                    case 7:
                        return vehicle.getCargo();
                    default:
                        if (vehicle instanceof Truck) {
                            Truck truck = (Truck) vehicle;
                            switch (columnIndex) {
                                case 8:
                                    return truck.isAdBlue() ? "Yes" : "No";
                                case 9:
                                    return truck.getAxles();
                                default:
                                    return "error";
                            }
                        } else {
                            switch (columnIndex) {
                                case 8:
                                    return " - ";
                                case 9:
                                    return " - ";
                                default:
                                    return "error";
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
        FileWriter fw = new FileWriter(filePath);
        BufferedWriter bw = new BufferedWriter(fw);
        for (Trip trip : trips) {
            bw.write(trip.toString());
            bw.newLine();
        }
        bw.flush();
        bw.close();
    }

    public void saveData(File file) throws IOException {
        FileWriter fw = new FileWriter(file);
        BufferedWriter bw = new BufferedWriter(fw);
        for (Trip trip : trips) {
            bw.write(trip.toString());
            bw.newLine();
        }
        bw.flush();
        bw.close();
    }


    public void loadData() throws IOException, WeekdayFormatException {
        trips.clear();
        FileReader fr = new FileReader(filePath);
        BufferedReader br = new BufferedReader(fr);
        String line;
        while ((line = br.readLine()) != null) {
            String[] parts = line.split(";");
            int routeID = Integer.parseInt(parts[0]);
            Route route = Calculator.getInstance().getRouteById(routeID);
            if(route != null)
            {
                Vehicle vehicle;
                Double averageConsumption = Double.parseDouble(parts[1]);
                String typeOfFuel = parts[2];
                int cargo = Integer.parseInt(parts[3]);

                if(parts.length > 4)
                {
                    boolean adBlue = parts[4].equalsIgnoreCase("true");
                    int axles = Integer.parseInt(parts[5]);

                    vehicle = new Truck(cargo, typeOfFuel, averageConsumption, adBlue, axles);
                }
                else
                {
                    vehicle = new Car(cargo, typeOfFuel, averageConsumption);
                }

                Trip trip = new Trip(route, vehicle);

                this.addTrip(trip);
            }
        }
        br.close();
    }

    public void loadData(File file) throws IOException, WeekdayFormatException, NumberFormatException {
        trips.clear();
        FileReader fr = new FileReader(file);
        BufferedReader br = new BufferedReader(fr);
        String line;
        while ((line = br.readLine()) != null) {
            String[] parts = line.split(";");
            int routeID = Integer.parseInt(parts[0]);
            Route route = Calculator.getInstance().getRouteById(routeID);
            if(route != null)
            {
                Vehicle vehicle;
                Double averageConsumption = Double.parseDouble(parts[1]);
                String typeOfFuel = parts[2];
                int cargo = Integer.parseInt(parts[3]);

                if(parts.length > 4)
                {
                    boolean adBlue = parts[4].equalsIgnoreCase("true");
                    int axles = Integer.parseInt(parts[5]);

                    vehicle = new Truck(cargo, typeOfFuel, averageConsumption, adBlue, axles);
                }
                else
                {
                    vehicle = new Car(cargo, typeOfFuel, averageConsumption);
                }

                Trip trip = new Trip(route, vehicle);

                this.addTrip(trip);
            }
        }
        br.close();
    }



}
