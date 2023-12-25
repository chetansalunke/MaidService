package com.example.msapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.Spinner;

import com.example.msapp.databinding.ActivityBookingBinding;
import com.example.msapp.databinding.ActivityOtpSendBinding;
import com.google.android.material.textfield.TextInputLayout;

public class BookingActivity extends AppCompatActivity {

    private ActivityBookingBinding binding;
    String[] items={"Baner","Kothrud","Shivaji Nagar","Bhukum","Hinjwadi"};

    TextInputLayout addressEt;
    RadioGroup workergenderRg;
    Spinner locationSpinner;
    CheckBox dishWashingCb;
    CheckBox broomingMoppingCb;
    CheckBox dustingCb;
    CheckBox morinigCb;
    CheckBox afternoon;
    CheckBox eveningCb;
    CheckBox nightCb;
    RadioGroup packageRg;

    Button bokingBtn;


    // get the extra from intent







    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityBookingBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        locationSpinner = binding.locationSpinner;
        addressEt = binding.addressEt;


        Intent intent = getIntent();

        String domesticService = intent.getStringExtra("domesticService");
        String cookigService = intent.getStringExtra("cookigService");
        String babysitterSerivce = intent.getStringExtra("babysitterSerivce");
        String patientcareService = intent.getStringExtra("patientcareService");
        String eldercareService = intent.getStringExtra("eldercareService");
        String petcareService = intent.getStringExtra("petcareService");
        String officeboyService = intent.getStringExtra("officeboyService");
        String driverService = intent.getStringExtra("driverService");

        if( domesticService =="domesticService")
        {
            locationSpinner.setVisibility(View.GONE);
            addressEt.setVisibility(View.GONE);
        }












        // Location spinner
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item,items);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_item);
        binding.locationSpinner.setAdapter(adapter);






    }
}