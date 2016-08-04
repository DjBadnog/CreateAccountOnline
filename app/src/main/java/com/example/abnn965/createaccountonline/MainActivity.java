package com.example.abnn965.createaccountonline;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {



    private EditText accountNumber;
    private EditText password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        accountNumber = (EditText) findViewById(R.id.edtAccountNumber);
        password = (EditText) findViewById(R.id.edtPassword);

    }

    //Method to navigate to Login screen
    public void register(View view){
        Intent registerIntent = new Intent(MainActivity.this, RegisterAccountActivity.class);
        startActivity(registerIntent);
    }

    //Method to login
    public void login(View view){

        if(accountNumber.getText().toString().equals("123456789") && password.getText().toString().equals("12345")){
            Intent loginIntent = new Intent(MainActivity.this, HomeActivity.class);
            startActivity(loginIntent);
            Toast.makeText(getApplication(), "Login Successful", Toast.LENGTH_SHORT).show();
        }
        else{
            Toast.makeText(getApplication(), "Account or password dont match", Toast.LENGTH_LONG).show();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
