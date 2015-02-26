package tripcalculator.bl;

import org.springframework.stereotype.Component;
import tripcalculator.beans.WeekdayFormatException;
import tripcalculator.fuel.Fuel;
import tripcalculator.route.Route;
import tripcalculator.route.RouteTypes;
import tripcalculator.vehicle.Car;
import tripcalculator.vehicle.Truck;
import tripcalculator.vehicle.Vehicle;

import javax.annotation.Resource;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedList;

@Component("Calculator")
public class Calculator extends RouteTypes {

    @Resource(name = "Fuel")
    private Fuel fuel;

    private LinkedList<Route> routes = new LinkedList<>();

    public Calculator() throws IOException, WeekdayFormatException {
        loadData();
    }

    public Route getRouteById(int id) {
        Route giveBackRoute = null;
        for (Route route : routes) {
            if (route.getRouteID() == id) {
                giveBackRoute = route;
                break;
            }
        }
        return giveBackRoute;
    }

    private void loadData() throws IOException, WeekdayFormatException {
        FileReader fr = new FileReader(getClass().getResource("routes.csv").getFile());
        BufferedReader br = new BufferedReader(fr);

        String str;
        int id = 1;
        while ((str = br.readLine()) != null) {
            str = str.replaceAll(",", ".");
            String[] parts = str.split(";");
            double km = Double.parseDouble(parts[0]);
            double slope = Double.parseDouble(parts[1]);
            String type = parts[2];
            double fee = Double.parseDouble(parts[3]);
            Route route = new Route(id++, km, slope, type, fee);
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
            double consumption = getAvgConsumption(vehicle);
            return km * (0.1325 * consumption / 5) * (slope / (km * 1000) + 1) * factorMap.get(type);
        } else {
            return km * 0.1325 * (slope / (km * 1000) + 1) * factorMap.get(type);
        }
    }

    public LinkedList<Route> getRoutes() {
        return routes;
    }

    private double getAvgConsumption(Vehicle vehicle) {
        double consumption = (vehicle.getCargo() / 100);
        if (vehicle instanceof Car) {
            consumption *= 0.5;
        } else if (vehicle instanceof Truck) {
            consumption *= 0.05;
        }
        consumption += vehicle.getAverageConsumption();
        return consumption;
    }

    public double calculateTotalCostOfRoute(Route route, Vehicle vehicle, String dayOfWeek) throws WeekdayFormatException {
        double slope = route.getSlope();
        double km = route.getKm();
        double slopePercent = (slope * 1000) / km;
        if (slopePercent <= -5) {
            return 0;
        }
        double consumption = getAvgConsumption(vehicle);
        return (km * consumption / 100) * fuel.getPrice(fuel.stringToDay(dayOfWeek), vehicle.getTypeOfFuel()) * (slope / (km * 1000) + 1) + (vehicle instanceof Truck ? ((Truck)vehicle).getAxles() * 1.5 * route.getFee() : route.getFee());
    }
    
    public double calculateAllCost(LinkedList<Route> routes, Vehicle vehicle, String dayOfWeek) throws WeekdayFormatException {
        double sum = 0;
        for ( Route route : routes ) {
            sum += calculateTotalCostOfRoute(route, vehicle, dayOfWeek);
        }
        return sum;
    }

    public double calculateAllCo2(LinkedList<Route> routes, Vehicle vehicle) {
        double sum = 0;
        for ( Route route : routes ) {
            sum += calculateCo2Consumption(route, vehicle);
        }
        return sum;
    }
}
