package com.example.progect7_2.Data.DataSourse.Room.entities;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;
@Entity
public class Items {
    @PrimaryKey(autoGenerate = true)
    public int uid;
    @ColumnInfo(name = "ItName")
    public String ItName;
    @ColumnInfo(name = "catId")
    public int catId;
    @ColumnInfo(name = "completed")
    public boolean completed;

}
