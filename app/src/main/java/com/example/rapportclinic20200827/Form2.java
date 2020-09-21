package com.example.rapportclinic20200827;

import android.content.DialogInterface;
import android.graphics.Color;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

public class Form2 extends AppCompatActivity {

    private TextView historyChoice, examinationChoice , historyText, examinationText, historyTitle, examinationTitle;
    private EditText descriptionText;
    private ImageButton sendBtn;
    private String userChoice = null;
    private SoftInputAssist softInputAssist;
    private AlertDialog.Builder builder;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_form2);

        softInputAssist = new SoftInputAssist(this);


        builder = new AlertDialog.Builder(this);
        historyChoice = findViewById(R.id.form2_history_choice);
        examinationChoice = findViewById(R.id.form2_examination_choice);
        historyText = findViewById(R.id.form2_history_text);
        examinationText = findViewById(R.id.form2_examination_text);
        historyTitle = findViewById(R.id.form2_history_title);
        examinationTitle = findViewById(R.id.form2_examination_title);
        descriptionText = findViewById(R.id.form2_description_text);
        sendBtn = findViewById(R.id.form2_send);

        checkForData();


        historyChoice.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                userChoice = "H";
                historyChoice.setTextColor(Color.RED);
                examinationChoice.setTextColor(Color.BLACK);


            }
        });

        examinationChoice.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                userChoice = "E";
                examinationChoice.setTextColor(Color.RED);
                historyChoice.setTextColor(Color.BLACK);

            }
        });

        sendBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String text = descriptionText.getText().toString();

                if(!TextUtils.isEmpty(userChoice) && userChoice.equals("H") && !TextUtils.isEmpty(text)){
                    if(TextUtils.isEmpty(historyText.getText().toString())){
                        historyText.append(text);
                        Toast.makeText(Form2.this, "successfully added!", Toast.LENGTH_SHORT).show();
                    }else{
                        historyText.append("\n"+text);
                        Toast.makeText(Form2.this, "successfully added!", Toast.LENGTH_SHORT).show();
                    }
                    descriptionText.setText("");
                    checkForData();
                }
                if(!TextUtils.isEmpty(userChoice) && userChoice.equals("E") && !TextUtils.isEmpty(text)){
                    if(TextUtils.isEmpty(examinationText.getText().toString())){
                        examinationText.append(text);
                        Toast.makeText(Form2.this, "successfully added!", Toast.LENGTH_SHORT).show();
                    }else{
                        examinationText.append("\n"+text);
                        Toast.makeText(Form2.this, "successfully added!", Toast.LENGTH_SHORT).show();
                    }
                    checkForData();
                    descriptionText.setText("");
                }
            }
        });


        historyText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                editData("History",historyText.getText().toString());
                builder.create().show();
            }
        });

        examinationText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                editData("Examination",examinationText.getText().toString());
                builder.create().show();
            }
        });


    }
    private void editData(String title,String text) {
        LayoutInflater layoutInflater = LayoutInflater.from(Form2.this);
        View view = layoutInflater.inflate(R.layout.layout_edit_dialog,null,false);

        EditText editText = view.findViewById(R.id.edit_dialog_text);
        editText.setText(text);

        builder.setView(view)
                .setTitle(title).setNegativeButton("cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

            }
        }).setPositiveButton("save", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                if(title.equals("History")){
                    historyText.setText(editText.getText().toString());
                }
                else if(title.equals("Examination")){
                    examinationText.setText(editText.getText().toString());
                }
            }
        });

    }

    private void checkForData() {

        String history = historyText.getText().toString();
        if(TextUtils.isEmpty(history)){
            historyTitle.setVisibility(View.GONE);
            historyText.setVisibility(View.GONE);
        }
        else{
            historyTitle.setVisibility(View.VISIBLE);
            historyText.setVisibility(View.VISIBLE);
        }

        String examination = examinationText.getText().toString();
        if(TextUtils.isEmpty(examination)){
            examinationTitle.setVisibility(View.GONE);
            examinationText.setVisibility(View.GONE);
        }else{
            examinationTitle.setVisibility(View.VISIBLE);
            examinationText.setVisibility(View.VISIBLE);
        }
    }

    @Override
    protected void onResume() {
        softInputAssist.onResume();
        super.onResume();
    }

    @Override
    protected void onPause() {
        softInputAssist.onPause();
        super.onPause();
    }

    @Override
    protected void onDestroy() {
        softInputAssist.onDestroy();
        super.onDestroy();
    }

}
