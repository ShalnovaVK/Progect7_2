package com.example.progect7_2.Data.DataSourse.Room.DAO;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.example.progect7_2.Data.DataSourse.Room.entities.Cathegory;
import com.example.progect7_2.Data.DataSourse.Room.entities.Items;

import java.util.List;

@Dao
public interface ListDAO {
    @Query("SELECT * FROM Cathegory")
    List<Cathegory> getAllCategoriesList();

    @Insert
    void insertCategory(Cathegory... categories);
    @Delete
    void deleteCategory(Cathegory category);
    @Update
    void updateCategory(Cathegory category);
    @Query("SELECT * FROM Items WHERE catId = :catId")
    List<Items> getAllItemsList(int catId);

    @Insert
    void insertItems(Items... items);
    @Delete
    void deleteItems(Items... items);
    @Update
    void updateItems(Items... items);



}
