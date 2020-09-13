package com.example.inventory;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

@Dao
public interface ShopDAO {

    @Insert
    void insertData(Shop shopData);

    @Update
    void updateData(Shop shopData);

    @Delete
    void deleteData(Shop shopData);

    //we put list into live data to keep up with changes happens and to inform the interface with changes

    @Query("SELECT * FROM shopTable")
    LiveData<List<Shop>> getAll();

    @Query("SELECT * FROM shopTable WHERE type LIKE :typee")
    LiveData<List<Shop>> getAllOil(String typee);

    @Query("SELECT * FROM shopTable WHERE type LIKE :typee")
    LiveData<List<Shop>> getAllAccess(String typee);

    @Query("SELECT * FROM shopTable WHERE type LIKE :typee")
    LiveData<List<Shop>> getAllCotch(String typee);

    @Query("SELECT * FROM shopTable WHERE type LIKE :typee")
    LiveData<List<Shop>> getAllPieces(String typee);




}
