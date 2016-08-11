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
import android.widget.EditText;
import android.widget.TextView;

import org.w3c.dom.Text;

public class AirtimeActivity extends AppCompatActivity {

    SQLiteDatabase myDb;
    DatabaseHelper dbH;

    private TextView tvBalance;
    private EditText edtAirtimeValue;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_airtime);
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
        tvBalance = (TextView)findViewById(R.id.tvBalance2);
        edtAirtimeValue = (EditText)findViewById(R.id.edtAirtimeAmount);
        tvBalance.setText(getIntent().getExtras().getString("Balance"));


    }

    public void buyAirtime(View view){

        double balance;
        balance = Double.parseDouble(tvBalance.getText().toString()) - Double.parseDouble(edtAirtimeValue.getText().toString());
        tvBalance.setText(""+ balance);

        //Gowing through database then select balance matching certain user and account type
        /*final String TABLE_NAME = " account_table";
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
                double bal = new Double(tvBalance.getText().toString());
                double airtimeValue = new Double(edtAirtimeValue.getText().toString());
                balance = bal - airtimeValue;
                tvBalance.setText(Double.toString(balance));
                edtAirtimeValue.setText("");
            }
        }*/
    }

    public void back(View view){
        Intent backIntent = new Intent(AirtimeActivity.this, SavingsAccountActivity.class);
        startActivity(backIntent);
    }

}
