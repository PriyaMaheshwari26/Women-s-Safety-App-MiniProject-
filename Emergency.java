package com.example.bsafeapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class Emergency extends AppCompatActivity {
    private static final int REQUEST_CALL = 1;
    private TextView call_amb, call_women, call_emer;
    private Button btn_Amb, btn_women, btn_emer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_emergency);
        call_amb = findViewById(R.id.call_amb);
        call_women = findViewById(R.id.call_women);
        call_emer = findViewById(R.id.call_emer);
        btn_Amb = findViewById(R.id.btn_amb);
        btn_women = findViewById(R.id.btn_women);
        btn_emer = findViewById(R.id.btn_emer);

        btn_Amb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                callButton();
            }
        });
        btn_emer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                callButtonWomen();
            }
        });
        btn_emer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                callButtonEmer();
            }
        });
    }

    private void callButtonEmer() {
        String number = call_emer.getText().toString();
        if (number.trim().length() > 0) {
            if (ContextCompat.checkSelfPermission(Emergency.this, Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
                ActivityCompat.requestPermissions(Emergency.this, new String[]{Manifest.permission.CALL_PHONE}, REQUEST_CALL);
            } else {
                String dial = "tel:" + number;
                startActivity(new Intent(Intent.ACTION_CALL, Uri.parse(dial)));
            }
        }
    }
    private void callButtonWomen() {
        String number = call_women.getText().toString();
        if (number.trim().length() > 0) {
            if (ContextCompat.checkSelfPermission(Emergency.this, Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
                ActivityCompat.requestPermissions(Emergency.this, new String[]{Manifest.permission.CALL_PHONE}, REQUEST_CALL);
            } else {
                String dial = "tel:" + number;
                startActivity(new Intent(Intent.ACTION_CALL, Uri.parse(dial)));
            }
        }
    }


    private void callButton() {
        String number = call_amb.getText().toString();
        if (number.trim().length() > 0) {
            if (ContextCompat.checkSelfPermission(Emergency.this, Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
                ActivityCompat.requestPermissions(Emergency.this, new String[]{Manifest.permission.CALL_PHONE}, REQUEST_CALL);
            } else {
                String dial = "tel:" + number;
                startActivity(new Intent(Intent.ACTION_CALL, Uri.parse(dial)));
            }
        }
    }

    @SuppressLint("MissingSuperCall")
    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        if (requestCode == REQUEST_CALL) {
            if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                callButton();
                callButtonEmer();
                callButtonWomen();
            } else {
                Toast.makeText(this, "Permission Denied", Toast.LENGTH_SHORT).show();

            }
        }
    }
}