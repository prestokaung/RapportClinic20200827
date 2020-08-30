package com.example.rapportclinic20200827;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.ActionBar;
import android.app.Dialog;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.TextView;

import com.example.rapportclinic20200827.Adaper.CustomAdapter;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private RecyclerView mainRecyclerView;
    private MyDataBaseHelper myDb;
    private ArrayList<String> idList,nameList,ageList,genderList,dateList;
    private CustomAdapter customAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mainRecyclerView = findViewById(R.id.main_recycler_view);

        myDb = new MyDataBaseHelper(this);

        idList = new ArrayList<>();
        nameList = new ArrayList<>();
        ageList = new ArrayList<>();
        genderList = new ArrayList<>();
        dateList = new ArrayList<>();

        customAdapter = new CustomAdapter(this,
                idList,
                nameList,
                ageList,
                genderList,
                dateList);

        Cursor cursor = myDb.readData();

        while (cursor.moveToNext()) {
            idList.add(cursor.getString(0));
            nameList.add(cursor.getString(1));
            ageList.add(cursor.getString(2));
            genderList.add(cursor.getString(3));
            dateList.add(cursor.getString(4));
        }

        mainRecyclerView.setHasFixedSize(true);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this, RecyclerView.VERTICAL, false);
        mainRecyclerView.setLayoutManager(linearLayoutManager);
        mainRecyclerView.setAdapter(customAdapter);

    }

    public void goToAddActivity(View view){
        Intent intent = new Intent(MainActivity.this,AddActivity.class);
        startActivity(intent);
    }
}
