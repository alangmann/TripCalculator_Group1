package tripcalculator.beans;

import tripcalculator.route.Route;
import tripcalculator.vehicle.Vehicle;

public class Trip {

    private Vehicle vehicle;
    private Route route;

    public Trip(Route route, Vehicle vehicle) {
        this.route = route;
        this.vehicle = vehicle;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public void setVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
    }

    public Route getRoute() {
        return route;
    }

    public void setRoute(Route route) {
        this.route = route;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Trip)) return false;

        Trip trip = (Trip) o;

        if (!route.equals(trip.route)) return false;
        if (!vehicle.equals(trip.vehicle)) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = vehicle.hashCode();
        result = 31 * result + route.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return route + ";" + vehicle;
    }
}
