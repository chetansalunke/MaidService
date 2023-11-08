package com.example.msapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Toast;

import com.example.msapp.databinding.ActivityOtpVerifyBinding;
import com.google.android.gms.auth.api.phone.SmsRetriever;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.PhoneAuthCredential;
import com.google.firebase.auth.PhoneAuthProvider;

public class OtpVerifyActivity extends AppCompatActivity {


    private ActivityOtpVerifyBinding binding;
    private String verificationId;
//    private OTP_Receiver otp_receiver;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityOtpVerifyBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());


        editTextInput();

        binding.mobileTv.setText(String.format(
                "+91-%s", getIntent().getStringExtra("phone")
        ));
        Toast.makeText(this,getIntent().getStringExtra("phone"), Toast.LENGTH_SHORT).show();

        verificationId = getIntent().getStringExtra("verificationId");

        binding.redentOtp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(OtpVerifyActivity.this, "OTP Send Successfully.", Toast.LENGTH_SHORT).show();
            }
        });

        binding.verifyBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                binding.probar2.setVisibility(View.VISIBLE);
                binding.verifyBtn.setVisibility(View.INVISIBLE);
                if(binding.inputotp1.getText().toString().trim().isEmpty() ||
                        binding.inputotp2.getText().toString().trim().isEmpty() ||
                        binding.inputotp3.getText().toString().trim().isEmpty() ||
                        binding.inputotp4.getText().toString().trim().isEmpty() ||
                        binding.inputotp5.getText().toString().trim().isEmpty() ||
                        binding.inputotp6.getText().toString().trim().isEmpty()
                      ){
                    Toast.makeText(OtpVerifyActivity.this, "OTP is not Valid!", Toast.LENGTH_SHORT).show();
                }else{
                    if(verificationId != null){

                        String code = binding.inputotp1.getText().toString().trim() +binding.inputotp2.getText().toString().trim()+binding.inputotp3.getText().toString().trim()+binding.inputotp4.getText().toString().trim()+binding.inputotp5.getText().toString().trim()+binding.inputotp6.getText().toString().trim();

                        PhoneAuthCredential credential = PhoneAuthProvider.getCredential(verificationId, code);

                        FirebaseAuth.getInstance().signInWithCredential(credential).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                            @Override
                            public void onComplete(@NonNull Task<AuthResult> task) {
                                if(task.isSuccessful()){
                                    binding.probar2.setVisibility(View.VISIBLE);
                                    binding.verifyBtn.setVisibility(View.INVISIBLE);
                                    Intent intent = new Intent(OtpVerifyActivity.this,MainActivity.class);
                                    intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
                                    startActivity(intent);
                                }else{
                                    binding.probar2.setVisibility(View.GONE);
                                    binding.verifyBtn.setVisibility(View.VISIBLE);
                                    Toast.makeText(OtpVerifyActivity.this, "OTP is not Valid!", Toast.LENGTH_SHORT).show();
                                }
                            }
                        });
                    }
                }
            }
        });



//        autOtpReceiver();

    }

    private void editTextInput() {

        binding.inputotp1.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                binding.inputotp2.requestFocus();
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });
        binding.inputotp2.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                binding.inputotp3.requestFocus();
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });
        binding.inputotp3.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                binding.inputotp4.requestFocus();
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });
        binding.inputotp4.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                binding.inputotp5.requestFocus();
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });
        binding.inputotp5.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                binding.inputotp6.requestFocus();
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });

    }

//    private void autOtpReceiver() {
//        otp_receiver = new OTP_Receiver();
//        this.registerReceiver(otp_receiver,new IntentFilter(SmsRetriever.SMS_RETRIEVED_ACTION));
//        otp_receiver.initListner(new OTP_Receiver.OtpReceiverListener() {
//            @Override
//            public void onOtpSuccess(String otp) {
//                int o1 = Character.getNumericValue(otp.charAt(0));
//                int o2 = Character.getNumericValue(otp.charAt(1));
//                int o3 = Character.getNumericValue(otp.charAt(2));
//                int o4= Character.getNumericValue(otp.charAt(3));
//                int o5 = Character.getNumericValue(otp.charAt(4));
//                int o6 = Character.getNumericValue(otp.charAt(5));
//
//
//            }
//
//            @Override
//            public void onOtpTimeout() {
//
//            }
//        });
//    }
//
//    @Override
//    protected void onDestroy() {
//        super.onDestroy();
//        if(otp_receiver !=null){
//            unregisterReceiver(otp_receiver);
//        }
//    }
}