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

public class AZT3TCNVP implements MedicineService {

    private final HashMap<String, DosageAndWeight> medicineDosage;

    public AZT3TCNVP()
    {
        medicineDosage = new HashMap<>();

        medicineDosage.put(WeightRangeMapper.LESS_THAN_FOUR, DosageAndWeightMapper.setDosageAndWeightOfMedicine(3,3.9,1,1, MedicineType.TABLET,DosageRecipientType.PAEDIATRIC));
        medicineDosage.put(WeightRangeMapper.LESS_THAN_SIX, DosageAndWeightMapper.setDosageAndWeightOfMedicine(4,5.9,1,1,MedicineType.TABLET,DosageRecipientType.PAEDIATRIC));
        medicineDosage.put(WeightRangeMapper.LESS_THAN_TEN, DosageAndWeightMapper.setDosageAndWeightOfMedicine(6,9.9,1.5,1.5,MedicineType.TABLET,DosageRecipientType.PAEDIATRIC));
        medicineDosage.put(WeightRangeMapper.LESS_THAN_FOURTEEN, DosageAndWeightMapper.setDosageAndWeightOfMedicine(10,13.9,2,2,MedicineType.TABLET,DosageRecipientType.PAEDIATRIC));
        medicineDosage.put(WeightRangeMapper.LESS_THAN_TWENTY, DosageAndWeightMapper.setDosageAndWeightOfMedicine(14,19.9,2.5,2.5,MedicineType.TABLET,DosageRecipientType.PAEDIATRIC));
        medicineDosage.put(WeightRangeMapper.LESS_THAN_TWENTY_FIVE, DosageAndWeightMapper.setDosageAndWeightOfMedicine(20,24.9,3,3,MedicineType.TABLET,DosageRecipientType.PAEDIATRIC));
        medicineDosage.put(WeightRangeMapper.LESS_THAN_THIRTY, DosageAndWeightMapper.setDosageAndWeightOfMedicine(25,29.9,1,1,MedicineType.TABLET,DosageRecipientType.ADULT));
        medicineDosage.put(WeightRangeMapper.LESS_THAN_THIRTY_FIVE, DosageAndWeightMapper.setDosageAndWeightOfMedicine(30,34.9,1,1,MedicineType.TABLET,DosageRecipientType.ADULT));
        medicineDosage.put(WeightRangeMapper.LESS_THAN_FORTY, DosageAndWeightMapper.setDosageAndWeightOfMedicine(35,39.9,1,1,MedicineType.TABLET,DosageRecipientType.ADULT));
        medicineDosage.put(WeightRangeMapper.ABOVE_FORTY, DosageAndWeightMapper.setDosageAndWeightOfMedicine(40,300,1,1,MedicineType.TABLET, DosageRecipientType.ADULT));
    }

    @Override
    public HashMap<String,DosageAndWeight> getDosageAndWeightRange() {
        return medicineDosage;
    }

    @Override
    public String getName() {
        return MedicineNameMetaData.AZT_3TC_NVP;
    }

    @Override
    public Integer getStandardDisperseNumberForAdults() {
        return NumberOfMedicineStandardMetaData.SIXTY;
    }

    @Override
    public Integer getStandardDisperseNumberForPaediatrics() {
        return NumberOfMedicineStandardMetaData.SIXTY;
    }

    @Override
    public boolean checkWeightRangeExistForMedicine(String weightRange) {
        return medicineDosage.get(weightRange) != null;
    }
}
