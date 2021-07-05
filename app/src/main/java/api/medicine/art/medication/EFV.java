package api.medicine.art.medication;

import api.medicine.MedicineService;
import api.medicine.weight.WeightRangeMapper;
import api.util.DosageAndWeightMapper;
import metadata.MedicineNameMetaData;
import metadata.NumberOfMedicineStandardMetaData;
import model.DosageAndWeight;
import model.DosageRecipientType;
import model.medicineType.MedicineType;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class EFV implements MedicineService {

    private final HashMap<String, DosageAndWeight> medicineDosage;

    public EFV()
    {
        medicineDosage = new HashMap<>();
        List<DosageAndWeight> dosageAndWeightList = new ArrayList<>();

        medicineDosage.put(WeightRangeMapper.LESS_THAN_FOURTEEN, DosageAndWeightMapper.setDosageAndWeightOfMedicine(10,13.9,0,1,MedicineType.TABLET, DosageRecipientType.PAEDIATRIC));
        medicineDosage.put(WeightRangeMapper.LESS_THAN_TWENTY, DosageAndWeightMapper.setDosageAndWeightOfMedicine(14,19.9,0,1.5,MedicineType.TABLET,DosageRecipientType.PAEDIATRIC));
        medicineDosage.put(WeightRangeMapper.LESS_THAN_TWENTY_FIVE, DosageAndWeightMapper.setDosageAndWeightOfMedicine(20,24.9,0,1.5,MedicineType.TABLET,DosageRecipientType.PAEDIATRIC));
        medicineDosage.put(WeightRangeMapper.LESS_THAN_THIRTY, DosageAndWeightMapper.setDosageAndWeightOfMedicine(25,29.9,0,2,MedicineType.TABLET,DosageRecipientType.PAEDIATRIC));
        medicineDosage.put(WeightRangeMapper.LESS_THAN_THIRTY_FIVE, DosageAndWeightMapper.setDosageAndWeightOfMedicine(30,34.9,0,2,MedicineType.TABLET,DosageRecipientType.PAEDIATRIC));
        medicineDosage.put(WeightRangeMapper.LESS_THAN_FORTY, DosageAndWeightMapper.setDosageAndWeightOfMedicine(35,39.9,0,1,MedicineType.TABLET,DosageRecipientType.ADULT));
        medicineDosage.put(WeightRangeMapper.ABOVE_FORTY, DosageAndWeightMapper.setDosageAndWeightOfMedicine(40,300,0,1,MedicineType.TABLET,DosageRecipientType.ADULT));
    }

    @Override
    public HashMap<String,DosageAndWeight> getDosageAndWeightRange() {
        return medicineDosage;
    }

    @Override
    public String getName() {
        return MedicineNameMetaData.EFV;
    }

    @Override
    public Integer getStandardDisperseNumberForAdults() {
        return NumberOfMedicineStandardMetaData.THIRTY;
    }

    @Override
    public Integer getStandardDisperseNumberForPaediatrics() {
        return NumberOfMedicineStandardMetaData.NINENTY;
    }

    @Override
    public boolean checkWeightRangeExistForMedicine(String weightRange) {
        return medicineDosage.get(weightRange) != null;
    }
}
