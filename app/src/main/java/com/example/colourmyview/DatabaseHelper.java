package com.example.colourmyview;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DatabaseHelper extends SQLiteOpenHelper {
    public DatabaseHelper(Context context) {
        super(context, "Anydata.db", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table AnyDetails(name TEXT primary key,contact TEXT,dob TEXT)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("drop table if exists AnyDetails");
    }

    public boolean insertAnyData(String name,String contact,String dob){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("name",name);
        contentValues.put("contact",contact);
        contentValues.put("dob",dob);
        long result = db.insert("AnyDetails",null,contentValues);

        if (result==-1)
            return false;
        else
            return true;
    }

    public boolean updateAnyData(String name,String contact,String dob){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("contact",contact);
        contentValues.put("dob",dob);

        Cursor cursor = db.rawQuery("select * from AnyDetails where name=?",new String[]{name});
        if (cursor.getCount()>0) {

            long result = db.update("AnyDetails", contentValues, "name=?", new String[]{name});

            if (result == -1)
                return false;
            else
                return true;
        }
        else
            return false;
    }

    public boolean deleteAnyData(String name){
        SQLiteDatabase db = this.getWritableDatabase();

        Cursor cursor = db.rawQuery("select * from AnyDetails where name=?",new String[]{name});
        if (cursor.getCount()>0) {

            long result = db.delete("AnyDetails", "name=?", new String[]{name});

            if (result == -1)
                return false;
            else
                return true;
        }
        else
            return false;
    }

    public Cursor getAnyData(){
        SQLiteDatabase db = this.getWritableDatabase();

        Cursor cursor = db.rawQuery("select * from AnyDetails",null);
        return cursor;
    }
}
