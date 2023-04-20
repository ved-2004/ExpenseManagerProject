package com.example.expensemanagementproject;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;

public class Setting extends Activity {
    RelativeLayout relativeLayout;

    @Override
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.settings);

        Button btnBack = (Button) findViewById(R.id.btn_settings_back);
        Button editExpense = (Button) findViewById(R.id.btn_settings_editExp);
        Button addCategory = (Button) findViewById(R.id.btn_settings_addCat);

        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        editExpense.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getApplicationContext(),Update_AddExpense.class);
                startActivity(i);
            }
        });

        addCategory.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getApplicationContext(),Tab1.class);
                startActivity(i);
            }
        });
    }
}
