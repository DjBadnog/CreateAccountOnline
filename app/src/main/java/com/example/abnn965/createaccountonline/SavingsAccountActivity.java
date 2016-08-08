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
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class SavingsAccountActivity extends AppCompatActivity {

    SQLiteDatabase myDb;
    DatabaseHelper dbH;

    private TextView tvBalance;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_savings_account);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        dbH = new DatabaseHelper(this);
        tvBalance = (TextView) findViewById(R.id.txtBalance);

        //Gowing through database then select balance matching certain user and account type
        final String TABLE_NAME = " account_table";
        String selectQuery = "SELECT * FROM " + TABLE_NAME;
        myDb = dbH.getReadableDatabase();
        Cursor cursor = myDb.rawQuery(selectQuery, null);

        while (cursor.moveToNext()) {
            String id = cursor.getString(0);
            String accountNumber = cursor.getString(1);
            String accountType = cursor.getString(2);
            double balance = cursor.getDouble(3);
            String idNumber = cursor.getString(4);

            if (accountNumber.equals("123456789") && accountType.equals("Savings Account")) {
                tvBalance.setText("" + balance);
            }
        }
    }

    public void airtime(View view){
        Intent airtimeIntent = new Intent(SavingsAccountActivity.this, AirtimeActivity.class);
        startActivity(airtimeIntent);
    }

}
