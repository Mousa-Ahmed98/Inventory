package com.example.inventory;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import java.util.List;

public class AddGoodViewModel extends AndroidViewModel {

    private ShopRepository shopRepository;


    public AddGoodViewModel(@NonNull Application application) {
        super(application);
        shopRepository = new ShopRepository(application);

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


}

