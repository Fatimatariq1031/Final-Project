package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.myapplication.Adapters.MainAdapter;
import com.example.myapplication.Models.MainModel;
import com.example.myapplication.databinding.ActivityMainBinding;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ActivityMainBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding= ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        ArrayList<MainModel> list= new ArrayList<>();
        list.add(new MainModel(R.drawable.ic_launcher_background, "Med1", "5", "This is medicine"));

        list.add(new MainModel(R.drawable.ic_launcher_background, "Med1", "5", "This is medicine"));
        list.add(new MainModel(R.drawable.ic_launcher_background, "Med1", "5", "This is medicine"));
        list.add(new MainModel(R.drawable.ic_launcher_background, "Med1", "5", "This is medicine"));
        list.add(new MainModel(R.drawable.ic_launcher_background, "Med1", "5", "This is medicine"));
        MainAdapter adapter = new MainAdapter(list, this);

        binding.recyclerview.setAdapter(adapter);
        LinearLayoutManager layoutManager=new LinearLayoutManager(this);
        binding.recyclerview.setLayoutManager(layoutManager);


    }
}
