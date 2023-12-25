package com.example.msapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.Toolbar;

import com.example.msapp.databinding.ActivityBookingBinding;
import com.example.msapp.databinding.ActivityOtpSendBinding;
import com.google.android.material.textfield.TextInputLayout;

public class BookingActivity extends AppCompatActivity {

    private ActivityBookingBinding binding;
    String[] items={"Baner","Kothrud","Shivaji Nagar","Bhukum","Hinjwadi"};

    TextInputLayout addressEt;
    TextView selectTimeTv;
    Toolbar appBar;
    TextView selectAgeTv;
    TextView addOnTv;
    TextView workerPrefTv;
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
    RadioGroup selectAgeRg;
    RadioGroup workerPrefRg;

    Button bokingBtn;


    // get the extra from intent







    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityBookingBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        locationSpinner = binding.locationSpinner;
        addressEt = binding.addressEt;
        selectAgeTv = binding.selectAgeTv;
        selectAgeRg = binding.slectAgeRg;
        eveningCb = binding.checkBox6;
        addOnTv = binding.addOnTv;
        dishWashingCb = binding.checkBox1;
        broomingMoppingCb = binding.checkBox2;
        dustingCb = binding.checkBox3;
        workerPrefTv = binding.workerPrefTv;
        workergenderRg = binding.workergenderRg;
        selectTimeTv = binding.selectTimeTv;
        morinigCb = binding.checkBox4;
        afternoon = binding.checkBox5;
        nightCb = binding.checkBox7;

        Intent intent = getIntent();

        String clicked_identifer = intent.getStringExtra("clicked_identifer");


        if( clicked_identifer.equalsIgnoreCase("domesticService"))
        {
            //appBar.setTitle("Domestic Service Booking");
            selectAgeTv.setVisibility(View.GONE);
            selectAgeRg.setVisibility(View.GONE);
        }else if(clicked_identifer.equalsIgnoreCase("cookigService")){
            selectAgeTv.setVisibility(View.GONE);
            selectAgeRg.setVisibility(View.GONE);
            eveningCb.setVisibility(View.GONE);
            addOnTv.setVisibility(View.GONE);
            dishWashingCb.setVisibility(View.GONE);
            broomingMoppingCb.setVisibility(View.GONE);
            dustingCb.setVisibility(View.GONE);

        }else if(clicked_identifer.equalsIgnoreCase("babysitterSerivce"))
        {
            workerPrefTv.setVisibility(View.GONE);
            workergenderRg.setVisibility(View.GONE);
            addOnTv.setVisibility(View.GONE);
            dishWashingCb.setVisibility(View.GONE);
            broomingMoppingCb.setVisibility(View.GONE);
            dustingCb.setVisibility(View.GONE);
            eveningCb.setVisibility(View.GONE);
        }else if(clicked_identifer.equalsIgnoreCase("eldercareService")){
            workerPrefTv.setVisibility(View.GONE);
            workergenderRg.setVisibility(View.GONE);
            addOnTv.setVisibility(View.GONE);
            dishWashingCb.setVisibility(View.GONE);
            broomingMoppingCb.setVisibility(View.GONE);
            dustingCb.setVisibility(View.GONE);
            eveningCb.setVisibility(View.GONE);
            selectTimeTv.setVisibility(View.GONE);
            morinigCb.setVisibility(View.GONE);
            afternoon.setVisibility(View.GONE);
            nightCb.setVisibility(View.GONE);
            selectAgeTv.setVisibility(View.GONE);
            selectAgeRg.setVisibility(View.GONE);
        }else if(clicked_identifer.equalsIgnoreCase("patientcareService")){
            workerPrefTv.setVisibility(View.GONE);
            workergenderRg.setVisibility(View.GONE);
            addOnTv.setVisibility(View.GONE);
            dishWashingCb.setVisibility(View.GONE);
            broomingMoppingCb.setVisibility(View.GONE);
            dustingCb.setVisibility(View.GONE);
            eveningCb.setVisibility(View.GONE);
            selectTimeTv.setVisibility(View.GONE);
            morinigCb.setVisibility(View.GONE);
            afternoon.setVisibility(View.GONE);
            nightCb.setVisibility(View.GONE);
            selectAgeTv.setVisibility(View.GONE);
            selectAgeRg.setVisibility(View.GONE);
        }
        else if(clicked_identifer.equalsIgnoreCase("petcareService")){
            workerPrefTv.setVisibility(View.GONE);
            workergenderRg.setVisibility(View.GONE);
            addOnTv.setVisibility(View.GONE);
            dishWashingCb.setVisibility(View.GONE);
            broomingMoppingCb.setVisibility(View.GONE);
            dustingCb.setVisibility(View.GONE);
            eveningCb.setVisibility(View.GONE);
            selectTimeTv.setVisibility(View.GONE);
            morinigCb.setVisibility(View.GONE);
            afternoon.setVisibility(View.GONE);
            nightCb.setVisibility(View.GONE);
            selectAgeTv.setVisibility(View.GONE);
            selectAgeRg.setVisibility(View.GONE);
        }
        else if(clicked_identifer.equalsIgnoreCase("officeboyService")){
            workerPrefTv.setVisibility(View.GONE);
            workergenderRg.setVisibility(View.GONE);
            addOnTv.setVisibility(View.GONE);
            dishWashingCb.setVisibility(View.GONE);
            broomingMoppingCb.setVisibility(View.GONE);
            dustingCb.setVisibility(View.GONE);
            eveningCb.setVisibility(View.GONE);
            selectTimeTv.setVisibility(View.GONE);
            morinigCb.setVisibility(View.GONE);
            afternoon.setVisibility(View.GONE);
            nightCb.setVisibility(View.GONE);
            selectAgeTv.setVisibility(View.GONE);
            selectAgeRg.setVisibility(View.GONE);}
        else if(clicked_identifer.equalsIgnoreCase("driverService")){
                workerPrefTv.setVisibility(View.GONE);
                workergenderRg.setVisibility(View.GONE);
                addOnTv.setVisibility(View.GONE);
                dishWashingCb.setVisibility(View.GONE);
                broomingMoppingCb.setVisibility(View.GONE);
                dustingCb.setVisibility(View.GONE);
                eveningCb.setVisibility(View.GONE);
                selectTimeTv.setVisibility(View.GONE);
                morinigCb.setVisibility(View.GONE);
                afternoon.setVisibility(View.GONE);
                nightCb.setVisibility(View.GONE);
                selectAgeTv.setVisibility(View.GONE);
                selectAgeRg.setVisibility(View.GONE);
            }

        // Location spinner
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item,items);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_item);
        binding.locationSpinner.setAdapter(adapter);




    }
}