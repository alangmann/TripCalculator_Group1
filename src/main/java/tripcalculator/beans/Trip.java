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

    public double getAllKM()
    {
        double km = 0;
        for(Route route : routes)
        {
            km += route.getKm();
        }
        return km;
    }

    public double getAllSlope()
    {
        double slope = 0;
        for(Route route : routes)
        {
            slope += route.getSlope();
        }
        return slope;
    }

    public String getTypeString()
    {
        String type = "";
        for(Route route : routes)
        {
            if(!type.contains((route.getType() + "").toLowerCase().substring(0,1)))
            {
                if(type.length() == 0)
                    type += (route.getType() + "").toLowerCase().substring(0,1);
                else
                    type += ", " + (route.getType() + "").toLowerCase().substring(0,1);
            }
        }
        return type;
    }

    public double getAllFee()
    {
        double fee = 0;
        for(Route route : routes)
        {
            fee += route.getFee();
        }
        return fee;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public LinkedList<Route> getRoutes() {
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
        String routeIDs = "";
        for(Route route : routes)
        {
            if(routeIDs.length() == 0)
                routeIDs += route.getRouteID();
            else
                routeIDs +=  "#" + route.getRouteID();
        }
        return routeIDs + ";" + vehicle;
    }
}
