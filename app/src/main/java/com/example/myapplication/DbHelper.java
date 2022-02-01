package com.example.myapplication;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.provider.ContactsContract;

import androidx.annotation.Nullable;

import com.example.myapplication.Models.OrdersModel;

import java.util.ArrayList;

public class DbHelper extends SQLiteOpenHelper {
final static String DBNAME="mydatabasenew.db";
final static int DBVERSION=1;

    public DbHelper(@Nullable Context context) {
        super(context, DBNAME, null, DBVERSION);
    }


    @Override
    public void onCreate(SQLiteDatabase db) {
db.execSQL(
        "create table Foodtab" +
                "(id integer primary key autoincrement," +
                "name text," +
                "phone text, "+
                "price int, " +
                "quantity int, " +
                "image int , " +
                "description text, " +
                "foodname text)"



);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
db.execSQL("DROP table if exists ordersFood");
onCreate(db);
    }

    public boolean insertOrder(String name, String phone, int price, int image, String desc, String Foodname, int quantity){
        SQLiteDatabase db=getReadableDatabase();
        ContentValues values=new ContentValues();
        values.put("name",name );
        values.put("phone",phone );
        values.put("price",price );
        values.put("image",image );
        values.put("quantity",quantity );

        values.put("description",desc );
        values.put("foodname",Foodname );

        long id=db.insert("ordersFood",null,values);
        if(id<=0){
            return false;
        }
        return true;

    }

    public ArrayList<OrdersModel> getorderslist() {
        ArrayList<OrdersModel> orders = new ArrayList<>();
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery("Select id,foodname,image,price from ordersFood",null);
        if(cursor.moveToFirst()){
            while(cursor.moveToNext()){
                OrdersModel model=new OrdersModel();
                model.setOrderNumber(cursor.getInt(0)+"");
                model.setSolditemname(cursor.getString(1));
                model.setOrderimage(cursor.getInt(2));
                model.setPrice(cursor.getString(3)+"");
                orders.add(model);
            }
        }

        return orders;
    }

    public Cursor getorderbyid(int id){
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery("Select * from ordersFood where id="+id,null);
        if(cursor!=null)
            cursor.moveToFirst();
        // cursor.close();
        // db.close();
        return cursor;

    }

    public boolean updateOrder( int price,int image,String desc, String Foodname,int quantity,int id){
        SQLiteDatabase db=getReadableDatabase();
        ContentValues values=new ContentValues();

        values.put("price",price );
        values.put("image",image );
        values.put("quantity",quantity );

        values.put("description",desc );
        values.put("foodname",Foodname );
        long row=db.update("ordersFood",values,"id="+id,null);
        if(row<=0){
            return false;
        }
        return true;

    }

    public boolean deleteOrder(int id){
        SQLiteDatabase db=getReadableDatabase();
        ContentValues values=new ContentValues();

        long row=db.delete("ordersFood","where id=" + id ,null);
        if(row<=0){
            return false;
        }
        return true;

    }

}
