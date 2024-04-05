package com.example.progect7_2.Data.DataSourse.Room;

import androidx.room.Database;
import androidx.room.RoomDatabase;

import com.example.progect7_2.Data.DataSourse.Room.DAO.ListDAO;
import com.example.progect7_2.Data.DataSourse.Room.entities.Cathegory;

@Database(entities = {Cathegory.class}, version = 1)
public abstract class Appdatabase extends RoomDatabase {

    public static final String DATABASE_NAME = "List";

    public abstract ListDAO listDAO();
}