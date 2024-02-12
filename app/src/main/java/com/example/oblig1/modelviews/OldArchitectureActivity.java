package com.example.oblig1.modelviews;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import java.util.Random;

public class OldArchitectureActivity extends AppCompatActivity {

    private String TAG = this.getClass().getSimpleName();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        TextView mTextView = findViewById(R.id.tvNumber);
        Log.i(TAG, "Create new number");
        Random random = new Random();
        String myRandomNumber = "Number: " + (random.nextInt(10 - 1) + 1);
        mTextView.setText(myRandomNumber);

        Log.i(TAG, "Random Number Set");
    }

    @Override
    public void onStop() {
        super.onStop();

        Log.i(TAG, "Stopping Activity");
    }

    @Override
    public void onDestroy() {

        super.onDestroy();

        Log.i(TAG, "Destroying Activity");
    }
}