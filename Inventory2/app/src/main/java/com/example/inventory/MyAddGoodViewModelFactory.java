package com.example.inventory;

import android.app.Application;

import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

public class MyAddGoodViewModelFactory implements ViewModelProvider.Factory {
    private Application mApplication;
    private String mParam;


    public MyAddGoodViewModelFactory(Application application) {
        mApplication = application;

    }


    @Override
    public <T extends ViewModel> T create(Class<T> modelClass) {
        return (T) new AddGoodViewModel(mApplication);
    }
}
