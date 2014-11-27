/**
 * Created by Lukas on 27.11.2014.
 */
public class Sprit {

    private static Sprit INSTANCE;

    private Sprit() {
    }

    public static Sprit getInstace()
    {
        if(INSTANCE == null){
            INSTANCE = new Sprit();
        }
        return INSTANCE;
    }
}
