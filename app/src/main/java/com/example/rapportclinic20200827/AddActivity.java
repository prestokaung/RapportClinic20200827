package com.example.rapportclinic20200827;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

public class AddActivity extends AppCompatActivity {

    private EditText name,age,gender;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add);

        name = findViewById(R.id.add_name);
        age = findViewById(R.id.add_age);
        gender = findViewById(R.id.add_gender);
    }

    public void addData(View view){
        String nameS, ageS, genderS;

        nameS = name.getText().toString();
        ageS = age.getText().toString();
        genderS = gender.getText().toString();


        if (TextUtils.isEmpty(nameS) ||
                TextUtils.isEmpty(ageS) ||
                TextUtils.isEmpty(genderS)) {
            Toast.makeText(this, "Please Enter all Fields", Toast.LENGTH_SHORT).show();
        }
        else{
            Date c = Calendar.getInstance().getTime();
            SimpleDateFormat dateformat = new SimpleDateFormat("dd-MMM-yyyy", Locale.getDefault());
            String formattedDateString = dateformat.format(c);


            MyDataBaseHelper myDB = new MyDataBaseHelper(AddActivity.this);
            myDB.addData(nameS,ageS,genderS,formattedDateString);

            name.setText("");
            age.setText("");
            gender.setText("");

            Intent intent = new Intent(AddActivity.this,MainActivity.class);
            intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
            startActivity(intent);

        }
    }

}
