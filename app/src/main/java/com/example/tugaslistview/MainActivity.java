package com.example.tugaslistview;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;

import com.example.tugaslistview.databinding.ActivityMainBinding;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ActivityMainBinding binding;
    ListAdapter listAdapter;
    ArrayList<ListData> dataArrayList = new ArrayList<>();
    ListData listData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        int[] imageList = {R.drawable.serum,R.drawable.facewash, R.drawable.retinol, R.drawable.sunscreen, R.drawable.bodylotion, R.drawable.lipbalm, R.drawable.facewash};
        int[] ingredientList = {R.string.SerumIngredients,R.string.TonerIngredient, R.string.RetinolIngredients,R.string.SunscreenIngredients, R.string.BodylotionIngredients, R.string.LipbalmIngredients, R.string.FacewashIngredients };
        int[] descList = {R.string.SerumDesc,R.string.TonerDesc,R.string.RetinolDesc,R.string.SunscreenDesc,R.string.BodylotionDesc,R.string.LipbalmDesc,R.string.FacewashDesc};
        String[] nameList = {"Serum","Toner","Retinol","Sunscreen","Body Lotion","Lip Balm","Face Wash"};
        String[] timeList = {"30 Dilihat", "10 Dilihat","25 Dilihat","7 Dilihat","5 Dilihat","39 Dilihat","2 Dilihat",};

        for (int i = 0; i <imageList.length; i++){
            listData = new ListData(nameList[i], timeList[i], ingredientList[i], descList[i], imageList[i]);
            dataArrayList.add(listData);
        }
        listAdapter = new ListAdapter(MainActivity.this, dataArrayList);
        binding.listview.setAdapter(listAdapter);
        binding.listview.setClickable(true);

        binding.listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent = new Intent(MainActivity.this, DetailActivity.class);
                intent.putExtra("name", nameList[i]);
                intent.putExtra("time", timeList[i]);
                intent.putExtra("ingredients", ingredientList[i]);
                intent.putExtra("desc", descList[i]);
                intent.putExtra("image", imageList[i]);
                startActivity(intent);

            }
        });
    }
    }
