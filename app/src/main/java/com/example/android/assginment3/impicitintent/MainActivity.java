package com.example.android.assginment3.impicitintent;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.content.Intent;
import android.widget.EditText;
import android.net.Uri;
import android.support.v4.app.ActivityCompat;
import android.Manifest;
import android.content.pm.PackageManager;

public class MainActivity extends AppCompatActivity {


    EditText urlInput;
    EditText phoneNumber;
    private static final int MY_PERMISSIONS_REQUEST_CALL_PHONE = 1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }


    public void launchURL(View v) {
        Intent implicit = null, chooser = null;
        urlInput = (EditText) findViewById(R.id.editTextUrl);
        String url = urlInput.getText().toString();
        implicit = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
        chooser = Intent.createChooser(implicit, "Choose browser of your choice");
        startActivity(chooser);
    }

    public void ringPhone(View v) {
        phoneNumber = (EditText) findViewById(R.id.editTextPhone);
        String phoneNo = phoneNumber.getText().toString();
        Intent implicit = new Intent(Intent.ACTION_CALL, Uri.parse("tel:" + phoneNo));
        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(this,
                    new String[]{Manifest.permission.CALL_PHONE},
                    MY_PERMISSIONS_REQUEST_CALL_PHONE);
        }
        startActivity(implicit);
    }

    public void finishMainActivity(View v){
        MainActivity.this.finish();
    }
}
