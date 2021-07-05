package api.medicine.weight;

public class WeightRangeMapper {
    public static String LESS_THAN_FOUR = "3 - 3.9 Kg";
    public static String LESS_THAN_SIX = "4 - 5.9 Kg";
    public static String LESS_THAN_TEN = "6 - 9.9 Kg";
    public static String LESS_THAN_FOURTEEN = "10 - 13.9 Kg";
    public static String LESS_THAN_TWENTY = "14 - 19.9 Kg";
    public static String LESS_THAN_TWENTY_FIVE = "20 - 24.9 Kg";
    public static String LESS_THAN_THIRTY = "25 - 29.9 Kg";
    public static String LESS_THAN_THIRTY_FIVE = "30 - 34.9 Kg";
    public static String LESS_THAN_FORTY = "35 - 39.9 Kg";
    public static String ABOVE_FORTY = "40 Kg +";

    public static String getWeightRange(double weight){
        if(weight >= 3 && weight <= 3.9){
            return LESS_THAN_FOUR;
        }
        if(weight >= 4 && weight <= 5.9){
            return LESS_THAN_SIX;
        }
        if(weight >= 6 && weight <= 9.9){
            return LESS_THAN_TEN;
        }
        if(weight >= 10 && weight <= 13.9){
            return LESS_THAN_FOURTEEN;
        }
        if(weight >= 14 && weight <= 19.9){
            return LESS_THAN_TWENTY;
        }
        if(weight >= 20 && weight <= 24.9){
            return LESS_THAN_TWENTY_FIVE;
        }
        if(weight >= 25 && weight <= 29.9){
            return LESS_THAN_THIRTY;
        }
        if(weight >= 30 && weight <= 34.9){
            return LESS_THAN_THIRTY_FIVE;
        }
        if(weight >= 35 && weight <=39.9){
            return LESS_THAN_FORTY;
        }
        if(weight >= 40){
            return ABOVE_FORTY;
        }
        return null;
    }
}
