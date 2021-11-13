package com.application.mentalhealth.justforPractice;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.widget.TextView;

import com.application.mentalhealth.R;

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

    private void delete(){
        AlertDialog.Builder builder=new AlertDialog.Builder(PracticeActivity.this);
        builder.setTitle("Delete");
        builder.setMessage("Do you really want to delete the habit ?");
        builder.setCancelable(false);
        builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {

                   // viewModel.deleteHabitsInfo(habitItems);

            }
        });
        builder.setNegativeButton("No", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.dismiss();
            }
        });
        builder.create().show();
    }
}