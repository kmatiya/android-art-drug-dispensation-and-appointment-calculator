package api.appointment.impl;

import api.appointment.AppointmentCalculationService;
import api.medicine.MedicineService;
import model.Dosage;
import model.MedicineEndDate;

import java.util.Calendar;
import java.util.Date;

public class AppointmentCalculationServiceImpl implements AppointmentCalculationService {
    public static final int DAYS_IN_A_WEEK = 7;
    @Override
    public MedicineEndDate calculateNextAppointmentDate(Calendar calendar, int numberOfWeeks, String weightRange, MedicineService getRegimenDrugCombination) {
            boolean checkIfCombinationExist = getRegimenDrugCombination.getDosageAndWeightRange().containsKey(weightRange);
            if(!checkIfCombinationExist) {
                return null;
            }
            Dosage getDosage = getRegimenDrugCombination.getDosageAndWeightRange().get(weightRange).getDosage();
            double sumOfDosage = getDosage.getEvening() + getDosage.getMorning();
            double daysToNextAppointment = numberOfWeeks * DAYS_IN_A_WEEK * sumOfDosage;
            calendar.add(Calendar.DAY_OF_MONTH, (int) daysToNextAppointment);
            MedicineEndDate medicineEndDate = new MedicineEndDate();
            medicineEndDate.setMedicineName(getRegimenDrugCombination.getName());
            medicineEndDate.setNumberOfDrugs(daysToNextAppointment);
            Date appointmentDate = calendar.getTime();
            medicineEndDate.setAppointmentDate(appointmentDate);
        return medicineEndDate;
    }
}
