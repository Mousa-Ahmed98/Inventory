package com.example.inventory;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import java.util.List;

public class ShopViewModel extends AndroidViewModel {

    private ShopRepository shopRepository;

    private LiveData<List<Shop>> getAllData;
    private LiveData<List<Shop>> getAllDataOil;
    private LiveData<List<Shop>> getAllDataAccess;
    private LiveData<List<Shop>> getAllDataCotch;
    private LiveData<List<Shop>> getAllDataPieces;

    public ShopViewModel(@NonNull Application application) {
        super(application);
        shopRepository = new ShopRepository(application);
        getAllData = shopRepository.getAllData();
        getAllDataOil = shopRepository.getAllDataOil();
        getAllDataAccess = shopRepository.getAllDataAccess();
        getAllDataCotch = shopRepository.getAllDataCotch();
        getAllDataPieces = shopRepository.getAllDataPieces();

    }

    //insert
    public void insert(Shop shop)
    {
        shopRepository.insert(shop);
    }

    //update
    public void update(Shop shop)
    {
        shopRepository.update(shop);
    }

    //delete
    public void delete(Shop shop)
    {
        shopRepository.delete(shop);
    }

    //getAllData
    public LiveData<List<Shop>> getGetAllData()
    {
       return getAllData;

    }

    //getAllDataOil
    public LiveData<List<Shop>> getGetAllDataOil()
    {
        return getAllDataOil;

    }

    //getAllDataAccess
    public LiveData<List<Shop>> getGetAllDataAccess()
    {
        return getAllDataAccess;

    }

    //getAllDataCotch
    public LiveData<List<Shop>> getGetAllDataCotchh()
    {
        return getAllDataCotch;

    }

    //getAllDataOil
    public LiveData<List<Shop>> getGetAllDataPieces()
    {
        return getAllDataPieces;

    }
}
