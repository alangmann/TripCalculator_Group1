package tripcalculator.bl;

import tripcalculator.fuel.Fuel;
import tripcalculator.route.Route;
import tripcalculator.route.RouteTypes;
import tripcalculator.vehicle.Car;
import tripcalculator.vehicle.Truck;
import tripcalculator.vehicle.Vehicle;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.LinkedList;

public class TripCalculator extends RouteTypes {

    private static TripCalculator calculator;
    private Fuel fuel;
    private LinkedList<Route> routes = new LinkedList<>();

    private TripCalculator() throws Exception {
        loadData();
    }

    public static TripCalculator getInstance() throws Exception {
        if (calculator == null) {
            calculator = new TripCalculator();
        }
        return calculator;
    }

    private void loadData() throws Exception {
        fuel = Fuel.getInstance();
        FileReader fr = new FileReader(getClass().getResource("routes.csv").getFile());
        BufferedReader br = new BufferedReader(fr);

        String str;
        while ((str = br.readLine()) != null) {
            str = str.replaceAll(",", ".");
            String[] parts = str.split(";");
            double km = Double.parseDouble(parts[0]);
            double slope = Double.parseDouble(parts[1]);
            String type = parts[2];
            double fee = Double.parseDouble(parts[3]);
            Route route = new Route(km, slope, type, fee);
            if (!routes.contains(route)) {
                routes.add(route);
            }
        }
        br.close();
    }

    public double calculateCo2Consumption(Route route, Vehicle vehicle) {
        double slope = route.getSlope();
        double km = route.getKm();
        RouteType type = route.getType();
        double slopePercent = (slope * 1000) / km;
        if (slopePercent <= -5) {
            return 0;
        }
        if (vehicle != null) {
            double consumption = (vehicle.getCargo() / 100);
            if (vehicle instanceof Car) {
                consumption *= 0.5;
            } else if (vehicle instanceof Truck) {
                consumption *= 0.05;
            }
            consumption += vehicle.getAverageConsumption();
            return km * (0.1325 * consumption / 5) * (slope / (km * 1000) + 1) * factorMap.get(type);
        } else {
            return km * 0.1325 * (slope / (km * 1000) + 1) * factorMap.get(type);
        }
    }

    public LinkedList<Route> getRoutes() {
        return routes;
    }
}
