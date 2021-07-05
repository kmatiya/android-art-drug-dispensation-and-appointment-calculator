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

public class LPVrPellets implements MedicineService {

    private final HashMap<String, DosageAndWeight> medicineDosage;

    public LPVrPellets()
    {
        medicineDosage = new HashMap<>();

        medicineDosage.put(WeightRangeMapper.LESS_THAN_FOUR, DosageAndWeightMapper.setDosageAndWeightOfMedicine(3,3.9,2,2, MedicineType.PELLETS, DosageRecipientType.PAEDIATRIC));
        medicineDosage.put(WeightRangeMapper.LESS_THAN_SIX, DosageAndWeightMapper.setDosageAndWeightOfMedicine(4,5.9,2,2,MedicineType.PELLETS,DosageRecipientType.PAEDIATRIC));
        medicineDosage.put(WeightRangeMapper.LESS_THAN_TEN, DosageAndWeightMapper.setDosageAndWeightOfMedicine(6,9.9,3,3,MedicineType.PELLETS,DosageRecipientType.PAEDIATRIC));
        medicineDosage.put(WeightRangeMapper.LESS_THAN_FOURTEEN, DosageAndWeightMapper.setDosageAndWeightOfMedicine(10,13.9,4,4,MedicineType.PELLETS,DosageRecipientType.PAEDIATRIC));
        medicineDosage.put(WeightRangeMapper.LESS_THAN_TWENTY, DosageAndWeightMapper.setDosageAndWeightOfMedicine(14,19.9,5,5,MedicineType.PELLETS,DosageRecipientType.PAEDIATRIC));
        medicineDosage.put(WeightRangeMapper.LESS_THAN_TWENTY_FIVE, DosageAndWeightMapper.setDosageAndWeightOfMedicine(20,24.9,6,6,MedicineType.PELLETS,DosageRecipientType.PAEDIATRIC));
    }

    @Override
    public HashMap<String,DosageAndWeight> getDosageAndWeightRange() {
        return medicineDosage;
    }

    @Override
    public String getName() {
        return MedicineNameMetaData.LPV_r_PELLETS_IN_CAPS;
    }

    @Override
    public Integer getStandardDisperseNumberForAdults() {
        return null;
    }

    @Override
    public Integer getStandardDisperseNumberForPaediatrics() {
        return NumberOfMedicineStandardMetaData.ONE_HUNDRED_AND_TWENTY;
    }

    @Override
    public boolean checkWeightRangeExistForMedicine(String weightRange) {
        return medicineDosage.get(weightRange) != null;
    }
}
