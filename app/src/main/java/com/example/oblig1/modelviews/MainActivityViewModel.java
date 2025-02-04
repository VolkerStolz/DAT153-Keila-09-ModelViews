package com.example.oblig1.modelviews;

import android.util.Log;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import java.util.Random;

public class MainActivityViewModel extends ViewModel {

    private String TAG = this.getClass().getSimpleName();
    Random random = new Random();
    private LiveData<Integer> myRandomNumber = new LiveData<Integer>((random.nextInt(10 - 1) + 1)) {};
    private MutableLiveData<Integer> anotherNumber = new MutableLiveData<>();

    public LiveData<Integer> getStaticNumber() {
        Log.i(TAG, "Get static number");
        return myRandomNumber;
    }
    public LiveData<Integer> getDynamicNumber() {
        Log.i(TAG, "Get dynamic number");
        return anotherNumber;
    }
    
    public void getNumber() {
        Log.i(TAG, "Get number");
        createNumber();
    }

    public void createNumber() {
        Log.i(TAG, "Created new number");
        anotherNumber.setValue(random.nextInt(10 - 1) + 1);
    }

    @Override
    protected void onCleared() {
        super.onCleared();
        Log.i(TAG, "ViewModel Destroyed");
    }
}

