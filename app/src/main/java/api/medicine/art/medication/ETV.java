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

public class ETV implements MedicineService {

    private final HashMap<String, DosageAndWeight> medicineDosage;

    public ETV()
    {
        medicineDosage = new HashMap<>();

        medicineDosage.put(WeightRangeMapper.LESS_THAN_FORTY, DosageAndWeightMapper.setDosageAndWeightOfMedicine(35,39.9,2,2,MedicineType.TABLET, DosageRecipientType.ADULT));
        medicineDosage.put(WeightRangeMapper.ABOVE_FORTY, DosageAndWeightMapper.setDosageAndWeightOfMedicine(40,300,2,2,MedicineType.TABLET,DosageRecipientType.ADULT));
    }

    @Override
    public HashMap<String,DosageAndWeight> getDosageAndWeightRange() {
        return medicineDosage;
    }

    @Override
    public String getName() {
        return MedicineNameMetaData.ETV;
    }

    @Override
    public Integer getStandardDisperseNumberForAdults() {
        return NumberOfMedicineStandardMetaData.ONE_HUNDRED_AND_TWENTY;
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
