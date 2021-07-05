package api.medicine.art.regimen.impl;

import api.medicine.MedicineService;
import api.medicine.art.medication.ABC3TC;
import api.medicine.art.medication.LPVr;
import api.medicine.art.medication.TDF3TC;
import api.medicine.art.regimen.RegimenService;
import metadata.RegimenNameMetaData;

import java.util.ArrayList;

public class Regimen10A implements RegimenService {

    private final ArrayList<MedicineService> medicineServices = new ArrayList<>();

    public Regimen10A(){

        TDF3TC tdf3TC = new TDF3TC();
        medicineServices.add(tdf3TC);
        LPVr lpVr = new LPVr();
        medicineServices.add(lpVr);
    }
    @Override
    public String getName() {
        return RegimenNameMetaData.REGIMEN_10A;
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
