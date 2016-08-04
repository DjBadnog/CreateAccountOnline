package com.example.abnn965.createaccountonline;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.io.File;

public class RegisterAccountActivity extends AppCompatActivity {

    DatabaseHelper myDb;

    private Button submit;
    private EditText name;
    private EditText surname;
    private EditText identityNumber;
    private EditText email;
    private EditText phoneNumber;
    private EditText address;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register_account);

        myDb = new DatabaseHelper(this);

        submit = (Button) findViewById(R.id.btnSubmitPersonalDetails);
        name = (EditText)findViewById(R.id.edtName);
        surname = (EditText)findViewById(R.id.edtSurname);
        email = (EditText)findViewById(R.id.edtEmail);
        phoneNumber = (EditText)findViewById(R.id.edtPhoneNumber);
        address = (EditText)findViewById(R.id.edtPostalAddress);

        //checkFields();

    }

    //Function to disable button if fields doesnt have value
    public void checkFields() {

        if (!submit.getText().toString().isEmpty() &&
                !name.getText().toString().isEmpty() &&
                !surname.getText().toString().isEmpty() &&
                !email.getText().toString().isEmpty() &&
                !phoneNumber.getText().toString().isEmpty() &&
                !address.getText().toString().isEmpty()) {

            submit.setEnabled(true);
        } else {
            submit.setEnabled(false);
        }

    }

    public void captureDocuments(View view){

            Intent captureDocs = new Intent(RegisterAccountActivity.this, CaptureDocumentsActivity.class);
            startActivity(captureDocs);
    }





}
