package com.application.justforPractice;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.app.Dialog;
import android.app.TimePickerDialog;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.TimePicker;

import com.application.mentalhealth.R;
import com.google.android.material.tabs.TabLayout;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class PracticeActivity extends AppCompatActivity {

    private TextView timeSet;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_practice);
        timeSet=findViewById(R.id.setTime);


//        TimePickerDialog timePickerDialog=new TimePickerDialog(this, R.style.Theme_AppCompat_Dialog, new TimePickerDialog.OnTimeSetListener() {
//            @Override
//            public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
//                Calendar calendar=Calendar.getInstance();
//                calendar.set(Calendar.HOUR_OF_DAY,hourOfDay);
//                calendar.set(Calendar.MINUTE,minute);
//                SimpleDateFormat format=new SimpleDateFormat("k:mm a");
//                String time=format.format(calendar.getTime());
//                timeSet.setText(time);
//            }
//        },hours,mins,false);

    }
}