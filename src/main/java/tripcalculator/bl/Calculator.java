package tripcalculator.bl;

import tripcalculator.beans.WeekdayFormatException;
import tripcalculator.fuel.Fuel;
import tripcalculator.route.Route;
import tripcalculator.route.RouteTypes;
import tripcalculator.vehicle.Car;
import tripcalculator.vehicle.Truck;
import tripcalculator.vehicle.Vehicle;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedList;

public class Calculator extends RouteTypes {

    private static Calculator calculator;
    private Fuel fuel;
    private LinkedList<Route> routes = new LinkedList<>();

    private Calculator() throws IOException, WeekdayFormatException {
        loadData();
    }

    public static Calculator getInstance() throws IOException, WeekdayFormatException {
        if (calculator == null) {
            calculator = new Calculator();
        }
        return calculator;
    }

    public Route getRouteById(int id)
    {
        Route giveBackRoute = null;
        for(Route route : routes)
        {
            if(route.getRouteID() == id)
            {
                giveBackRoute = route;
                break;
            }
        }
        return giveBackRoute;
    }

    private void loadData() throws IOException, WeekdayFormatException {
        fuel = Fuel.getInstance();
        FileReader fr = new FileReader(getClass().getResource("routes.csv").getFile());
        BufferedReader br = new BufferedReader(fr);

        String str;
        int id = 1;
        while((str = br.readLine()) != null)
        {
            str = str.replaceAll(",", ".");
            String[] parts = str.split(";");
            double km = Double.parseDouble(parts[0]);
            double slope = Double.parseDouble(parts[1]);
            String type = parts[2];
            double fee = Double.parseDouble(parts[3]);
            Route route = new Route(id++, km,slope,type,fee);
            if(!routes.contains(route))
            {
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
