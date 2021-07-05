package com.pih.drug.artcalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import api.appointment.AppointmentCalculationService;
import api.appointment.impl.AppointmentCalculationServiceImpl;
import api.medicine.MedicineService;
import api.medicine.art.regimen.RegimenFactoryService;
import api.medicine.art.regimen.RegimenService;
import api.medicine.art.regimen.impl.RegimenFactoryImplementation;
import api.medicine.art.regimen.repository.RegimenRepository;
import api.medicine.art.regimen.repository.impl.RegimenRepositoryImpl;
import api.medicine.art.regimen.validator.RegimenValidator;
import api.medicine.art.regimen.validator.impl.RegimenValidatorImpl;
import model.Dosage;
import model.MedicineEndDate;

public class MedicineCalculationActivity extends AppCompatActivity {
    Spinner regimenSpinner;
    Spinner drugSpinner;
    DatePicker drugDatePicker;
    EditText weightEditText;
    EditText weeksEditText;

    RegimenService regimenService;

    public void btnClick(View view){
        String selectedDrugItem = (String) drugSpinner.getSelectedItem();
        String selectedRegimenItem = (String) regimenSpinner.getSelectedItem();
        MedicineService medicineService = regimenService.getMedicineByMedicineName(selectedDrugItem);
        AppointmentCalculationService appointmentCalculationService = new AppointmentCalculationServiceImpl();
        RegimenValidator regimenValidator = new RegimenValidatorImpl();
        String weight = String.valueOf(weightEditText.getText());
        String weightRange = regimenValidator.isWeightValid(Double.parseDouble(weight), regimenService.getRegimenDrugCombination());
        boolean result = medicineService.checkWeightRangeExistForMedicine(weightRange);
        if(result){

            int year = drugDatePicker.getYear();
            int month = drugDatePicker.getMonth();
            int day = drugDatePicker.getDayOfMonth();

            Calendar calendar = Calendar.getInstance();
            @SuppressLint("SimpleDateFormat") SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
            String dateFormatted = dateFormat.format(calendar.getTime());
            calendar.set(year,month,day);
            MedicineEndDate medicineEndDate = appointmentCalculationService.calculateNextAppointmentDate(calendar,Integer.parseInt(String.valueOf(weeksEditText.getText())),weightRange,medicineService);
           // Toast.makeText(getApplicationContext(), "Medicine: "+medicineEndDate.getMedicineName()+", "+ medicineEndDate.getAppointmentDate()+", "+ medicineEndDate.getNumberOfDrugs(), Toast.LENGTH_LONG).show();
            Dosage getDosage = medicineService.getDosageAndWeightRange().get(weightRange).getDosage();
            Intent drugSummaryIntent = new Intent(getApplicationContext(), DrugSummaryActivity.class);
            drugSummaryIntent.putExtra("weight", weight);
            drugSummaryIntent.putExtra("regimen",selectedRegimenItem);
            drugSummaryIntent.putExtra("drug_type", selectedDrugItem);
            drugSummaryIntent.putExtra("number_of_drugs", String.valueOf(medicineEndDate.getNumberOfDrugs()));
            drugSummaryIntent.putExtra("number_of_weeks", weeksEditText.getText().toString());
            drugSummaryIntent.putExtra("morning_dosage", String.valueOf(getDosage.getMorning()));
            drugSummaryIntent.putExtra("evening_dosage", String.valueOf(getDosage.getEvening()));
            drugSummaryIntent.putExtra("start_date", dateFormatted);
            String appointmentDateFormatted = dateFormat.format(medicineEndDate.getAppointmentDate());
            drugSummaryIntent.putExtra("appointment_date",appointmentDateFormatted);
            startActivity(drugSummaryIntent);
        }
        else
        {
            Toast.makeText(getApplicationContext(),"Dosage for weight "+ weightEditText.getText()+" does not exist for "+ medicineService.getName(),Toast.LENGTH_LONG).show();
        }

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_medicine_calculation);
        regimenSpinner = findViewById(R.id.regimen_spinner);
        drugSpinner = findViewById(R.id.drug_spinner);
        drugDatePicker = findViewById(R.id.datePicker_drug_calculator);
        weightEditText = findViewById(R.id.weight_edit_text);
        weeksEditText = findViewById(R.id.weeks_edit_text);
        ArrayAdapter<String> adapter;
        RegimenRepository regimenRepository = new RegimenRepositoryImpl();
        RegimenFactoryService regimenFactoryService = new RegimenFactoryImplementation();
        List<String> allRegimens = regimenRepository.getAllRegimens();
        List<String> list = new ArrayList<>();
        list.addAll(allRegimens);
        adapter = new ArrayAdapter<String>(getApplicationContext(),
                android.R.layout.simple_spinner_item, list);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        regimenSpinner.setAdapter(adapter);
        regimenSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                // Toast.makeText(adapterView.getContext(), "The planet is " +
                //        adapterView.getItemAtPosition(i).toString(), Toast.LENGTH_LONG).show();
                String selectedRegimen = allRegimens.get(i);
                regimenService = regimenFactoryService.getRegimen(selectedRegimen);
                List<String> drugList = new ArrayList<>();
                for(MedicineService medicineService : regimenService.getRegimenDrugCombination()){
                    drugList.add(medicineService.getName());
                }
                ArrayAdapter<String> drugAdapter = new ArrayAdapter<String>(getApplicationContext(),
                        android.R.layout.simple_spinner_item, drugList);
                drugAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                drugSpinner.setAdapter(drugAdapter);
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
    }
}