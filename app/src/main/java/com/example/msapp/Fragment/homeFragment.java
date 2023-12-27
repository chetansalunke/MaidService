package com.example.msapp.Fragment;

import android.content.Intent;
import android.media.Image;
import android.os.Bundle;

import androidx.activity.result.contract.ActivityResultContracts;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.denzcoskun.imageslider.ImageSlider;
import com.denzcoskun.imageslider.constants.ScaleTypes;
import com.denzcoskun.imageslider.interfaces.ItemClickListener;
import com.denzcoskun.imageslider.models.SlideModel;
import com.example.msapp.BookingActivity;
import com.example.msapp.R;
import com.example.msapp.databinding.FragmentHomeBinding;

import java.util.ArrayList;
import java.util.List;

public class homeFragment extends Fragment {

    private FragmentHomeBinding binding;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentHomeBinding.inflate(inflater, container, false);
        View rootView = binding.getRoot();

        // Access the SliderView using binding
        ImageSlider sliderView = binding.imageSlider;

        // Now, create a list of SlideModel with images from the drawable folder
        List<SlideModel> imageList = new ArrayList<>();
        imageList.add(new SlideModel(R.drawable.banner1,ScaleTypes.FIT));
        imageList.add(new SlideModel(R.drawable.banner1,ScaleTypes.FIT));
        imageList.add(new SlideModel(R.drawable.banner1,ScaleTypes.FIT));

        LinearLayout driverService = binding.driverImgview;
        LinearLayout domesticService = binding.domesticServiceImg;
        LinearLayout cookigService = binding.cookImg;
        LinearLayout babysitterSerivce = binding.babySitterImg;
        LinearLayout eldercareService = binding.elderCareImg;
        LinearLayout patientcareService = binding.patientCareImg;
        LinearLayout petcareService = binding.petCareImg;
        LinearLayout officeboyService = binding.oficeBoyImg;


        // Set the image list to the SliderView
        sliderView.setImageList(imageList);


        binding.imageSlider.setItemClickListener(new ItemClickListener() {
            @Override
            public void onItemSelected(int i) {

            }

            @Override
            public void doubleClick(int i) {

            }
        });



        //  Booking driverService
        driverService.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                 startNextActivity("driverService");
            }
        });


        // Booking domesticService
        domesticService.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                 startNextActivity("domesticService");
            }
        });

        // Booking cookigService
        cookigService.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startNextActivity("cookigService");
            }
        });
        // Booking babysitterSerivce
        babysitterSerivce.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startNextActivity("babysitterSerivce");
            }
        });

        // Booking eldercareService
        eldercareService.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startNextActivity("eldercareService");
            }
        });

        // Booking patientcareService
        patientcareService.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startNextActivity("patientcareService");
            }
        });
        // Booking petcareService
        petcareService.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startNextActivity("petcareService");
            }
        });
        // Booking officeboyService
        officeboyService.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startNextActivity("officeboyService");
            }
        });

        return rootView;






    }

    // method to identify the which activity is clicled
    private void startNextActivity(String identifier) {
        Intent intent = new Intent(getContext(), BookingActivity.class);
        intent.putExtra("clicked_identifer",identifier);
        startActivity(intent);
    }
}