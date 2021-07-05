package model;

import java.util.Date;

public class MedicineEndDate {
    private Date appointmentDate;
    private String medicineName;
    private double numberOfDrugs;

    public Date getAppointmentDate() {
        return appointmentDate;
    }

    public void setAppointmentDate(Date appointmentDate) {
        this.appointmentDate = appointmentDate;
    }

    public String getMedicineName() {
        return medicineName;
    }

    public void setMedicineName(String medicineName) {
        this.medicineName = medicineName;
    }

    public double getNumberOfDrugs() {
        return numberOfDrugs;
    }

    public void setNumberOfDrugs(double numberOfDrugs) {
        this.numberOfDrugs = numberOfDrugs;
    }
}
