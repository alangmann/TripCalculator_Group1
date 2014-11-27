/**
 * Created by christoph on 11/27/2014.
 */
public class Route {

    private int km;
    private int slope;
    private String type;
    private int fee;

    public Route(int km, int slope, String type, int fee) {
        this.km = km;
        this.slope = slope;
        this.type = type;
        this.fee = fee;
    }

    public int getKm() {
        return km;
    }
}
