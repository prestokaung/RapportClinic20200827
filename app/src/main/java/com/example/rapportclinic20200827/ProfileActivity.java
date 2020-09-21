package com.example.rapportclinic20200827;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class ProfileActivity extends AppCompatActivity {

    private TextView nameTv,ageGenderTv, sulphurTv;
    private Intent getIntent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);


        getIntent = getIntent();


        nameTv = findViewById(R.id.profile_name);
        ageGenderTv =findViewById(R.id.profile_age);

        if(getIntent.hasExtra("name") && getIntent.hasExtra("age") &&getIntent.hasExtra("gender")){
            nameTv.setText(getIntent.getStringExtra("name"));
            ageGenderTv.setText(getIntent.getStringExtra("age")+" YO, "+ getIntent.getStringExtra("gender"));
        }



    }

    public void profileAddNewVisitor(View view){
        Intent intent = new Intent(ProfileActivity.this,Form2.class);
        startActivity(intent);
    }
}
