package com.example.msapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;

import com.example.msapp.databinding.ActivityBookingBinding;
import com.example.msapp.databinding.ActivityOtpSendBinding;

public class BookingActivity extends AppCompatActivity {

    private ActivityBookingBinding binding;
    String[] items={"Baner","Kothrud","Shivaji Nagar","Bhukum"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityBookingBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item,items);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_item);

        binding.spinner.setAdapter(adapter);
    }
}