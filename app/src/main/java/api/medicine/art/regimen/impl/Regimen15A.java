package api.medicine.art.regimen.impl;

import api.medicine.MedicineService;
import api.medicine.art.medication.ABC3TC;
import api.medicine.art.medication.AZT3TC;
import api.medicine.art.medication.DTG;
import api.medicine.art.regimen.RegimenService;
import metadata.RegimenNameMetaData;

import java.util.ArrayList;

public class Regimen15A implements RegimenService {

    private final ArrayList<MedicineService> medicineServices = new ArrayList<>();

    public Regimen15A(){

        ABC3TC abc3TC = new ABC3TC();
        medicineServices.add(abc3TC);
        DTG dtg = new DTG();
        medicineServices.add(dtg);
    }
    @Override
    public String getName() {
        return RegimenNameMetaData.REGIMEN_15A;
    }

    @Override
    public ArrayList<MedicineService> getRegimenDrugCombination() {
        return medicineServices;
    }

    @Override
    public MedicineService getMedicineByMedicineName(String medicineName) {
        for (MedicineService medicineService: medicineServices) {
            if(medicineName.equals(medicineService.getName())){
                return medicineService;
            }
        }
        return null;
    }
}
