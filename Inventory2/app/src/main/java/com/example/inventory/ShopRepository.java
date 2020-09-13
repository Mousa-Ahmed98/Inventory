package com.example.inventory;

import android.app.Application;
import android.os.AsyncTask;

import androidx.lifecycle.LiveData;
import androidx.room.Room;

import java.util.List;

public class ShopRepository {

    private ShopDAO shopDAO;
    private LiveData<List<Shop>> getAllList;
    private LiveData<List<Shop>> getAllListOil;
    private LiveData<List<Shop>> getAllListAccess;
    private LiveData<List<Shop>> getAllListCotch;
    private LiveData<List<Shop>> getAllListPieces;


    public ShopRepository(Application app)
    {
        ShopDatabase shopDatabase = ShopDatabase.getINSTANCE(app);
        shopDAO = shopDatabase.shopDAO();
        getAllList = shopDAO.getAll();
        getAllListOil = shopDAO.getAllOil("زيت");
        getAllListAccess = shopDAO.getAllAccess("اكسسوار");
        getAllListCotch = shopDAO.getAllCotch("كوتش");
        getAllListPieces = shopDAO.getAllPieces("قطع غيار");

    }

    //writing operations insert, update, delete and query

    //insert
    public void insert(Shop shop)
    {
        new InsertAsyncTask(shopDAO).execute(shop);
    }

    //delete
    public void delete(Shop shop)
    {
        new DeleteAsyncTask(shopDAO).execute(shop);
    }

    //update
    public void update (Shop shop)
    {
        new UpdateAsyncTask(shopDAO).execute(shop);
    }

    //getAllData
    public LiveData<List<Shop>> getAllData()
    {
        return getAllList;
    }

    //getAllDataOil
    public LiveData<List<Shop>> getAllDataOil()
    {
        return getAllListOil;
    }

    //getAllDataAccess
    public LiveData<List<Shop>> getAllDataAccess()
    {
        return getAllListAccess;
    }

    //getAllDataCotch
    public LiveData<List<Shop>> getAllDataCotch()
    {
        return getAllListCotch;
    }

    //getAllDataPieces
    public LiveData<List<Shop>> getAllDataPieces()
    {
        return getAllListPieces;
    }








    //inserting async task
    private static class InsertAsyncTask extends AsyncTask<Shop,Void,Void>
    {
        private ShopDAO sShopDao;
        public InsertAsyncTask(ShopDAO shopDAO)
        {
            sShopDao = shopDAO;
        }
        @Override
        protected Void doInBackground(Shop... shops) {
            sShopDao.insertData(shops[0]);
            return null;
        }
    }

    //deleting async task
    private static class DeleteAsyncTask extends AsyncTask<Shop,Void,Void>
    {
        private ShopDAO sShopDao;
        public DeleteAsyncTask(ShopDAO shopDAO)
        {
            sShopDao = shopDAO;
        }
        @Override
        protected Void doInBackground(Shop... shops) {
            sShopDao.deleteData(shops[0]);
            return null;
        }
    }

    //updateing async task
    private static class UpdateAsyncTask extends AsyncTask<Shop,Void,Void>
    {
        private ShopDAO sShopDao;
        public UpdateAsyncTask(ShopDAO shopDAO)
        {
            sShopDao = shopDAO;
        }
        @Override
        protected Void doInBackground(Shop... shops) {
            sShopDao.updateData(shops[0]);
            return null;
        }
    }



}
