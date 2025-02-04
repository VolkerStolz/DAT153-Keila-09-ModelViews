package com.example.oblig1.modelviews;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

public class MainActivity extends AppCompatActivity {

    private String TAG = this.getClass().getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle(getResources().getString(R.string.app_name) + " LiveModel");
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = findViewById(R.id.fab);
        MainActivityViewModel model = new ViewModelProvider(this).get((MainActivityViewModel.class));

        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Counting...", Snackbar.LENGTH_LONG)
                        .setAction("Action", null
                        ).show();
                Log.i(TAG, "Changing number");
                model.getNumber();
            }
        });

        TextView mTextView = findViewById(R.id.tvNumber);
        final Observer<Integer> randomObserver = new Observer<Integer>() {
            @Override
            public void onChanged(Integer newRandom) {
                mTextView.setText("Value (dynamic): " + newRandom);
            }
        };
        model.getStaticNumber().observe(this,randomObserver);
        model.getDynamicNumber().observe(this,randomObserver);

        Log.i(TAG, "Random number observers set");
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
