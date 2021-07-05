package api.medicine.art.regimen;


import api.medicine.MedicineService;

import java.util.ArrayList;

public interface RegimenService {
    String getName();
    ArrayList<MedicineService> getRegimenDrugCombination();
    MedicineService getMedicineByMedicineName(String medicineName);
}
