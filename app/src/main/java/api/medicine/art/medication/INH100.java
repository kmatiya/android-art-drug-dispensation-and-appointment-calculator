package api.medicine.art.medication;

import api.medicine.MedicineService;
import api.medicine.weight.WeightRangeMapper;
import api.util.DosageAndWeightMapper;
import metadata.MedicineNameMetaData;
import metadata.NumberOfMedicineStandardMetaData;
import model.DosageAndWeight;
import model.DosageRecipientType;
import model.medicineType.MedicineType;

import java.util.HashMap;

public class INH100 implements MedicineService {

    private final HashMap<String, DosageAndWeight> medicineDosage;

    public INH100()
    {
        medicineDosage = new HashMap<>();

        medicineDosage.put(WeightRangeMapper.LESS_THAN_FOUR, DosageAndWeightMapper.setDosageAndWeightOfMedicine(3,3.9,0,0.5, MedicineType.TABLET, DosageRecipientType.PAEDIATRIC));
        medicineDosage.put(WeightRangeMapper.LESS_THAN_SIX, DosageAndWeightMapper.setDosageAndWeightOfMedicine(4,5.9,0,0.5,MedicineType.TABLET,DosageRecipientType.PAEDIATRIC));
        medicineDosage.put(WeightRangeMapper.LESS_THAN_TEN, DosageAndWeightMapper.setDosageAndWeightOfMedicine(6,9.9,0,1,MedicineType.TABLET,DosageRecipientType.PAEDIATRIC));
        medicineDosage.put(WeightRangeMapper.LESS_THAN_FOURTEEN, DosageAndWeightMapper.setDosageAndWeightOfMedicine(10,13.9,0,1.5,MedicineType.TABLET,DosageRecipientType.PAEDIATRIC));
        medicineDosage.put(WeightRangeMapper.LESS_THAN_TWENTY, DosageAndWeightMapper.setDosageAndWeightOfMedicine(14,19.9,0,2,MedicineType.TABLET,DosageRecipientType.PAEDIATRIC));
        medicineDosage.put(WeightRangeMapper.LESS_THAN_TWENTY_FIVE, DosageAndWeightMapper.setDosageAndWeightOfMedicine(20,24.9,0,2.5,MedicineType.TABLET,DosageRecipientType.PAEDIATRIC));
    }

    @Override
    public HashMap<String,DosageAndWeight> getDosageAndWeightRange() {
        return medicineDosage;
    }

    @Override
    public String getName() {
        return MedicineNameMetaData.INH_100;
    }

    @Override
    public Integer getStandardDisperseNumberForAdults() {
        return null;
    }

    @Override
    public Integer getStandardDisperseNumberForPaediatrics() {
        return NumberOfMedicineStandardMetaData.ONE_HUNDRED;
    }

    @Override
    public boolean checkWeightRangeExistForMedicine(String weightRange) {
        return medicineDosage.get(weightRange) != null;
    }
}
