package com.example.abnn965.createaccountonline;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Toast;

import java.io.File;

public class RegisterAccountActivity extends AppCompatActivity {

    private File imageFile;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register_account);

    }

    public void selfiePicture(View view){

        Intent pictureIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        imageFile = new File(Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_PICTURES), "selfie.jpg");
        Uri tempUri = Uri.fromFile(imageFile);
        pictureIntent.putExtra(MediaStore.EXTRA_OUTPUT, tempUri);
        pictureIntent.putExtra(MediaStore.EXTRA_VIDEO_QUALITY, 1);
        startActivityForResult(pictureIntent, 0);

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {

        if(requestCode == 0){
            switch (requestCode){
                case Activity.RESULT_OK:
                    if (imageFile.exists()){
                        Toast.makeText(this, "The file was saved at" + imageFile.getAbsolutePath(), Toast.LENGTH_LONG).show();
                    }
                    break;
                case Activity.RESULT_CANCELED:
                    Toast.makeText(this, "Error in saving file", Toast.LENGTH_LONG).show();
                    break;
            }
        }
    }

}
