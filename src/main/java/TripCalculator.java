import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedList;

public class TripCalculator {

    private static final String fileName = System.getProperty("user.dir") + File.separator + "src" + File.separator + "main" + File.separator + "resources" + File.separator + "routes.csv";

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
        fuel = Fuel.getInstace();

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

    public LinkedList<Route> getRoutes() {
        return routes;
    }
}
