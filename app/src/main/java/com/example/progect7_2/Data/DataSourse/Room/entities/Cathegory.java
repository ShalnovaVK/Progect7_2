package com.example.progect7_2.Data.DataSourse.Room.entities;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class Cathegory {
    @PrimaryKey(autoGenerate = true)
    public int uid;
    @ColumnInfo(name = "catName")
    public String catName;

    @ColumnInfo(name = "img")
    public int img;

}
