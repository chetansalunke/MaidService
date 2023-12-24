package com.example.msapp.Fragment;

import android.content.Intent;
import android.os.Bundle;

import androidx.activity.result.contract.ActivityResultContracts;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

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

        ImageView imageView = binding.driverImgview;



        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                 Intent intent = new Intent(getContext(), BookingActivity.class);
                 startActivity(intent);
            }
        });


        // Booking domestic service

        ImageView domesticService = binding.domesticServiceImg;
        domesticService.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getContext(), BookingActivity.class);
                startActivity(intent);
            }
        });

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

        return rootView;






    }
}