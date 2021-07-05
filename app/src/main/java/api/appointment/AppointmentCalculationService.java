package api.appointment;

import api.medicine.MedicineService;
import model.MedicineEndDate;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public interface AppointmentCalculationService {
    MedicineEndDate  calculateNextAppointmentDate(Calendar calendar, int numberOfWeeks, String weightRange, MedicineService getRegimenDrugCombinations);
}
