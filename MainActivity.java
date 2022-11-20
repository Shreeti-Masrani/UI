package com.example.ui_new;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.content.Intent;
import android.icu.text.SimpleDateFormat;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Adapter;
import android.widget.ArrayAdapter;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TimePicker;

import java.util.Calendar;
import java.util.Locale;

public class MainActivity extends AppCompatActivity {

    EditText editText;
    AppCompatButton book_now;
    Spinner spinner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate ( savedInstanceState );
        setContentView ( R.layout.activity_main );

        editText = findViewById ( R.id.date_picker );
        book_now = findViewById ( R.id.bookNow );
        spinner = findViewById ( R.id.spinner );

        editText.setKeyListener ( null );


        String table[] = { "Opt1", "Opt2", "Opt3", "Opt4"};
        ArrayAdapter<String> adapter;

        adapter = new ArrayAdapter<String> ( MainActivity.this, android.R.layout.simple_dropdown_item_1line, table);
        adapter.setDropDownViewResource ( android.R.layout.simple_dropdown_item_1line );
        spinner.setAdapter ( adapter );
        editText.setOnClickListener ( new View.OnClickListener () {
            @Override
            public void onClick(View view) {
                Calendar time = Calendar.getInstance();
                int hour = time.get(Calendar.HOUR_OF_DAY);
                int minute = time.get(Calendar.MINUTE);

                TimePickerDialog TimePicker;
                TimePicker = new TimePickerDialog(MainActivity.this, new TimePickerDialog.OnTimeSetListener() {
                    @Override
                    public void onTimeSet(TimePicker timePicker, int selectedHour, int selectedMinute) {
                        editText.setText( selectedHour + ":" + selectedMinute );
                    }
                }, hour, minute, true);
                TimePicker.setTitle("Select Time");
                TimePicker.show();

            }
        } );
       book_now.setOnClickListener ( new View.OnClickListener () {
           @Override
           public void onClick(View view) {
                startActivity ( new Intent (MainActivity.this, display_book.class) );

           }
       } );
    }
}