package com.example.ui_new;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.text.InputType;
import android.view.View;
import android.widget.EditText;

public class Queue extends AppCompatActivity {

    AppCompatButton cancle, modify, view;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate ( savedInstanceState );
        setContentView ( R.layout.activity_queue );

        cancle = findViewById ( R.id.queue_cancel );
        modify = findViewById ( R.id.queue_modify );
        view = findViewById ( R.id.viewPage );

        cancle.setOnClickListener ( new View.OnClickListener () {
            @Override
            public void onClick(View view) {

                AlertDialog.Builder alertDialog = new AlertDialog.Builder ( Queue.this);
                alertDialog.setTitle ( "Reason for Cancelling.." );

                EditText reasonEdit = new EditText ( Queue.this );
                alertDialog.setView ( reasonEdit );

                alertDialog.setPositiveButton ( "Submit", new DialogInterface.OnClickListener () {
                    @Override
                    public void onClick(DialogInterface dialogInterface , int i) {
                         String text = reasonEdit.getText ().toString ();
                         startActivity ( new Intent (Queue.this, Cancelled.class) );
                    }
                } );

                alertDialog.setNegativeButton ( "Cancel", new DialogInterface.OnClickListener () {
                    @Override
                    public void onClick(DialogInterface dialogInterface , int i) {
                        dialogInterface.cancel ();
                    }
                } );
                alertDialog.show ();
            }
        } );

        modify.setOnClickListener ( new View.OnClickListener () {
            @Override
            public void onClick(View view) {

                startActivity ( new Intent (Queue.this, MainActivity.class) );
            }
        } );

        view.setOnClickListener ( new View.OnClickListener () {
            @Override
            public void onClick(View view) {

                startActivity ( new Intent (Queue.this, QueueReady.class) );

            }
        } );

    }
}