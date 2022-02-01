package com.example.myapplication;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.myapplication.databinding.ActivityDetailBinding;

public class DetailActivity extends AppCompatActivity {
 ActivityDetailBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding= ActivityDetailBinding.inflate(getLayoutInflater());
        //setContentView(R.layout.activity_detail);
        setContentView(binding.getRoot());
        final DbHelper helper = new DbHelper(this);

            final int image = getIntent().getIntExtra("image", 0);
            final int price = Integer.parseInt(getIntent().getStringExtra("price"));
            final String name = (getIntent().getStringExtra("name"));
            final String Desc = (getIntent().getStringExtra("description"));
        final String Name = (getIntent().getStringExtra("Name"));
        final String phone = (getIntent().getStringExtra("Phone"));
            binding.detailimage.setImageResource(image);
            binding.textView7.setText(String.format("%d", price));
            binding.textView.setText(name);
            binding.textView3.setText(Desc);


            binding.button4.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    boolean isInserted = (helper.insertOrder(Name.toString(), phone, price, image, Desc, name, Integer.parseInt(binding.textView2.getText().toString())));

                    if (isInserted) {
                        Toast.makeText(DetailActivity.this, "Data Succes", Toast.LENGTH_SHORT).show();
                    } else {
                        Toast.makeText(DetailActivity.this, "Error", Toast.LENGTH_SHORT).show();

                    }

                }
            });

    }
}