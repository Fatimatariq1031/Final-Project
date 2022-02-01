package com.example.myapplication.Adapters;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication.DetailActivity;
import com.example.myapplication.Models.OrdersModel;
import com.example.myapplication.R;
import com.example.myapplication.UPDATEActivity;

import java.util.ArrayList;

public class OrdersAdapter extends  RecyclerView.Adapter<OrdersAdapter.viewholder>{

Context context;

    public OrdersAdapter(Context context, ArrayList<OrdersModel> list) {
        this.context = context;
        this.list = list;
    }

    ArrayList<OrdersModel> list;
    @NonNull
    @Override
    public viewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(context).inflate(R.layout.order_sample,parent,false);
        return new viewholder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull viewholder holder, int position) {
final OrdersModel model= list.get(position);
holder.orderImage.setImageResource(model.getOrderimage());
holder.ordernumber.setText(model.getOrderNumber());
holder.solditemname.setText(model.getSolditemname());
holder.price.setText(model.getPrice());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent =new Intent(context, UPDATEActivity.class);
                intent.putExtra("id",Integer.parseInt(model.getOrderNumber()));

                context.startActivity(intent);


            }
        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class viewholder extends RecyclerView.ViewHolder{

        ImageView orderImage;
        TextView solditemname,ordernumber,price;

        public viewholder(@NonNull View itemView) {
            super(itemView);
            orderImage=itemView.findViewById(R.id.imageView2);
            solditemname=itemView.findViewById(R.id.orderitemname);
            price=itemView.findViewById(R.id.textView11);
            ordernumber=itemView.findViewById(R.id.textView5);
        }
    }
}
