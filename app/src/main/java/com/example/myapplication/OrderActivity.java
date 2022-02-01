package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.example.myapplication.Adapters.OrdersAdapter;
import com.example.myapplication.Models.OrdersModel;
import com.example.myapplication.R;
import com.example.myapplication.databinding.ActivityOrderBinding;

import java.util.ArrayList;

public class OrderActivity extends AppCompatActivity {
ActivityOrderBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding= ActivityOrderBinding.inflate(getLayoutInflater());

        setContentView(binding.getRoot());
        DbHelper helper=new DbHelper(this);
        ArrayList<OrdersModel> list =helper.getorderslist();
        OrdersAdapter adapter=new OrdersAdapter(this, list);
        binding.orderrecyclerview.setAdapter(adapter);
        LinearLayoutManager layoutManager=new LinearLayoutManager(this);
        binding.orderrecyclerview.setLayoutManager(layoutManager);
        Intent intent=new Intent(OrderActivity.this, DetailActivity.class);
        String name=intent.getStringExtra("Name");
        String phone=intent.getStringExtra("Phone");

        intent.putExtra("Name" ,name);
        intent.putExtra("Phone" ,phone);
        startActivity(intent);

    }
}