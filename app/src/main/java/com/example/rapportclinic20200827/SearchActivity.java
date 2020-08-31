package com.example.rapportclinic20200827;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.inputmethod.InputMethodManager;

import com.mancj.materialsearchbar.MaterialSearchBar;

import static android.content.Context.*;

public class SearchActivity extends AppCompatActivity {

    private MaterialSearchBar materialSearchBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);

        materialSearchBar = findViewById(R.id.search_searchBar);



        materialSearchBar.requestFocus();
        InputMethodManager imm = (InputMethodManager) getSystemService(INPUT_METHOD_SERVICE);
        imm.showSoftInput(materialSearchBar, InputMethodManager.SHOW_IMPLICIT);


    }
}
