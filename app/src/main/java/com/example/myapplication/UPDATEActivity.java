package com.example.myapplication;


import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.example.myapplication.databinding.ActivityDetailBinding;
import com.example.myapplication.databinding.ActivityUpdateactivityBinding;

public class UPDATEActivity extends AppCompatActivity {
@NonNull
 ActivityUpdateactivityBinding binding;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityUpdateactivityBinding.inflate(getLayoutInflater());
        //setContentView(R.layout.activity_detail);
        setContentView(binding.getRoot());
        final DbHelper helper = new DbHelper(this);

        final int id = getIntent().getIntExtra("id", 0);

        Cursor cursor=helper.getorderbyid(id);
          final int image=cursor.getInt(5);


       Toast.makeText(UPDATEActivity.this, cursor.getString(0), Toast.LENGTH_SHORT).show();


        binding.textView7.setText(String.format("%d", cursor.getInt(3)));
        binding.textView2.setText(cursor.getString(4));
        binding.detailimage.setImageResource(cursor.getInt(5));
        binding.textView3.setText(cursor.getString(6));
        binding.textView.setText(cursor.getString(7));


        binding.button4.setText("Update Now");







        binding.button4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                boolean isupdate=
                        helper.updateOrder(

                                Integer.parseInt(binding.textView7.toString()),
                                image,
                                binding.textView3.getText().toString(),
                                binding.textView.getText().toString(),
                                1,
                                id

                        );
                if(isupdate){
                    Toast.makeText(UPDATEActivity.this, "update done", Toast.LENGTH_SHORT).show();

                }




            }
        });



        binding.Delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                boolean isdelete = helper.deleteOrder(id);




                if(isdelete){
                    Toast.makeText(UPDATEActivity.this, "Deleted done", Toast.LENGTH_SHORT).show();

                }




            }
        });





    }
}