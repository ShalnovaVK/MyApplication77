package com.example.myapplication77.repository;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.example.myapplication77.model.Item;
import com.example.myapplication77.model.ListData;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Repository {
    private DataSource dataSource = new LocalDataSource();

    public LiveData<List<ListData>> getItems() {
        return dataSource.getItems();
    }

    public LiveData<ListData> getItem(int itemId) {
        return dataSource.getItem(itemId);
    }
}

