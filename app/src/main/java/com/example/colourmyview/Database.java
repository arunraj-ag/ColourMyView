package com.example.colourmyview;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Database extends AppCompatActivity {

    EditText name,contact,dob;
    Button insert,update,delete,view;
    DatabaseHelper db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_database);

        name = findViewById(R.id.name);
        contact = findViewById(R.id.contact);
        dob = findViewById(R.id.DOB);

        insert = findViewById(R.id.insert_btn);
        update = findViewById(R.id.update_btn);
        delete = findViewById(R.id.delete_btn);
        view = findViewById(R.id.view_btn);

        db = new DatabaseHelper(this);

    }
    public void insert_db(View v){
        String nameTxt = name.getText().toString();
        String contactTxt = contact.getText().toString();
        String dobTxt = dob.getText().toString();

        Boolean checkinsertData = db.insertAnyData(nameTxt,contactTxt,dobTxt);
        if (checkinsertData==true){
            Toast.makeText(this, "New Data is Inserted", Toast.LENGTH_SHORT).show();
        }
        else
            Toast.makeText(this, "New Entry Failed", Toast.LENGTH_SHORT).show();
    }

    public void update_db(View v){
        String nameTxt = name.getText().toString();
        String contactTxt = contact.getText().toString();
        String dobTxt = dob.getText().toString();

        Boolean checkupdateData = db.updateAnyData(nameTxt,contactTxt,dobTxt);
        if (checkupdateData==true){
            Toast.makeText(this, "Data is Updated", Toast.LENGTH_SHORT).show();
        }
        else
            Toast.makeText(this, "Data Updation Failed", Toast.LENGTH_SHORT).show();
    }

    public void delete_db(View v){
        String nameTxt = name.getText().toString();
        Boolean checkdeleteData = db.deleteAnyData(nameTxt);
        if (checkdeleteData==true){
            Toast.makeText(this, "Data is Deleted", Toast.LENGTH_SHORT).show();
        }
        else
            Toast.makeText(this, "Data Deletion Failed", Toast.LENGTH_SHORT).show();
    }

    public void view_db(View v){
        Cursor res = db.getAnyData();
        if(res.getCount()==0){
            Toast.makeText(this, "No Entry Exists", Toast.LENGTH_SHORT).show();
            return;
        }
        StringBuffer buffer = new StringBuffer();
        while (res.moveToNext()){
            buffer.append("Name :"+res.getString(0)+"\n");
            buffer.append("Contact :"+res.getString(1)+"\n");
            buffer.append("DOB :"+res.getString(2)+"\n\n");
        }
        AlertDialog.Builder builder = new AlertDialog.Builder(Database.this);
        builder.setCancelable(true);
        builder.setTitle("User Entries");
        builder.setMessage(buffer.toString());
        builder.show();

    }
}