package tripcalculator.beans;

import tripcalculator.route.Route;
import tripcalculator.vehicle.Vehicle;

import java.util.LinkedList;

public class Trip {

    private Vehicle vehicle;
    private LinkedList<Route> routes = new LinkedList<>();

    public Trip(LinkedList<Route> routes, Vehicle vehicle) {
        this.routes = routes;
        this.vehicle = vehicle;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public LinkedList<Route> getRoute() {
        return routes;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Trip)) return false;

        Trip trip = (Trip) o;

        if (routes != null ? !routes.equals(trip.routes) : trip.routes != null) return false;
        if (vehicle != null ? !vehicle.equals(trip.vehicle) : trip.vehicle != null) return false;

        return true;
    }

    @Override
    public String toString() {
        return routes.get(0) + ";" + vehicle;
    }
}
