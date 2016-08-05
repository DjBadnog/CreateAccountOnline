package com.example.abnn965.createaccountonline;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
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

    SQLiteDatabase myDb;
    DatabaseHelper dbH;

    private EditText accountNumber;
    private EditText password;
    private EditText identityNumber;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        accountNumber = (EditText) findViewById(R.id.edtAccountNumber);
        password = (EditText) findViewById(R.id.edtPassword);
        identityNumber = (EditText)findViewById(R.id.edtIdentityNumber);

        dbH = new DatabaseHelper(this);

    }

    //Method to navigate to Login screen
    public void register(View view){
        Intent registerIntent = new Intent(MainActivity.this, RegisterAccountActivity.class);
        startActivity(registerIntent);
    }

    //Method to login
    public void login(View view){

        final String TABLE_NAME = " customer_table";
        String selectQuery = "SELECT * FROM " + TABLE_NAME;
        myDb = dbH.getReadableDatabase();
        Cursor cursor = myDb.rawQuery(selectQuery, null);

        while(cursor.moveToNext()){
            String id = cursor.getString(0);
            String name = cursor.getString(1);
            String surname = cursor.getString(2);
            String identityNumberDB = cursor.getString(3);
            String phoneNumber = cursor.getString(4);
            String postalAddress = cursor.getString(5);
            String email = cursor.getString(6);

            //Toast.makeText(this, "ID: "+ id + " name: "+name+" surname "+ surname + " idNumber "+ identityNumber + " phone "+ phoneNumber + " postal "+ postalAddress + " email "+ email, Toast.LENGTH_LONG).show();
            if(accountNumber.getText().toString().equals("123456789") && password.getText().toString().equals("12345") && identityNumber.getText().toString().equals(identityNumberDB) ){
                Intent loginIntent = new Intent(MainActivity.this, HomeActivity.class);
                loginIntent.putExtra("AccountNumber",accountNumber.getText().toString());
                loginIntent.putExtra("IdentityNumber", identityNumber.getText().toString());
                startActivity(loginIntent);
                Toast.makeText(getApplication(), "Login Successful", Toast.LENGTH_SHORT).show();
            }
            else{
                //Toast.makeText(getApplication(), "Account or password dont match", Toast.LENGTH_LONG).show();
            }

        }cursor.close();


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
