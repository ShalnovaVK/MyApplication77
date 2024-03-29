package com.example.myapplication77.repository;

import androidx.lifecycle.LiveData;

import com.example.myapplication77.model.Item;
import com.example.myapplication77.model.ListData;

import java.util.List;

public interface DataSource {
    LiveData<List<ListData>> getItems();

    LiveData<ListData> getItem(int itemId);
}
