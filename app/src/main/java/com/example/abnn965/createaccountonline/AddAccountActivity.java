package com.example.abnn965.createaccountonline;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class AddAccountActivity extends AppCompatActivity {

    DatabaseHelper myDb;

    private TextView tvIdentityNumber;
    private TextView tvAccountNumber;
    private EditText accountType;
    private EditText accountBalance;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_account);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        myDb = new DatabaseHelper(this);

        tvIdentityNumber = (TextView)findViewById(R.id.tvIdentityNumberAdd);
        tvIdentityNumber.setText(getIntent().getExtras().getString("IdentityNumber"));

        tvAccountNumber = (TextView)findViewById(R.id.tvaccountNumberAdd);
        tvAccountNumber.setText(getIntent().getExtras().getString("AccountNumber"));

        accountBalance = (EditText)findViewById(R.id.edtAccountBalance);
        accountType = (EditText)findViewById(R.id.edtAccountType);
    }

    public void addAccountdetails(View view){

        boolean isInserted = myDb.insertAccountDetails(tvAccountNumber.getText().toString(),
                                                        accountType.getText().toString(),
                                                        new Double(accountBalance.getText().toString()),
                                                        tvIdentityNumber.getText().toString());

        if (isInserted == true){
            Toast.makeText(AddAccountActivity.this, "Successfully added account", Toast.LENGTH_LONG).show();

            Intent addAccountIntent = new Intent(AddAccountActivity.this, SavingsAccountActivity.class);
            startActivity(addAccountIntent);
        }
        else{
            Toast.makeText(AddAccountActivity.this, "Account not registered, try again!!!", Toast.LENGTH_LONG).show();
        }

    }

}
