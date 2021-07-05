package api.medicine.art.regimen.validator;

import api.medicine.MedicineService;
import api.medicine.art.regimen.RegimenService;

import java.util.ArrayList;

public interface RegimenValidator {
    boolean isRegimenNameValid(String regimen);
    String isWeightValid(double weight, ArrayList<MedicineService> drugCombination);
}
