package com.example.progect7_2.UI_Layer.View;
import android.content.Context;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.work.Worker;
import androidx.work.WorkerParameters;

import java.util.concurrent.TimeUnit;

public class SkyWalker extends Worker {
    static final String TAG = "jedi";

    public SkyWalker(@NonNull Context context, @NonNull WorkerParameters workerParams) {
        super(context, workerParams);
    }

    @NonNull
        @Override
        public Result doWork() {
            Log.d(TAG, "UseFORSE: start");

            try {
                TimeUnit.SECONDS.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            Log.d(TAG, "UseFORSE: end");

            return Result.success();
        }
    }

