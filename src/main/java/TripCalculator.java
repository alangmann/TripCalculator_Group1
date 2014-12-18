import java.io.*;
import java.util.LinkedList;

public class TripCalculator {

    private static TripCalculator calculator = new TripCalculator();
    private Sprit sprit;
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
        sprit = Sprit.getInstace();

        FileReader fr = new FileReader(System.getProperty("user.dir") + File.separator + "src" + File.separator + "main" + File.separator + "resources" + File.separator + "routes.csv");
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
