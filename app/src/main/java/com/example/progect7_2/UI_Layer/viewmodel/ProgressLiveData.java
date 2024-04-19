/*package com.example.progect7_2.UI_Layer.viewmodel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import androidx.work.OneTimeWorkRequest;
import androidx.work.WorkManager;

import com.example.progect7_2.Data.repository.Repository;
import com.example.progect7_2.UI_Layer.View.MyWorker;

public class ProgressLiveData extends ViewModel {
    private MyWorker myWorker;
    private MutableLiveData<MyWorker> liveData;

    public ProgressLiveData(@NonNull Application application) {

        OneTimeWorkRequest workRequest = new OneTimeWorkRequest.Builder(MyWorker.class).build();
        WorkManager.getInstance(application).enqueue(workRequest);
    }
    public LiveData<String> getItem(){
        return myWorker.getMutableLiveData();
    }
}*/

