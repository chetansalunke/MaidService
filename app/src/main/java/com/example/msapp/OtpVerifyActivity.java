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
import com.google.firebase.FirebaseException;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.PhoneAuthCredential;
import com.google.firebase.auth.PhoneAuthOptions;
import com.google.firebase.auth.PhoneAuthProvider;

import java.util.concurrent.TimeUnit;

public class OtpVerifyActivity extends AppCompatActivity {

    private ActivityOtpVerifyBinding binding;
    private FirebaseAuth mAuth;
    private PhoneAuthProvider.OnVerificationStateChangedCallbacks mCallbacks;
    private String verificationId;
    private OTP_Receiver otp_receiver;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityOtpVerifyBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        mAuth = FirebaseAuth.getInstance();

        editTextInput();

        binding.mobileTv.setText(String.format(
                "+91-%s", getIntent().getStringExtra("phone").trim()
        ));

        verificationId = getIntent().getStringExtra("verificationId");

        binding.redentOtp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                Toast.makeText(OtpVerifyActivity.this, "OTP Send Successfully.", Toast.LENGTH_SHORT).show();
                againotpSend();
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

        autOtpReceiver();


    }

    private void againotpSend() {
        binding.probar2.setVisibility(View.VISIBLE);
        binding.verifyBtn.setVisibility(View.INVISIBLE);

        mCallbacks = new PhoneAuthProvider.OnVerificationStateChangedCallbacks() {

            @Override
            public void onVerificationCompleted(@NonNull PhoneAuthCredential credential) {

            }
            @Override
            public void onVerificationFailed(@NonNull FirebaseException e) {
                binding.probar2.setVisibility(View.GONE);
                binding.verifyBtn.setVisibility(View.VISIBLE);
                Toast.makeText(OtpVerifyActivity.this, e.getLocalizedMessage(), Toast.LENGTH_SHORT).show();

            }

            @Override
            public void onCodeSent(@NonNull String verificationId,
                                   @NonNull PhoneAuthProvider.ForceResendingToken token) {
                binding.probar2.setVisibility(View.GONE);
                binding.verifyBtn.setVisibility(View.VISIBLE);

            }

        };
        PhoneAuthOptions options =
                PhoneAuthOptions.newBuilder(mAuth)
                        .setPhoneNumber("+91"+getIntent().getStringExtra("phone").trim())    // Phone number to verify
                        .setTimeout(60L, TimeUnit.SECONDS) // Timeout and unit
                        .setActivity(this)                 // (optional) Activity for callback binding
                        // If no activity is passed, reCAPTCHA verification can not be used.
                        .setCallbacks(mCallbacks)          // OnVerificationStateChangedCallbacks
                        .build();
        PhoneAuthProvider.verifyPhoneNumber(options);


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

    private void autOtpReceiver() {
        otp_receiver = new OTP_Receiver();
        this.registerReceiver(otp_receiver,new IntentFilter(SmsRetriever.SMS_RETRIEVED_ACTION));
        otp_receiver.initListner(new OTP_Receiver.OtpReceiverListener() {
            @Override
            public void onOtpSuccess(String otp) {

                int o1 = Character.getNumericValue(otp.charAt(0));
                int o2 = Character.getNumericValue(otp.charAt(1));
                int o3 = Character.getNumericValue(otp.charAt(2));
                int o4= Character.getNumericValue(otp.charAt(3));
                int o5 = Character.getNumericValue(otp.charAt(4));
                int o6 = Character.getNumericValue(otp.charAt(5));

                binding.inputotp1.setText(String.valueOf(o1));
                binding.inputotp2.setText(String.valueOf(o2));
                binding.inputotp3.setText(String.valueOf(o3));
                binding.inputotp4.setText(String.valueOf(o4));
                binding.inputotp5.setText(String.valueOf(o5));
                binding.inputotp6.setText(String.valueOf(o6));
}
            @Override
            public void onOtpTimeout() {
                Toast.makeText(OtpVerifyActivity.this, "Something went Wrong!", Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if(otp_receiver !=null){
            unregisterReceiver(otp_receiver);
        }
    }
}