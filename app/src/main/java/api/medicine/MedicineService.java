package api.medicine;

import model.DosageAndWeight;

import java.util.HashMap;

public interface MedicineService {
    HashMap<String,DosageAndWeight> getDosageAndWeightRange();
    String getName();
    Integer getStandardDisperseNumberForAdults();
    Integer getStandardDisperseNumberForPaediatrics();
    boolean checkWeightRangeExistForMedicine(String weightRange);

}
