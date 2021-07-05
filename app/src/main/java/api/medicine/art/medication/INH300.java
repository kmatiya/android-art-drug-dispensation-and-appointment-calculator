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

public class INH300 implements MedicineService {

    private final HashMap<String, DosageAndWeight> medicineDosage;

    public INH300()
    {
        medicineDosage = new HashMap<>();

        medicineDosage.put(WeightRangeMapper.LESS_THAN_TWENTY, DosageAndWeightMapper.setDosageAndWeightOfMedicine(14,19.9,0,0.5,MedicineType.TABLET, DosageRecipientType.ADULT));
        medicineDosage.put(WeightRangeMapper.LESS_THAN_TWENTY_FIVE, DosageAndWeightMapper.setDosageAndWeightOfMedicine(20,24.9,0,0.5,MedicineType.TABLET,DosageRecipientType.ADULT));
        medicineDosage.put(WeightRangeMapper.LESS_THAN_THIRTY, DosageAndWeightMapper.setDosageAndWeightOfMedicine(25,29.9,0,1,MedicineType.TABLET,DosageRecipientType.ADULT));
        medicineDosage.put(WeightRangeMapper.LESS_THAN_THIRTY_FIVE, DosageAndWeightMapper.setDosageAndWeightOfMedicine(30,34.9,0,1,MedicineType.TABLET,DosageRecipientType.ADULT));
        medicineDosage.put(WeightRangeMapper.LESS_THAN_FORTY, DosageAndWeightMapper.setDosageAndWeightOfMedicine(35,39.9,0,1,MedicineType.TABLET,DosageRecipientType.ADULT));
        medicineDosage.put(WeightRangeMapper.ABOVE_FORTY, DosageAndWeightMapper.setDosageAndWeightOfMedicine(40,300,0,1,MedicineType.TABLET,DosageRecipientType.ADULT));
    }

    @Override
    public HashMap<String,DosageAndWeight> getDosageAndWeightRange() {
        return medicineDosage;
    }

    @Override
    public String getName() {
        return MedicineNameMetaData.INH_300;
    }

    @Override
    public Integer getStandardDisperseNumberForAdults() {
        return NumberOfMedicineStandardMetaData.SIX_HUNDRED_AND_SEVENTY_TWO;
    }

    @Override
    public Integer getStandardDisperseNumberForPaediatrics() {
        return null;
    }

    @Override
    public boolean checkWeightRangeExistForMedicine(String weightRange) {
        return medicineDosage.get(weightRange) != null;
    }
}
