package com.example.myapplication.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication.MainActivity;
import com.example.myapplication.Models.MainModel;
import com.example.myapplication.R;

import java.util.ArrayList;

public class MainAdapter extends RecyclerView.Adapter<MainAdapter.viewholder> {
    @NonNull
    ArrayList <MainModel> list;
    Context context;

    public MainAdapter(ArrayList<MainModel> list, MainActivity mainActivity) {
    }


    @Override
    public viewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(context).inflate(R.layout.sample_mainpharmacy,parent,false);
        return new viewholder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull viewholder holder, int position) {
final MainModel model=list.get(position);
holder.medimage.setImageResource(model.getImage());
holder.price.setText(model.getPrice());
holder.description.setText(model.getDescription());
holder.mainName.setText(model.getName());
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class viewholder extends RecyclerView.ViewHolder {
        ImageView medimage;
        TextView mainName, price,description;
        public viewholder(@NonNull View itemView) {
            super(itemView);
            medimage=itemView.findViewById(R.id.medimage);
            mainName=itemView.findViewById(R.id.name);
            price=itemView.findViewById(R.id.price);
            description=itemView.findViewById(R.id.desc);

        }
    }
}
