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

    Random random = new Random();
    String myRandomNumber = "Value (static): " + (random.nextInt(10 - 1) + 1);


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle(getResources().getString(R.string.app_name) + " static");
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        TextView mTextView = findViewById(R.id.tvNumber);

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Counting...", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();

                myRandomNumber = "Value (static): " + (random.nextInt(10 - 1) + 1);
                mTextView.setText(myRandomNumber);
            }
        });

        mTextView.setText(myRandomNumber);
        Log.i(TAG, "Random number set");
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