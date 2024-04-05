package com.example.progect7_2.Data.DataSourse.Room;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.room.Database;
import androidx.room.DatabaseConfiguration;
import androidx.room.InvalidationTracker;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteOpenHelper;

import com.example.progect7_2.Data.DataSourse.Room.DAO.ListDAO;
import com.example.progect7_2.Data.DataSourse.Room.entities.Cathegory;
import com.example.progect7_2.Data.DataSourse.Room.entities.Items;

@Database(entities = {Cathegory.class, Items.class}, version = 1 )
public abstract class Appdatabase extends RoomDatabase {
    public static Appdatabase INSTANCE;
    public abstract ListDAO listDAO();
    public static Appdatabase getINSTANCE(Context context){
        if(INSTANCE == null){
            INSTANCE = Room.databaseBuilder(context.getApplicationContext(), Appdatabase.class, "AppDb")
                    .allowMainThreadQueries()
                    .build();}

        return INSTANCE;
    }
    @Override
    public void clearAllTables() {

    }

    @NonNull
    @Override
    protected InvalidationTracker createInvalidationTracker() {
        return null;
    }

    @NonNull
    @Override
    protected SupportSQLiteOpenHelper createOpenHelper(@NonNull DatabaseConfiguration databaseConfiguration) {
        return null;
    }
}
