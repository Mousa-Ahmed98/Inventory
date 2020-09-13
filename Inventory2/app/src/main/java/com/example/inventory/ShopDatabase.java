package com.example.inventory;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Database(entities = Shop.class, version = 1, exportSchema = false)
public abstract class ShopDatabase extends RoomDatabase {

    //making a singleton object
    private static ShopDatabase INSTANCE;

    //لربط ال روم داتا بيز نقوم بانشاء دالة تعود بقيمة الداو
    public abstract ShopDAO shopDAO();

    //creating the singleton by this function
    public static synchronized ShopDatabase getINSTANCE(Context context)
    {
        if(INSTANCE==null)
        {
            INSTANCE = Room.databaseBuilder(context.getApplicationContext(), ShopDatabase.class,"shop-database").fallbackToDestructiveMigration().build();
        }

        return INSTANCE;
    }




}
