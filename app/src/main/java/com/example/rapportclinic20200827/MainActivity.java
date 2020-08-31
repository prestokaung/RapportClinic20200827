package com.example.rapportclinic20200827;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.ActivityOptions;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;

import com.example.rapportclinic20200827.Adaper.CustomAdapter;
import com.mancj.materialsearchbar.MaterialSearchBar;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private RecyclerView mainRecyclerView;
    private MyDataBaseHelper myDb;
    private ArrayList<String> idList,nameList,ageList,genderList,dateList;
    private CustomAdapter customAdapter;
    private MaterialSearchBar materialSearchBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mainRecyclerView = findViewById(R.id.main_recycler_view);
        materialSearchBar = findViewById(R.id.main_searchBar);

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


        materialSearchBar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                goToSearchActivity();
            }
        });

    }

    public void goToAddActivity(View view){
        Intent intent = new Intent(MainActivity.this,AddActivity.class);
        startActivity(intent);
    }


    private void goToSearchActivity(){
        Intent intent = new Intent(MainActivity.this, SearchActivity.class);

        ActivityOptions options = ActivityOptions.makeSceneTransitionAnimation(this,
                materialSearchBar,"searchBar");

        startActivity(intent, options.toBundle());
    }
}
