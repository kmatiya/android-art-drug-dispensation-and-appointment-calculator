package api.util;

import model.Dosage;
import model.DosageAndWeight;
import model.DosageRecipientType;
import model.medicineType.MedicineType;
import model.WeightRange;

public class DosageAndWeightMapper {
    public static DosageAndWeight setDosageAndWeightOfMedicine(double minWeight, double maxWeight, double morningDose, double eveningDose, MedicineType medicineType, DosageRecipientType dosageRecipientType){
        DosageAndWeight dosageAndWeight = new DosageAndWeight();
        Dosage dosage = new Dosage();
        WeightRange weightRange = new WeightRange();
        dosage.setMorning(morningDose);
        dosage.setEvening(eveningDose);
        dosage.setMedicineType(medicineType);
        dosage.setDosageRecipientType(dosageRecipientType);
        weightRange.setMaxWeight(maxWeight);
        weightRange.setMinWeight(minWeight);
        dosageAndWeight.setWeightRange(weightRange);
        dosageAndWeight.setDosage(dosage);
        return dosageAndWeight;
    }
}
