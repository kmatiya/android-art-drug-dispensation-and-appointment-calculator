package com.pih.drug.artcalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class DrugSummaryActivity extends AppCompatActivity {
    TextView weightTextView;
    TextView regimenTextView;
    TextView drugTypeTextView;
    TextView numberOfDrugsTextView;
    TextView morningDosageTextView;
    TextView eveningDosageTextView;
    TextView startDateTextView;
    TextView appointmentDateTextView;
    TextView numberOfWeeksTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_drug_summary);
        Intent intent = getIntent();
        weightTextView = findViewById(R.id.weight_value_textview);
        regimenTextView = findViewById(R.id.regimen_value_textview);
        drugTypeTextView = findViewById(R.id.drug_type_textview);
        numberOfDrugsTextView = findViewById(R.id.number_of_drug_textview);
        morningDosageTextView = findViewById(R.id.morning_dosage_textview);
        eveningDosageTextView = findViewById(R.id.evening_dosage_textview);
        startDateTextView = findViewById(R.id.start_date_textview);
        appointmentDateTextView = findViewById(R.id.end_date_value_textview);
        numberOfWeeksTextView = findViewById(R.id.number_of_weeks_textview);

        weightTextView.setText(intent.getStringExtra("weight"));
        regimenTextView.setText(intent.getStringExtra("regimen"));
        drugTypeTextView.setText(intent.getStringExtra("drug_type"));
        numberOfDrugsTextView.setText(intent.getStringExtra("number_of_drugs"));
        numberOfWeeksTextView.setText(intent.getStringExtra("number_of_weeks"));
        morningDosageTextView.setText(intent.getStringExtra("morning_dosage"));
        eveningDosageTextView.setText(intent.getStringExtra("evening_dosage"));
        startDateTextView.setText(intent.getStringExtra("start_date"));
        appointmentDateTextView.setText(intent.getStringExtra("appointment_date"));
    }
}