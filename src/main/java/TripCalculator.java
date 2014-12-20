import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedList;

public class TripCalculator extends RouteTypes{

    private static final String fileName = System.getProperty("user.dir").replace("\\src\\test", "") + File.separator + "src" + File.separator + "main" + File.separator + "resources" + File.separator + "routes.csv";

    private static TripCalculator calculator = new TripCalculator();
    private Fuel fuel;
    private LinkedList<Route> routes = new LinkedList<>();

    private TripCalculator() {
        try {
            loadData();
        } catch (IOException e) {
            System.out.println("Failed in TripCalculator - " + e.getMessage());
        }
    }

    public static TripCalculator getInstance() {
        return calculator;
    }

    private void loadData() throws IOException {
        fuel = Fuel.getInstance();

        FileReader fr = new FileReader(fileName);
        BufferedReader br = new BufferedReader(fr);

        String str;
        while((str = br.readLine()) != null)
        {
            str = str.replaceAll(",", ".");
            String[] parts = str.split(";");
            double km = Double.parseDouble(parts[0]);
            double slope = Double.parseDouble(parts[1]);
            String type = parts[2];
            double fee = Double.parseDouble(parts[3]);
            Route route = new Route(km,slope,type,fee);
            if(!routes.contains(route))
            {
                routes.add(route);
            }
        }
        br.close();
    }

    public double calculateCo2Consumption(Route route, Vehicle vehicle)
    {
        double slope = route.getSlope();
        double km = route.getKm();
        RouteType type = route.getType();
        double slopePercent = (slope * 1000) / km;
        if(slopePercent <= -5)
        {
            return 0;
        }

        double consumption =(vehicle.getCargo() / 100);
        if(vehicle instanceof Car)
        {
            consumption *= 0.5;
        }
        else if(vehicle instanceof Truck)
        {
                consumption *= 0.05;
        }
        consumption += vehicle.getAverageConsumption();
        return km * (0.1325 * consumption / 5) * (slope / (km * 1000) + 1) * factorMap.get(type);
    }

    public double calculateCo2Consumption(Route route)
    {
        double slope = route.getSlope();
        double km = route.getKm();
        RouteType type = route.getType();
        double slopePercent = (slope * 1000) / km;
        if(slopePercent <= -5)
        {
            return 0;
        }
        return km * 0.1325 * (slope / (km * 1000) + 1) * factorMap.get(type);
    }

    public LinkedList<Route> getRoutes() {
        return routes;
    }
}
