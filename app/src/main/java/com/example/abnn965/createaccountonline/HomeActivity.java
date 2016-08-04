package com.example.abnn965.createaccountonline;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

public class HomeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
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
    }

    public void nfcActivity(View view){
        Intent nfcIntent = new Intent(HomeActivity.this, NfcPaymentActivity.class);
        startActivity(nfcIntent);

    }

    public void savingsAccount(View view){
        Intent savingsIntent = new Intent(HomeActivity.this, SavingsAccountActivity.class);
        startActivity(savingsIntent);
    }

    public void addAccount(View view){

        Intent addAccountIntent = new Intent(HomeActivity.this, AddAccountActivity.class);
        startActivity(addAccountIntent);
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

        if (id == R.id.home) {
            Intent homeIntent = new Intent(HomeActivity.this, HomeActivity.class);
            startActivity(homeIntent);
        }

        if (id == R.id.savingsAccounts) {
            Intent savingsAccountIntent = new Intent(HomeActivity.this, SavingsAccountActivity.class);
            startActivity(savingsAccountIntent);
        }

        if (id == R.id.transactAccount) {
            Intent homeIntent = new Intent(HomeActivity.this, HomeActivity.class);
            startActivity(homeIntent);
        }

        if (id == R.id.creditAccount) {
            Intent homeIntent = new Intent(HomeActivity.this, HomeActivity.class);
            startActivity(homeIntent);
        }
        if (id == R.id.chequeAccount) {
            Intent homeIntent = new Intent(HomeActivity.this, HomeActivity.class);
            startActivity(homeIntent);
        }

        return super.onOptionsItemSelected(item);
    }
}
