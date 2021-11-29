package com.example.bsafeapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.GridLayout;

public class Dashboard extends AppCompatActivity {
    GridLayout gridLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);
        gridLayout=(GridLayout)findViewById(R.id.gridLayoutHome);
        setSingleEvent();
    }

    private void setSingleEvent() {
        for (int i = 0; i<gridLayout.getChildCount(); i++) {
            CardView cardView = (CardView) gridLayout.getChildAt(i);
            final int finalI = i;
            cardView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (finalI == 0) {
                        Intent intent = new Intent(Dashboard.this, RegisterDash.class);
                        startActivity(intent);

                    } else if (finalI == 1) {
                        Intent intent = new Intent(Dashboard.this, CallPolice.class);
                        startActivity(intent);

                    } else if (finalI == 2) {
                        Intent intent = new Intent(Dashboard.this, Emergency.class);
                        startActivity(intent);

                    }
                }

            });
        }

    }
}