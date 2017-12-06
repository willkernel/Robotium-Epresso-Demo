package com.willkernel.app.robotinumdemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class WelcomeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);
        TextView welcomeTv = findViewById(R.id.welcomeTv);
        welcomeTv.setText(getString(R.string.hello_s, getIntent().getStringExtra("name")));
    }
}
