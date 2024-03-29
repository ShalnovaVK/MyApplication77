package com.example.myapplication77.viewmodel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import com.example.myapplication77.model.ListData;
import com.example.myapplication77.repository.Repository;

import java.util.List;

public class ItemsViewModel extends ViewModel {
    private Repository repository = new Repository();

    public LiveData<List<ListData>> getItems() {
        return repository.getItems();
    }
}

