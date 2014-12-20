package tripcalculator.fuel;

public class FuelTypes {

    protected enum FuelType {
        DIESEL, PATROL, UNDEFINED
    }

    protected FuelType getFuelTypeFormString(String type)
    {
        if(type.equalsIgnoreCase("diesel"))
        {
            return FuelType.DIESEL;
        }
        if(type.equalsIgnoreCase("patrol"))
        {
            return FuelType.PATROL;
        }
        return FuelType.UNDEFINED;
    }
}
