package com.example.ui_new;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class QueueReady extends AppCompatActivity {

    AppCompatButton cancel, modify;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate ( savedInstanceState );
        setContentView ( R.layout.activity_queue_ready );

        cancel = findViewById ( R.id.QR_cancel );
        modify = findViewById ( R.id.QR_modify );

        cancel.setOnClickListener ( new View.OnClickListener () {
            @Override
            public void onClick(View view) {

            }
        } );

        modify.setOnClickListener ( new View.OnClickListener () {
            @Override
            public void onClick(View view) {

                startActivity ( new Intent ( QueueReady.this, MainActivity.class) );
            }
        } );
    }
}