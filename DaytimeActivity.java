package com.example.myapplication;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.RadioGroup;
import android.widget.RadioButton;

public class DaytimeActivity extends Activity {

    // Context to be used in the next activity
    public static android.content.Context DayContext;

    RadioButton rdoCal, rdoTime;
    DatePicker dPicker;
    TimePicker tPicker;
    TextView tvYear, tvMonth, tvDay, tvHour, tvMinute;
    Button btnDayOk, btnToTable;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.daytime);
        setTitle("예약 날짜 시간 선택");

        // Initialize context
        DayContext = this;

        // Initialize RadioButtons
        rdoCal = findViewById(R.id.radioCal);

        // Initialize Views
        dPicker = findViewById(R.id.datePicker1);
        tPicker = findViewById(R.id.timePicker1);
        tvYear = findViewById(R.id.tvYear);
        tvMonth = findViewById(R.id.tvMonth);
        tvDay = findViewById(R.id.tvDay);

        // Set initial visibility
        tPicker.setVisibility(View.INVISIBLE);
        dPicker.setVisibility(View.INVISIBLE);

        // Add these imports if not already present

// Inside your DaytimeActivity class


        // Set click listeners for RadioButtons
        rdoCal.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                tPicker.setVisibility(View.INVISIBLE);
                dPicker.setVisibility(View.VISIBLE);
            }
        });

        rdoTime.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                tPicker.setVisibility(View.VISIBLE);
                dPicker.setVisibility(View.INVISIBLE);
            }
        });

        btnDayOk = findViewById(R.id.BtnDayOk);
        btnDayOk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tvYear.setText(Integer.toString(dPicker.getYear()));
                tvMonth.setText(Integer.toString(1 + dPicker.getMonth()));
                tvDay.setText(Integer.toString(dPicker.getDayOfMonth()));
            }
        });

        btnToTable = findViewById(R.id.BtnToTable);
        btnToTable.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Go to the next activity
                Intent intent = new Intent(DaytimeActivity.this, TableActivity.class);
                startActivity(intent);
            }
        });
    }
}
